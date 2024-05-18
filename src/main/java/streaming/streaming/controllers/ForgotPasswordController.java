package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import streaming.streaming.SceneManager;
import streaming.streaming.services.ForgetPasswordService;
import streaming.streaming.services.Helper;
import streaming.streaming.services.LoginService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ForgotPasswordController implements Initializable {
    @FXML
    public Button resetButton;
    public boolean isEmailCorrect = false;
    @FXML
    public TextField emailField;
    @FXML
    public TextField newPasswordField;
    @FXML
    public TextField confirmPasswordField;
    public Button loginPageBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetButton.setOnAction(this::sendEmailVerification);
        //hide newPasswordField
        this.hidePasswords();

    }

    private void hidePasswords() {
        newPasswordField.setStyle("-fx-opacity: 0");
        confirmPasswordField.setStyle("-fx-opacity: 0");
    }
    private void showPasswords() {
        newPasswordField.setStyle("-fx-opacity: 1");
        confirmPasswordField.setStyle("-fx-opacity: 1");
    }




    public void resetPassword(ActionEvent actionEvent)  {
        String email = emailField.getText();
        String newPassword = newPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        //check if new password and confirm password are correct

        if (newPassword.isBlank() || confirmPassword.isBlank()) {
            Helper.errorMessage("Renseignez les champs mots de passes ");
        }else if (newPassword.equals(confirmPassword)) {
            //change the password
            try {
                ForgetPasswordService.resetPassword(email,newPassword);
                //alert the new password is reset
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Reset Password");
                alert.setHeaderText(null);
                alert.setContentText("Mot de passe reinitialiser avec success");
                alert.showAndWait();
                //redirect to login page
                SceneManager.changeScene(actionEvent,"Login.fxml","Login");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            //
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Les mots de passe ne correspondent pas");
            alert.showAndWait();
        }
    }
    public void sendEmailVerification(ActionEvent actionEvent) {
        //get the email
        String email = emailField.getText();
        //check into ForgotPasswordService if this email has an account

        try {
            if (LoginService.emailExists(email)){
                this.isEmailCorrect = true;
                //show the pane for password and new password
                this.showPasswords();
                //set the reset password as the action handler
                resetButton.setOnAction(this::resetPassword);
            }else {
                //fire an alert with this email not exists
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Email does not exist");
                alert.showAndWait();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToLoginPage(ActionEvent actionEvent) {
        SceneManager.changeScene(actionEvent,"Login.fxml","Login");
    }
}
