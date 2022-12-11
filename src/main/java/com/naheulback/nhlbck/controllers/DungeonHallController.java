package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.naheulback.nhlbck.Game.getDungeon;
import static com.naheulback.nhlbck.LoadScene.changeScene;

public class DungeonHallController {

    @FXML
    private ImageView mainIV;

    public void initialize() throws FileNotFoundException {
        Functions.setImage(mainIV, "dungeonImages", "d" + getDungeon() + "_hall_background");
    }

    public void onDungeonButtonClick() throws IOException {

        if(Game.getDungeon() == 10){
            changeScene("dungeon-boss-floor");
        } else {
            changeScene("dungeon-simple-floor");
        }
    }

    public void onTavernButtonClicked() throws IOException {
        changeScene("dungeon-tavern");
    }

    public void onArmouryButtonClicked() throws IOException {
        changeScene("dungeon-armoury");
    }

    public void onBackButtonClicked() throws IOException {
        changeScene("dungeon-outside");
    }
}
