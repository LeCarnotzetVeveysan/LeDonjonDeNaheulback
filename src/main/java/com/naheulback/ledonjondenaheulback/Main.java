package com.naheulback.ledonjondenaheulback;

import javafx.stage.Stage;

import java.io.IOException;

public class Main {

    public Main(){}

    public void startMain() throws IOException {

        SceneLoad sl = new SceneLoad();

        Game game = new Game();
        game.printText();

        SceneLoad.initUI(new Stage());

    }

}
