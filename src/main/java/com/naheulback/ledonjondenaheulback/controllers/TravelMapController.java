package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.layout.BackgroundPosition.CENTER;
import static javafx.scene.layout.BackgroundRepeat.NO_REPEAT;
import static javafx.scene.layout.BackgroundRepeat.REPEAT;
import static javafx.scene.layout.BackgroundSize.DEFAULT;

public class TravelMapController {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";
    @FXML
    private StackPane donj4InfoSP;
    @FXML
    private Label donj4StatsLbl;

    public void initialize() throws IOException {

        donj4InfoSP.setVisible(false);
        String path = resPath + "mapFiles/donj4_stats";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String toDisplay = "";
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            toDisplay += line;
            if(!line.equals("")){
                toDisplay += "\n";
            }
        }
        donj4StatsLbl.setText(toDisplay);

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
        donj4InfoSP.setVisible(true);
    }

    public void onDonj4ButtonStoppedHover() { donj4InfoSP.setVisible(false); }
}
