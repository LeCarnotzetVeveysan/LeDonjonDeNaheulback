package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Functions;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import com.naheulback.ledonjondenaheulback.classes.Warrior;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;

public class MainMenuController {

    @FXML
    private ImageView newGameBtnIV;

    public void initialize() throws IOException {

        System.out.println("Main menu entered");
        //System.out.println(PlayerData.getLivingHeroes());
        //PlayerData.recruitHero(Warrior.buildHeroFromDict(Functions.getHeroDictFromFile("warrior")));
        //System.out.println(PlayerData.getLivingHeroes());


    }
    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }

    public void onInstructionsButtonClick() throws IOException {
        LoadScene.changeScene("menu-instructions");
    }

    public void onNewGameButtonClick() throws IOException {
        LoadScene.changeScene("menu-level-select");
    }

    public void onSavedGameButtonClick() {

        //System.out.println(Game.getLevel());

    }

    @FXML
    public void startedHovering() throws FileNotFoundException {
        //System.out.println("Hovering");

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback";
        InputStream stream = new FileInputStream(path + "/menuImages/newgameinv.png");
        Image image = new Image(stream);

        newGameBtnIV.setImage(image);

    }


    @FXML
    public void stoppedHovering() throws FileNotFoundException {
        //System.out.println("Stopped hovering");

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback";
        InputStream stream = new FileInputStream(path + "/menuImages/newgame.png");
        Image image = new Image(stream);

        newGameBtnIV.setImage(image);

    }
}
