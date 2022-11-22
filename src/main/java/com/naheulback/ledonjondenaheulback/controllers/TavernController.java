package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Functions;
import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class TavernController {

    @FXML
    private ImageView mainIV;



    public void initialize() throws IOException {

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback/dungeonImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_tavern_background.png");
        Image image = new Image(stream);
        mainIV.setImage(image);

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

    public void onBarButtonClicked(MouseEvent mouseEvent) throws IOException {
        LoadScene.changeScene("dungeon-bar");
    }
}
