package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class HomeController implements Initializable {


    @FXML
    public Pane headerPane;
    @FXML
    public Button logoutButton;
    @FXML

    public Button filmBtn;
    @FXML
    public Label label;

    @FXML
    public VBox pnl_scroll;

    @FXML
    public void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filmBtn.setStyle("-fx-background-color: #cfe;");
    }

    private void refreshNodes() {

    }

    public void logout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.close();
        }
        System.out.println("Lg out");
    }
}
