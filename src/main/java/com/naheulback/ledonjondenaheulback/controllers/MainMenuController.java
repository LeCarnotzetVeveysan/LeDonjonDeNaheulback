package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.SceneLoad;
import com.naheulback.ledonjondenaheulback.heroClasses.TestChar;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    protected void onQuitButtonClick() {

        Platform.exit();

    }

    public void onInstructionsButtonClick() throws IOException {
        SceneLoad.initUI("instructions-page");
    }

    public void onNewGameButtonClick() throws IOException {
        SceneLoad.initUI("new-game");
    }

    public void onSavedGameButtonClick() {
    }
}
