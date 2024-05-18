package streaming.streaming.services;

import streaming.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class ForgetPasswordService {
    public static void resetPassword(String email, String password) throws SQLException {
        String encodedString = Base64.getEncoder().encodeToString(password.getBytes());
        Connection connection = DatabaseConnection.getConnection();
        String query = "update users set password = ?  WHERE email = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, encodedString);
        st.setString(2, email);
        st.executeUpdate();
        st.close();
        connection.close();

    }
}
