package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.SceneLoad;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {

    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }

    public void onInstructionsButtonClick() throws IOException {
        SceneLoad.changeScene("instructions-page");
    }

    public void onNewGameButtonClick() throws IOException {
        SceneLoad.changeScene("new-game");
    }

    public void onSavedGameButtonClick() {

        System.out.println(Game.getLevel());

    }
}
