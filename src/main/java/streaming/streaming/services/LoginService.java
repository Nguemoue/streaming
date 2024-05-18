package streaming.streaming.services;

import streaming.database.DatabaseConnection;
import streaming.streaming.dataobjects.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Objects;

public class LoginService {
    public static User user;
    public static boolean login(String username, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        ResultSet resultSet = null;
        //create a statement for select user where username is email
        Statement statement = connection.createStatement();
        String query = "SELECT u.*,s.duration as subscription_duration,s.subscription_type_id,s.created_at as subscription_start_date" +
                " FROM users u left join streaming.subscriptions s on u.id = s.user_id WHERE email = '" + username + "'";
        System.out.println(query);
         resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            //check if the password is base64 hashed
            String encodedString = Base64.getEncoder().encodeToString(password.getBytes());
            user = getUser();
            user.id = resultSet.getInt("id");
            user.email = resultSet.getString("email");
            user.password = encodedString;
            user.birthDate = resultSet.getString("birthdate");
            user.rib = resultSet.getString("rib");
            user.subscriptionDuration = Objects.requireNonNullElse(resultSet.getString("subscription_duration"),"");
            user.subscriptionType = resultSet.getInt("subscription_type_id");
            user.subscriptionStartDate = Objects.requireNonNullElse(resultSet.getString("subscription_start_date"),"");
            return resultSet.getString("password").equals(encodedString);
        }

        statement.close();
        connection.close();

        return false;

    }
    public static boolean emailExists(String email) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        ResultSet resultSet = null;
        //create a statement for select user where username is email
        connection.createStatement();
        String query = "SELECT * FROM users WHERE email = '" + email + "'";
        System.out.println(query);
        resultSet = connection.createStatement().executeQuery(query);
        return resultSet.next();

    }

    public static User getUser() {
        if (user == null) {
            user = new User(-1,"","","","","","",-1);
        }
        return user;
    }
}
