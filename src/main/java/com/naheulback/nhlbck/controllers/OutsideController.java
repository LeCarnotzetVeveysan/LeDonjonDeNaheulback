package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.naheulback.nhlbck.Functions.setImage;

public class OutsideController {

    @FXML
    private ImageView mainIV;
    @FXML
    private ImageView enterButtonIV;

    public void initialize() throws FileNotFoundException {

        setImage(mainIV, "dungeonImages", "d" + Game.getDungeon() + "_outside_background" );
        setImage(enterButtonIV, "dungeonImages", "d" + Game.getDungeon() + "_outside_door");

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
