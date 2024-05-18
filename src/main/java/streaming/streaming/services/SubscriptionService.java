package streaming.streaming.services;

import streaming.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubscriptionService {
    public static int DURATION = 60;
    public static void subscribe(int subscriptionType , int userId){
        try {
            Connection connection = DatabaseConnection.getConnection();
            //
            String sql = "INSERT INTO subscriptions (user_id, subscription_type_id,duration) VALUES (?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, subscriptionType);
            preparedStatement.setInt(3, DURATION);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
