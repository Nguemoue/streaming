package streaming.streaming;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public static void changeScene(ActionEvent actionEvent,String fxmlFile,String title) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlFile));
            root = loader.load();
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root,800,400));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
