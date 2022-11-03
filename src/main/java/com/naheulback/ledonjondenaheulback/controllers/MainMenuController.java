package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.heroClasses.TestChar;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    protected void onQuitButtonClick() {

        Platform.exit();

    }

    public void onInstructionsButtonClick() {
    }

    public void onNewGameButtonClick() {
    }

    public void onSavedGameButtonClick() {
    }
}
