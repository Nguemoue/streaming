package streaming.streaming.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import streaming.streaming.SceneManager;
import streaming.streaming.services.LoginService;
import streaming.streaming.services.SubscriptionService;

import java.net.URL;
import java.util.ResourceBundle;

public class PricingController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void selectPlanOne(ActionEvent actionEvent) {
        SubscriptionService.subscribe(1,LoginService.user.id);
        SceneManager.changeScene(actionEvent,"app/Home.fxml","Home");
    }

    public void selectPlanTwo(ActionEvent actionEvent) {
        //current User
        SubscriptionService.subscribe(2,LoginService.user.id);
        SceneManager.changeScene(actionEvent,"app/Home.fxml","Home");
    }

    public void selectPlanThree(ActionEvent actionEvent) {
        SubscriptionService.subscribe(3,LoginService.user.id);
        SceneManager.changeScene(actionEvent,"app/Home.fxml","Home");
    }
}
