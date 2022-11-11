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

public class OutsideController {

    @FXML
    private ImageView dungeonIV;

    public void initialize() throws FileNotFoundException {

        System.out.println("Entered new dungeon");

        switch (Game.getZone()){

            case 0:
                String path = "src/main/resources/com/naheulback/ledonjondenaheulback";
                InputStream stream = new FileInputStream(path + "/otherImages/extdonj1.png");
                Image image = new Image(stream);
                dungeonIV.setImage(image);


        }

    }

    public void onBackButtonClicked() throws IOException {

        LoadScene.changeScene("terre-fangh");

    }
}
