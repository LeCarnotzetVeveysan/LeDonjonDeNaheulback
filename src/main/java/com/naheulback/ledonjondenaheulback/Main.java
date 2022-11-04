package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.controllers.MainMenuController;
import javafx.stage.Stage;

import java.io.IOException;

public class Main {

    private Stage mainStage;

    public Main(Stage inputStage){

        this.mainStage = inputStage;

    }

    public void startMain() throws IOException {

        SceneLoad sl = new SceneLoad(this.mainStage);
        sl.initUI("main-menu");

        Game game = new Game();

    }

}
