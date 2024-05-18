package streaming.streaming.services;

import streaming.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {


    public static void register(String $email, String $password, String $rib, String $birthDate) throws SQLException{
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users (email, password, birthdate, rib)" +
                "values(?,?,?,?)");
        statement.setString(1, $email);
        statement.setString(2, $password);
        statement.setString(3, $rib);
        statement.setString(4, $birthDate);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
