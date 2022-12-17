package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.PlayerData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.naheulback.nhlbck.Functions.*;

public class MainMenuController {

    @FXML
    private ImageView newGameBtnIV, instructionsBtnIV, quitBtnIV;
    @FXML
    private Label mainLabel;

    public void initialize() throws FileNotFoundException {

        String resPath = "src/main/resources/com/naheulback/nhlbck";
        Font folkard90 = Font.loadFont(new FileInputStream(resPath + "/fonts/folkard.ttf"), 90);
        Font folkard45 = Font.loadFont(new FileInputStream(resPath + "/fonts/folkard.ttf"), 45);
        if(PlayerData.getIsDefeated()){
            mainLabel.setText("Malheureusement, ta quete s'arrete ici.\nVeux-tu retenter ta chance ?");
            mainLabel.setFont(folkard45);
            mainLabel.setLayoutX(125);
        } else {
            if(PlayerData.getHasSucceeded()){
                mainLabel.setText("Felicitations. Tu as passe les 10 donjons.\nOn augmente la difficulte ?");
                mainLabel.setFont(folkard45);
                mainLabel.setLayoutX(100);
            } else {
                mainLabel.setText("LE DONJON DE\nNAHEULBACK");
                mainLabel.setFont(folkard90);
                mainLabel.setLayoutX(175);
            }

        }
        mainLabel.setTextFill(Color.BLACK);
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
