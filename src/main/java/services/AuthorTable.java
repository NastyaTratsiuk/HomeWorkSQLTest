package services;

import aquality.selenium.browser.AqualityServices;
import models.Author;
import utils.ConnectionUtils;

import java.sql.*;

public class AuthorTable {

    static int idAuthor;

    public static int getIdAuthor() {
        return idAuthor;
    }

    public static void setIdAuthor(int idAuthor) {
        AuthorTable.idAuthor = idAuthor;
    }

    public static void insertAuthor(Author author) {
        String insertProjectTable = String.format("INSERT INTO author (name, login, email) VALUES (?,?,?);");
        PreparedStatement statement = null;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(insertProjectTable,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, author.getName());
            statement.setString(2, author.getLogin());
            statement.setString(3, author.getEmail());
            int affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                author.setId(generatedKeys.getInt(1));
                setIdAuthor(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        ConnectionUtils.quit();
    }
}
