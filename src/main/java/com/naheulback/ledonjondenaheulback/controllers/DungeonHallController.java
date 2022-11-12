package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DungeonHallController {

    @FXML
    private ImageView mainIV;

    public void initialize() throws FileNotFoundException {

        System.out.println("Entered dungeon " + Game.getDungeon());

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback/dungeonImages";

        switch (Game.getDungeon()){

            case 1:

                InputStream stream = new FileInputStream(path + "/d1_hall_background.png");
                Image image = new Image(stream);
                mainIV.setImage(image);


        }

    }

    public void onDungeonButtonClick() throws IOException {

        if(Game.getDungeon() == 10){

            LoadScene.changeScene("dungeon-boss-floor");

        } else {

            LoadScene.changeScene("dungeon-simple-floor");
        }





    }

    public void onTavernButtonClicked() throws IOException {
        LoadScene.changeScene("dungeon-tavern");
    }

    public void onArmouryButtonClicked() throws IOException {

        LoadScene.changeScene("dungeon-armoury");

    }
}
