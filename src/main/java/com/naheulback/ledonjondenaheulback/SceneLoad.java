package com.naheulback.ledonjondenaheulback;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoad {

    private static Stage principalStage;

    public SceneLoad(Stage inputStage){

        this.principalStage = inputStage;

    }

    public static void initUI(String fxmlToShow) throws IOException {

        fxmlToShow += ".fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource(fxmlToShow));

        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        principalStage.setTitle("Le Donjon de Naheulback v1.0");
        principalStage.setScene(scene);
        principalStage.show();

    }

}
