package services;

import aquality.selenium.browser.AqualityServices;
import models.Session;
import utils.Config;
import utils.ConnectionUtils;

import java.sql.*;

public class SessionTable {

    private static int idSession;

    public static int getIdSession() {
        return idSession;
    }

    public static void setIdSession(int idSession) {
        SessionTable.idSession = idSession;
    }

    public static void insertSession( Session session) {
        String insertProjectTable = "INSERT INTO project (session_key, created_time, build_number) " +
                "VALUES (?, ?, ?);";
        PreparedStatement statement = null;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(insertProjectTable,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, session.getSessionKey());
            statement.setTimestamp(2, session.getCratedTime());
            statement.setInt(3, Integer.parseInt(Config.sessionNumber));
            int affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                session.setId(generatedKeys.getInt(1));
                setIdSession(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
    }
}
