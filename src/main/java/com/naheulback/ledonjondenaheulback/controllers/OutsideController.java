package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OutsideController {

    @FXML
    private ImageView dungeonIV;
    @FXML
    private ImageView enterButtonIV;

    public void initialize() throws FileNotFoundException {

        System.out.println("Entered dungeon " + Game.getDungeon());

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback/dungeonImages/d";
        path += Game.getDungeon();

        InputStream stream = new FileInputStream(path + "_outside_background.png");
        Image image = new Image(stream);
        dungeonIV.setImage(image);
        stream = new FileInputStream(path + "_outside_door.png");
        image = new Image(stream);
        enterButtonIV.setImage(image);

    }

    public void onBackButtonClicked() throws IOException {

        Game.setDungeon(0);
        Game.setRoom(0);
        LoadScene.changeScene("menu-travel-map");

    }

    public void onEnterButtonClicked() throws IOException {
        LoadScene.changeScene("dungeon-entry-hall");
    }
}
