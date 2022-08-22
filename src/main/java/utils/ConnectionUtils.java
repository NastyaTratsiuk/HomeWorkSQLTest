package utils;

import aquality.selenium.browser.AqualityServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(Config.connectionUrl, Config.userName, Config.password);
                Class.forName("com.mysql.cj.jdbc.Driver");
                AqualityServices.getLogger().info("Connected to the database.");
            } catch (ClassNotFoundException | SQLException e) {
                AqualityServices.getLogger().debug(e.getMessage());
            }
        }
        return connection;
    }

    public static void quit() {
        if (connection != null) {
            try {
                connection.close();
                AqualityServices.getLogger().info("Connection close.");
            } catch (SQLException e) {
                AqualityServices.getLogger().debug(e.getMessage());
            }
        }
    }
}
