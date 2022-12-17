package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.LoadScene;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.naheulback.nhlbck.Functions.*;

public class MainMenuController {

    public Button newGameButton;
    @FXML
    private ImageView newGameBtnIV, instructionsBtnIV, quitBtnIV;

    public void initialize() {
    }

    public void onNewGameBtnClk() throws IOException {
        initTableFiles();
        initHeroFiles();
        initDungeonFiles();
        LoadScene.changeScene("menu-level-select");
    }

    public void onInstructionsBtnClk() throws IOException {
        LoadScene.changeScene("menu-instructions");
    }

    @FXML
    protected void onQuitBtnClk() {
        Platform.exit();
    }

    @FXML
    public void onNewGameBtnHov() throws FileNotFoundException {
        Functions.setImage(newGameBtnIV, "menuImages", "newgameinv");
    }

    @FXML
    public void onNewGameBtnHovEnd() throws FileNotFoundException {
        Functions.setImage(newGameBtnIV, "menuImages", "newgame");
    }

    @FXML
    public void onInstructionsBtnHov() throws FileNotFoundException {
        Functions.setImage(instructionsBtnIV, "menuImages", "instructionsinv");
    }

    @FXML
    public void onInstructionsBtnHovEnd() throws FileNotFoundException {
        Functions.setImage(instructionsBtnIV, "menuImages", "instructions");
    }

    @FXML
    public void onQuitBtnHov() throws FileNotFoundException {
        Functions.setImage(quitBtnIV, "menuImages", "quitinv");
    }

    @FXML
    public void onQuitBtnHovEnd() throws FileNotFoundException {
        Functions.setImage(quitBtnIV, "menuImages", "quit");
    }


}
