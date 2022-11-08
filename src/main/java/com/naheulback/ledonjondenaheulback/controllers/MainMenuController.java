package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;

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

    @FXML
    public void startedHovering() throws FileNotFoundException {
        System.out.println("Hovering");

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback";
        InputStream stream = new FileInputStream(path + "/mainMenuImages/newgameinv.png");
        Image image = new Image(stream);

        newGameBtnIV.setImage(image);

    }


    @FXML
    public void stoppedHovering() throws FileNotFoundException {
        System.out.println("Stopped hovering");

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback";
        InputStream stream = new FileInputStream(path + "/mainMenuImages/newgame.png");
        Image image = new Image(stream);

        newGameBtnIV.setImage(image);

    }
}
