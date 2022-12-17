package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.naheulback.nhlbck.Functions.setImage;

public class TavernController {

    @FXML
    private ImageView mainIV;



    public void initialize() throws IOException {
        setImage(mainIV,"dungeonImages","tavern_background");
    }

    public void onTable1ButtonClicked() throws IOException {

        Game.setTable(1);
        LoadScene.changeScene("dungeon-table");

    }

    public void onTable2ButtonClicked() throws IOException {

        Game.setTable(2);
        LoadScene.changeScene("dungeon-table");

    }

    public void onTable3ButtonClicked() throws IOException {

        Game.setTable(3);
        LoadScene.changeScene("dungeon-table");

    }

    public void onBarButtonClicked() throws IOException {
        LoadScene.changeScene("dungeon-bar");
    }

    public void onBackButtonClicked() throws IOException {
        LoadScene.changeScene("dungeon-entry-hall");
    }
}
