package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;

import java.io.IOException;

public class LevelSelectController {

    @FXML
    public void level1ButtonClicked() throws IOException {
        Game.setLevel(1);
        LoadScene.changeScene("terre-fangh");
    }

    public void level2ButtonClicked() throws IOException {
        Game.setLevel(2);
        LoadScene.changeScene("terre-fangh");
    }

    public void level3ButtonClicked() throws IOException {
        Game.setLevel(3);
        LoadScene.changeScene("terre-fangh");
    }

    public void level4ButtonClicked() throws IOException {
        Game.setLevel(4);
        LoadScene.changeScene("terre-fangh");
    }
}
