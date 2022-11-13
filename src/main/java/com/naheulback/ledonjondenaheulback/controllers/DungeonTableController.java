package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DungeonTableController {

    @FXML
    private ImageView mainIV;
    @FXML
    private HBox interactionButtonsHB;

    public void initialize() throws FileNotFoundException {

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback/dungeonImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_tavern_table" + Game.getTable() + ".png");
        Image image = new Image(stream);
        mainIV.setImage(image);

        interactionButtonsHB.setVisible(false);
        interactionButtonsHB.setDisable(true);

    }
    public void onBackButtonClicked() throws IOException {

        LoadScene.changeScene("dungeon-tavern");

    }

    public void startedHovering() {
    }

    public void stoppedHovering() {
    }

    public void onYouButtonClicked() {
    }

    public void onQuoteButtonClicked() {
    }

    public void onJokeButtonClicked() {
    }

    public void onRecruitPriceButtonClicked() {
    }

    public void onRecruitButtonClicked() {
    }

    public void onHero1Clicked() {

        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero2Clicked() {

        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero3Clicked() {

        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero4Clicked() {

        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero5Clicked() {

        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero6Clicked() {

        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

}
