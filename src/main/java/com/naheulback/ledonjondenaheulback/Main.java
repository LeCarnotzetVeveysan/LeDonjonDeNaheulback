package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.controllers.MainMenuController;
import javafx.stage.Stage;

import java.io.IOException;

public class Main {

    public Main(){}

    public void startMain() throws IOException {

        SceneLoad sl = new SceneLoad();
        Stage stage = new Stage();

        SceneLoad.initUI(stage, "main-menu");

        Game game = new Game();
        game.printText();




    }

}
