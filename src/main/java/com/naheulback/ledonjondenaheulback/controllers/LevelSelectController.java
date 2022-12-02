package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.GameData;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LevelSelectController {

    private String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback";
    @FXML
    private Label titleLabel, level1Lbl, level2Lbl, level3Lbl, level4Lbl;

    public void initialize() throws IOException {

        Font folkard = Font.loadFont(new FileInputStream(resPath + "/fonts/folkard.ttf"), 90);
        Font augusta = Font.loadFont(new FileInputStream(resPath + "/fonts/augusta.ttf"), 20);

        titleLabel.setText("CHOIX DU NIVEAU");
        titleLabel.setFont(folkard);
        level1Lbl.setText("Difficulté: Facile\nHéros max: 6\nPièces d'or: 2000\nForce ennemie: x1\nGain d'XP: x1");
        level1Lbl.setFont(augusta);
        level2Lbl.setText("Difficulté: Moyen\nHéros max: 4\nPièces d'or: 1500\nForce ennemie: x1.5\nGain d'XP: x1.25");
        level2Lbl.setFont(augusta);
        level3Lbl.setText("Difficulté: Difficile\nHéros max: 3\nPièces d'or: 1000\nForce ennemie: x2\nGain d'XP: x1.5");
        level3Lbl.setFont(augusta);
        level4Lbl.setText("Difficulté: Expert\nHéros max: 1\nPièces d'or: 500\nForce ennemie: x3\nGain d'XP: x1.5");
        level4Lbl.setFont(augusta);

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
