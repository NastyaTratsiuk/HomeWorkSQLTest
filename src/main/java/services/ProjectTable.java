package services;

import aquality.selenium.browser.AqualityServices;
import models.Project;
import org.checkerframework.checker.units.qual.C;
import utils.ConnectionUtils;

import java.sql.*;

public class ProjectTable {

    static int idProject;

    public static int getIdProject() {
        return idProject;
    }

    public static void setIdProject(int idProject) {
        ProjectTable.idProject = idProject;
    }

    public static void insertProject(Project project) {
        String insertProjectTable = "INSERT INTO project (name) VALUES (?);";
        PreparedStatement statement = null;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(insertProjectTable,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, project.getName());
            int affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                project.setId(generatedKeys.getInt(1));
                setIdProject(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
    }
}


