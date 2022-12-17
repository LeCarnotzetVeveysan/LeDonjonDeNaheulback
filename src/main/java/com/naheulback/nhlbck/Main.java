package com.naheulback.nhlbck;

import javafx.stage.Stage;

import java.io.IOException;

public class Main {

    private final Stage mainStage;

    public Main(Stage inputStage){ mainStage = inputStage; }

    public void startMain() throws IOException {
        Game mainGame = new Game(mainStage);
        mainGame.main();
    }
}
