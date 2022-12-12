package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.LoadScene;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.naheulback.nhlbck.Functions.initHeroFiles;
import static com.naheulback.nhlbck.Functions.initTableFiles;

public class MainMenuController {

    @FXML
    private ImageView newGameBtnIV;

    public void initialize() {
        //System.out.println("Main menu entered");
    }
    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }

    public void onInstructionsButtonClick() throws IOException {
        LoadScene.changeScene("menu-instructions");
    }

    public void onNewGameButtonClick() throws IOException {
        initTableFiles();
        initHeroFiles();
        LoadScene.changeScene("menu-level-select");
    }

    public void onSavedGameButtonClick() {
        //System.out.println(Game.getLevel());
    }

    @FXML
    public void startedHovering() throws FileNotFoundException {
        Functions.setImage(newGameBtnIV, "menuImages", "newgameinv");
    }

    @FXML
    public void stoppedHovering() throws FileNotFoundException {
        Functions.setImage(newGameBtnIV, "menuImages", "newgame");
    }
}
