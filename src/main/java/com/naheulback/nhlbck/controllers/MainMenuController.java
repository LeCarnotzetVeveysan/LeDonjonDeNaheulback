package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.GameData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.naheulback.nhlbck.Functions.*;

public class MainMenuController {

    boolean menuVisible = false;
    @FXML
    private StackPane typeSoundSP, saveSP;
    @FXML
    private RadioButton alphaBtn, betaBtn, finalBtn;
    @FXML
    private ImageView newGameBtnIV;


    public void initialize() {
        updateMenuVisibility();
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
        initDungeonFiles();
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

    public void onAlphaBtnClk() {
        GameData.setPictureType("Alpha");
        betaBtn.setSelected(false);
        finalBtn.setSelected(false);
    }

    public void onBetaBtnClk() {
        GameData.setPictureType("Beta");
        alphaBtn.setSelected(false);
        finalBtn.setSelected(false);
    }

    public void onFinalBtnClick() {
        GameData.setPictureType("Final");
        alphaBtn.setSelected(false);
        betaBtn.setSelected(false);

    }

    public void onSettingsBtnClk() {
        menuVisible = !menuVisible;
        updateMenuVisibility();
    }

    private void updateMenuVisibility(){
        typeSoundSP.setVisible(menuVisible);
        typeSoundSP.setDisable(!menuVisible);
        saveSP.setVisible(menuVisible);
        saveSP.setDisable(!menuVisible);

    }
}
