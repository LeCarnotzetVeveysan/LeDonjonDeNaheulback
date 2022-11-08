package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

public class MainMenuController {

    @FXML
    private ImageView newGameBtnIV;

    public void initialize(){

        System.out.println("Main menu entered");

    }
    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }

    public void onInstructionsButtonClick() throws IOException {
        LoadScene.changeScene("instructions-page");
    }

    public void onNewGameButtonClick() throws IOException {
        LoadScene.changeScene("new-game");
    }

    public void onSavedGameButtonClick() {

        //System.out.println(Game.getLevel());

    }

    public void startedHovering() {
        //System.out.println("Hovering");
        File file = new File("/mainMenuImages/newgameinv.png");
        Image image = new Image(file.toURI().toString());
        newGameBtnIV.setImage(image);

    }

    public void stoppedHovering() {
        //System.out.println("Stopped hovering");
        File file = new File("/mainMenuImages/newgame.png");
        Image image = new Image(file.toURI().toString());
        newGameBtnIV.setImage(image);

    }
}
