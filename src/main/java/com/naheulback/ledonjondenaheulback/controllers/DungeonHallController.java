package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DungeonHallController {

    @FXML
    private ImageView mainIV;

    public void initialize() throws FileNotFoundException {

        System.out.println("Entered dungeon " + Game.getZone());

        switch (Game.getZone()){

            case 1:
                String path = "src/main/resources/com/naheulback/ledonjondenaheulback";
                InputStream stream = new FileInputStream(path + "/otherImages/donj1hall.png");
                Image image = new Image(stream);
                mainIV.setImage(image);


        }

    }

}
