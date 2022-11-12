package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.GameData;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import javafx.fxml.FXML;

import java.io.IOException;

public class LevelSelectController {

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
