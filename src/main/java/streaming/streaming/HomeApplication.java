package streaming.streaming;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.sql.*;
import javafx.scene.media.MediaPlayer;


import streaming.database.DatabaseConnection;
import streaming.streaming.controllers.LoginController;

import java.io.IOException;


public class HomeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        //loading loader
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("app/Home.fxml"));
        Parent root = fxmlLoader.load();

        try {
            Scene scene = new Scene(root,800,600);
            stage.setTitle("Login Page!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

    }
}
