package streaming.streaming.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TemplateController {
    @FXML
    private VBox contentArea;

    @FXML
    private Label headerLabel;

    public void setContentArea(Node node) {
        contentArea.getChildren().setAll(node);
    }

    public void setHeaderLabel(String text) {
        headerLabel.setText(text);
    }
}
