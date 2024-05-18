package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import streaming.streaming.Film;
import streaming.streaming.SceneManager;
import streaming.streaming.services.FilmService;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
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
    public Button addFilm;
    @FXML
    public Label label;

    @FXML
    public VBox pnl_scroll;
    @FXML
    public TableColumn<Film, String> descriptionColumn;
    @FXML
    public TableColumn<Film, Integer> ageMinColumn;
    @FXML
    public TableColumn<Film, Integer> dureColumn;
    @FXML
    public TableColumn<Film, Date> dateSortieColumn;
    @FXML
    public TableColumn<Film, String> bandeAnnounce;
    @FXML
    public TableColumn<Film, String> nomColumn;
    @FXML
    public TableColumn<Film, Integer> idColumn;
    @FXML
    public TableView<Film> tableFilm;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        filmBtn.setStyle("-fx-background-color: #cfe;");
        loadDate();
        this.refreshFilms();
    }


    @FXML
    private void getAddView() {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(SceneManager.class.getResource("AddFilm.fxml")));
            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void refreshFilms(){
        List<Film> filmList =  FilmService.listFilms();
        for (Film film : filmList) {
            tableFilm.getItems().add(film);
        }
    }
    private void loadDate() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        ageMinColumn.setCellValueFactory(new PropertyValueFactory<>("ageMin"));
        dureColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        dateSortieColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        bandeAnnounce.setCellValueFactory(new PropertyValueFactory<>("trailer"));

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
