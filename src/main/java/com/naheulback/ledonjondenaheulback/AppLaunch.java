package com.naheulback.ledonjondenaheulback;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class AppLaunch extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Stage mainStage = new Stage();
        mainStage.setResizable(false);
        Main main = new Main(mainStage);
        main.startMain();

    }

    public static void main(String[] args) {
        launch();
    }
}