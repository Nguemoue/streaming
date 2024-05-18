package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.MediaView;
import streaming.streaming.SceneManager;
import streaming.streaming.services.Helper;
import streaming.streaming.services.LoginService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public Button registerBtn;
    @FXML
    public Button loginBtn;
    public MediaView mediaView;
    public Hyperlink forgotPasswordBtn;

    @FXML
    public void login(ActionEvent event) {
        //check if data is present in database
        try {
            if (LoginService.login(username.getText(), password.getText())) {
                //TODO got to home page
                Helper.successMessage("Login Successful");
                //check if the users has subscription plan
                if (LoginService.user.subscriptionType == 0){
                    SceneManager.changeScene(event, "pricing.fxml", "Subscribe Page");
                }else {
                    //go to pricing page
                    SceneManager.changeScene(event, "app/Home.fxml", "Home Page");
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login failed");
                alert.setHeaderText(null);
                alert.setContentText("Identifiants ou mot de passe incorrect");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //else fire and alert error message
    }

    @FXML
    public void openRegisterPage(ActionEvent event) {
        SceneManager.changeScene(event, "Register.fxml", "Register Page");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBtn.setOnAction(this::login);
        registerBtn.setOnAction(this::openRegisterPage);

    }

    public void openForgotPasswordPage(ActionEvent actionEvent) {
        SceneManager.changeScene(actionEvent, "ForgotPassword.fxml", "Forget password Page");
    }
}
