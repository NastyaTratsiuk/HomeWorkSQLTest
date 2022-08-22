package services;

import aquality.selenium.browser.AqualityServices;
import models.Test;
import utils.Config;
import utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestTable {

    public static List<Test> listsAfterIResultTest = new ArrayList<>();
    public static List<Test> listForUpdateAndDeleteAfterInput = new ArrayList<>();

    public static int insertTest(Test test) {
        String insertTestTable = "INSERT INTO test (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = null;
        int affectedRows = 0;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(insertTestTable);
            statement.setString(1, test.getName());
            statement.setInt(2, test.getStatusId());
            statement.setString(3, test.getMethodName());
            statement.setInt(4, test.getProjectId());
            statement.setInt(5, test.getStatusId());
            statement.setTimestamp(6, test.getStartTime());
            statement.setTimestamp(7, test.getEndTime());
            statement.setString(8, test.getEnv());
            statement.setString(9, test.getBrowser());
            statement.setInt(10, test.getAuthorId());
            affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
        return affectedRows;
    }

    public static List<Test> getAllTest() {
        final String selectAllSql = "SELECT * FROM test;";
        Statement statement = null;
        List<Test> listTests = new ArrayList<>();
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(selectAllSql);
            final ResultSet selectAllRs = statement.executeQuery(selectAllSql);
            while (selectAllRs.next()) {
                Test test = new Test(
                        selectAllRs.getInt("id"),
                        selectAllRs.getString("name"),
                        selectAllRs.getInt("status_id"),
                        selectAllRs.getString("method_name"),
                        selectAllRs.getInt("project_id"),
                        selectAllRs.getInt("session_id"),
                        selectAllRs.getTimestamp("start_time"),
                        selectAllRs.getTimestamp("end_time"),
                        selectAllRs.getString("env"),
                        selectAllRs.getString("browser"),
                        selectAllRs.getInt("author_id"));
                listTests.add(test);
            }
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
        return listTests;
    }

    public static void insertSortListTests( List<Test> lists) {
        for (Test test : lists) {
            Test newTest = new Test(test.getName(), test.getStatusId(),
                    test.getMethodName(), ProjectTable.getIdProject(), test.getSessionId(), test.getStartTime(),
                    test.getEndTime(), test.getEnv(), test.getBrowser(), AuthorTable.getIdAuthor());
            TestTable.insertTest(newTest);
        }
    }

    public static int updateTest(Test test) {
        String insertTestTable = "UPDATE test SET name = ?, status_id = ?, method_name = ?, project_id = ?, session_id = ?," +
                " start_time = ?, end_time = ? , env = ?, browser = ?, author_id = ? WHERE id = ?;";
        PreparedStatement statement = null;
        int affectedRows = 0;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(insertTestTable);
            statement.setString(1, test.getName());
            statement.setInt(2, test.getStatusId());
            statement.setString(3, test.getMethodName());
            statement.setInt(4, test.getProjectId());
            statement.setInt(5, test.getStatusId());
            statement.setTimestamp(6, test.getStartTime());
            statement.setTimestamp(7, test.getEndTime());
            statement.setString(8, test.getEnv());
            statement.setString(9, test.getBrowser());
            statement.setInt(10, test.getAuthorId());
            statement.setInt(11, test.getId());
            affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
        return affectedRows;
    }

    public static Integer deleteTest(Test test) {
        String insertTestTable = "DELETE FROM test WHERE id = ?;";
        PreparedStatement statement = null;
        int affectedRows = 0;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(insertTestTable);
            statement.setInt(1, test.getId());
            affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
        return affectedRows;
    }

    public static List<Test> listTestsForUpdateDelete(List<Test> list) {
        System.out.println(list.size());
        int startId = list.size() - Config.sizeSortList;
        for (int i = startId; i < list.size(); i++) {
            listForUpdateAndDeleteAfterInput.add(list.get(i));
        }
        return listForUpdateAndDeleteAfterInput;
    }

    public static void updateTestAfterIResultTest(List<Test> list, List<Test> listUpdate) {
        for (Test test : list) {
            for (Test newTest : listUpdate) {
                Test testUpdate = new Test(test.getId(), newTest.getName(), newTest.getStatusId(), newTest.getMethodName(),
                        newTest.getProjectId(), newTest.getSessionId(), newTest.getStartTime(),
                        newTest.getEndTime(), newTest.getEnv(), newTest.getBrowser(), newTest.getAuthorId());
                updateTest(testUpdate);
                break;
            }
        }
    }
}


