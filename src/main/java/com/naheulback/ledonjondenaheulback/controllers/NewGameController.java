package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.SceneLoad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class NewGameController {

    @FXML
    public void level1ButtonClicked() throws IOException {
        Game.setLevel(1);
        SceneLoad.changeScene("display-scene");
    }

    public void level2ButtonClicked() throws IOException {
        Game.setLevel(2);
        SceneLoad.changeScene("display-scene");
    }

    public void level3ButtonClicked() throws IOException {
        Game.setLevel(3);
        SceneLoad.changeScene("display-scene");
    }

    public void level4ButtonClicked() throws IOException {
        Game.setLevel(4);
        SceneLoad.changeScene("display-scene");
    }
}
