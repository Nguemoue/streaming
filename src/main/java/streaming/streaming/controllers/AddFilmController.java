package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import streaming.streaming.Film;
import streaming.streaming.services.FilmService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class AddFilmController implements Initializable {

    @FXML
    public TextField duree;
    @FXML
    public TextField bandeAnonce;
    @FXML
    public TextField aneeSortie;
    @FXML
    public TextField ageMin;
    @FXML
    public TextField description;
    @FXML
    public TextField nom;
    @FXML
    public Button submitBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submitBtn.setOnAction(this::storeQuestion);
    }

    private void storeQuestion(ActionEvent event){
        String name = nom.getText();
        String releaseYear = aneeSortie.getText();
        int age = Integer.parseInt(ageMin.getText());
        String descriptionText = description.getText();
        String trailer = (bandeAnonce.getText());
        int duration = Integer.parseInt(duree.getText());
        Film film = new Film(name,descriptionText,age,duration,age,trailer);
        FilmService.storeFilm(film);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Film added successfully");
        alert.showAndWait();

    }
}
