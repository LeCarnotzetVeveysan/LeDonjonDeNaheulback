package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.GameData;
import com.naheulback.nhlbck.classes.PlayerData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;

public class LevelSelectController {

    @FXML
    private Label titleLabel, level1Lbl, level2Lbl, level3Lbl, level4Lbl;

    public void initialize() throws IOException {

        String resPath = "src/main/resources/com/naheulback/nhlbck";
        Font folkard = Font.loadFont(new FileInputStream(resPath + "/fonts/folkard.ttf"), 90);
        Font candlebright = Font.loadFont(new FileInputStream(resPath + "/fonts/candlebright.ttf"), 20);

        titleLabel.setText("CHOIX DU NIVEAU");
        titleLabel.setFont(folkard);
        titleLabel.setTextFill(Color.BLACK);

        level1Lbl.setText("Difficulte: Facile\nHeros max: 6\nPieces d'or: 2000\nForce ennemie: x1\nRecompenses: x1");
        level1Lbl.setFont(candlebright);
        level2Lbl.setText("Difficulte: Moyen\nHeros max: 4\nPieces d'or: 1500\nForce ennemie: x1.5\nRecompenses: x1.25");
        level2Lbl.setFont(candlebright);
        level3Lbl.setText("Difficulte: Difficile\nHeros max: 3\nPieces d'or: 1000\nForce ennemie: x2\nRecompenses: x1.5");
        level3Lbl.setFont(candlebright);
        level4Lbl.setText("Difficulte: Expert\nHeros max: 1\nPieces d'or: 500\nForce ennemie: x3\nRecompenses: x1.5");
        level4Lbl.setFont(candlebright);
    }

    @FXML
    public void level1ButtonClicked() throws IOException {
        Game.setLevel(1);
        GameData.setMaxHeroes();
        PlayerData.initGoldPieces();
        LoadScene.changeScene("menu-travel-map");
    }

    public void level2ButtonClicked() throws IOException {
        Game.setLevel(2);
        GameData.setMaxHeroes();
        PlayerData.initGoldPieces();
        LoadScene.changeScene("menu-travel-map");
    }

    public void level3ButtonClicked() throws IOException {
        Game.setLevel(3);
        GameData.setMaxHeroes();
        PlayerData.initGoldPieces();
        LoadScene.changeScene("menu-travel-map");
    }

    public void level4ButtonClicked() throws IOException {
        Game.setLevel(4);
        GameData.setMaxHeroes();
        PlayerData.initGoldPieces();
        LoadScene.changeScene("menu-travel-map");
    }
}
