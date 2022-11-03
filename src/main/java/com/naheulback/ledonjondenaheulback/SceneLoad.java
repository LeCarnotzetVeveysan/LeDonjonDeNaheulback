package com.naheulback.ledonjondenaheulback;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoad {

    public static void initUI(Stage stage, String fxmlToShow) throws IOException {

        fxmlToShow += ".fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource(fxmlToShow));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("Le Donjon de Naheulback v1.0");
        stage.setScene(scene);
        stage.show();

    }

}
