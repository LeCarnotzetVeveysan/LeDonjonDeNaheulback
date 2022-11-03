package com.naheulback.ledonjondenaheulback;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppLaunch extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Main main = new Main();
        main.startMain();

    }



    public static void main(String[] args) {

        launch();

    }
}