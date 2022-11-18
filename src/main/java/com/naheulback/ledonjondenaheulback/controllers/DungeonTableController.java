package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Functions;
import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import com.naheulback.ledonjondenaheulback.classes.Nain;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import com.naheulback.ledonjondenaheulback.classes.Warrior;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.naheulback.ledonjondenaheulback.Functions.*;

public class DungeonTableController {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";
    private static String slug = "empty";
    @FXML
    private ImageView mainIV;
    @FXML
    private HBox interactionButtonsHB;
    private ArrayList<ImageView> heroImages;
    @FXML
    private ImageView hero1IV;
    @FXML
    private ImageView hero2IV;
    @FXML
    private ImageView hero3IV;
    @FXML
    private ImageView hero4IV;
    @FXML
    private ImageView hero5IV;
    @FXML
    private ImageView hero6IV;

    public void initialize() throws IOException {

        String path = resPath + "dungeonImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_tavern_table" + Game.getTable() + ".png");
        Image image = new Image(stream);
        mainIV.setImage(image);

        heroImages = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        Functions.setTableImages(heroImages);

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

    public void onRecruitPriceButtonClicked() throws IOException {
        slug = getSpeakingHeroSlug();
        HashMap<String,String> dict = getHeroDictFromFile(slug);
        System.out.println("Je coûte " + dict.get("cost") + " pièces d'or.");
    }

    public void onRecruitButtonClicked() throws IOException {

        slug = getSpeakingHeroSlug();
        HashMap<String,String> dict = getHeroDictFromFile(slug);
        System.out.println(dict.get("name"));
        int cost = Integer.valueOf(dict.get("cost"));

        if(Game.hasEnoughGoldPieces(cost)){

            Hero toAdd = null;

            switch (dict.get("class")){

                case "warrior":
                    System.out.println("coucou");
                    toAdd = new Warrior(dict.get("slug"));
                    updateTableFile();
                    setTableImages(heroImages);
                    break;
                case "nain":
                    System.out.println("coucou2");
                    toAdd = new Nain(dict.get("slug"));
                    updateTableFile();
                    setTableImages(heroImages);
                    break;

            }

            Game.recruitHero(toAdd);

        }

    }

    public void onHero1Clicked() throws IOException {

        Game.setSpeakingHero(0);
        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero2Clicked() throws IOException {

        Game.setSpeakingHero(1);
        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero3Clicked() throws IOException {

        Game.setSpeakingHero(2);
        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero4Clicked() throws IOException {

        Game.setSpeakingHero(3);
        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero5Clicked() throws IOException {

        Game.setSpeakingHero(4);
        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }

    public void onHero6Clicked() throws IOException {

        Game.setSpeakingHero(5);
        String slug = getSpeakingHeroSlug();
        interactionButtonsHB.setVisible(true);
        interactionButtonsHB.setDisable(false);

    }



}
