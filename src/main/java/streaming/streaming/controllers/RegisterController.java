package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import streaming.streaming.SceneManager;
import streaming.streaming.services.Helper;
import streaming.streaming.services.RegisterService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    public Button btnLogin;
    @FXML
    public Button btnRegister;
    @FXML
    public DatePicker birthDateField;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField ribField;
    @FXML
    public TextField emailField;

    @FXML
    public void backToLogin(ActionEvent event)
    {
        SceneManager.changeScene(event,"Login.fxml","Login Page");
    }
    @FXML
    public void register(ActionEvent event){
        String email = emailField.getText();
        String password = passwordField.getText();
        String birthDate = birthDateField.getValue().toString();
        String rib = ribField.getText();
        String errorMsg = "";
        //register this user to database
        try {
            if (email.isEmpty() || password.isEmpty() || birthDate.isEmpty() || rib.isEmpty() ){
                errorMsg = "Please fill all fields";
            }
            if (!email.isBlank() && !Helper.validateEmail(email)) {
                errorMsg = "The email is invalid!";
            }
            if (errorMsg.isBlank()){
                RegisterService.register(email, password, birthDate, rib);
                Helper.successMessage("Successfully registered");
                //go to login page
                SceneManager.changeScene(event,"Login.fxml","Login Page");
            }else {
                //alert to fill all field
                Helper.errorMessage(errorMsg);
            }

        }catch (SQLException exception){
            //show an alert
            Helper.errorMessage(exception.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set de birthdate default to -20 years
        birthDateField.setValue(LocalDate.now());
        btnLogin.setOnAction(this::backToLogin);
        btnRegister.setOnAction(this::register);
    }
}
