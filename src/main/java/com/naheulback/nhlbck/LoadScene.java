package com.naheulback.nhlbck;

import com.naheulback.nhlbck.AppLaunch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadScene {

    private static Stage principalStage;

    public LoadScene(Stage inputStage){

        principalStage = inputStage;

    }

    public static void changeScene(String fxmlToShow) throws IOException {

        String file = fxmlToShow + ".fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource(file));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);

        principalStage.setTitle("Le Donjon de Naheulback v1.0");
        principalStage.setScene(scene);
        principalStage.show();

    }

}
