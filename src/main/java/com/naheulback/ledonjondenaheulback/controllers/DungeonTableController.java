package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class DungeonTableController {

    @FXML
    private HBox interactionButtonsHB;

    public void initialize(){

        interactionButtonsHB.setVisible(false);

    }
    public void onBackButtonClicked() throws IOException {

        System.out.println("LET ME OUT !!!");
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
    }

    public void onHero2Clicked() {
    }

    public void onHero3Clicked() {
    }

    public void onHero4Clicked() {
    }

    public void onHero5Clicked() {
    }

    public void onHero6Clicked() {
    }

}
