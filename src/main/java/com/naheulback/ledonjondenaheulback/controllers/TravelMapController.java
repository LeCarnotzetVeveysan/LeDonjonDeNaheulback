package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TravelMapController {

    @FXML
    private ImageView donj4InfosIV;

    public void initialize() throws FileNotFoundException {

        donj4InfosIV.setVisible(false);

    }
    public void onDonj1ButtonClicked() throws IOException {

        Game.setDungeon(1);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");

    }

    public void onDonj2ButtonClicked() throws IOException {

        Game.setDungeon(2);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");

    }

    public void onDonj4ButtonHover() {

        donj4InfosIV.setVisible(true);
    }

    public void onDonj4ButtonStoppedHover() {

        donj4InfosIV.setVisible(false);
    }
}
