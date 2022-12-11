package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OutsideController {

    @FXML
    private ImageView mainIV;
    @FXML
    private ImageView enterButtonIV;

    public void initialize() throws FileNotFoundException {

        System.out.println("Entered dungeon " + Game.getDungeon());

        String path = "src/main/resources/com/naheulback/nhlbck/dungeonImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_outside_background.png");
        Image image = new Image(stream);
        mainIV.setImage(image);

        stream = new FileInputStream(path + Game.getDungeon() + "_outside_door.png");
        image = new Image(stream);
        enterButtonIV.setImage(image);

    }

    public void onBackButtonClicked() throws IOException {

        Game.setDungeon(0);
        Game.setRoom(0);
        Game.setTable(0);
        LoadScene.changeScene("menu-travel-map");

    }

    public void onEnterButtonClicked() throws IOException {
        LoadScene.changeScene("dungeon-entry-hall");
    }
}
