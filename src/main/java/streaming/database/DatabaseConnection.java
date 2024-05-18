package streaming.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/streaming";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Instance unique de la connexion
    private static Connection connection;

    // Méthode pour obtenir l'instance de la connexion
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
