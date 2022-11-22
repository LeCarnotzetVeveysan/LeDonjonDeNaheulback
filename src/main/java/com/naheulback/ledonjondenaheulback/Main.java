package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.controllers.MainMenuController;
import javafx.stage.Stage;

import java.io.IOException;

public class Main {

    private Stage mainStage;

    public Main(Stage inputStage){

        mainStage = inputStage;

    }

    public void startMain() throws IOException {

        Game mainGame = new Game(mainStage);
        mainGame.main();
        //implémenter jeu avec images alpha et bonnes images

    }

}
