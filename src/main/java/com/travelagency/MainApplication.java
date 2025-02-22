package com.travelagency;


import com.travelagency.model.TravelAgencyService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApplication extends Application {

    private final TravelAgencyService tas = new TravelAgencyService();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/travelagency/view/main.fxml"));
        Parent root = fxmlLoader.load();
        MainController controller = fxmlLoader.getController();

        controller.setTravelAgencyService(tas);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Travel Agency");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}