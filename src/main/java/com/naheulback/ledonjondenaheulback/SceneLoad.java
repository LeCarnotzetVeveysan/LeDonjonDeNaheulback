package com.naheulback.ledonjondenaheulback;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoad {

    public static void initUI(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

}
