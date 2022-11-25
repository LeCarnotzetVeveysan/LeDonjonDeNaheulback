package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Functions;
import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

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
    private ArrayList<Button> sitButtons;
    private ArrayList<ImageView> sitButtonImages;
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
    @FXML
    private Button sitButton;
    @FXML
    private ImageView sitButtonIV;
    @FXML
    private HBox sitButtonsHB;
    @FXML
    private Button sitButton1;
    @FXML
    private ImageView sitButton1IV;
    @FXML
    private Button sitButton2;
    @FXML
    private ImageView sitButton2IV;
    @FXML
    private Button sitButton3;
    @FXML
    private ImageView sitButton3IV;
    @FXML
    private Button sitButton4;
    @FXML
    private ImageView sitButton4IV;
    @FXML
    private Button sitButton5;
    @FXML
    private ImageView sitButton5IV;
    @FXML
    private Button sitButton6;
    @FXML
    private ImageView sitButton6IV;


    public void initialize() throws IOException {

        String path = resPath + "dungeonImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_tavern_table" + Game.getTable() + ".png");
        Image image = new Image(stream);
        mainIV.setImage(image);

        heroImages = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        Functions.setTableImages(heroImages);

        sitButtons = new ArrayList<>(Arrays.asList(sitButton1, sitButton2, sitButton3, sitButton4, sitButton5, sitButton6));
        sitButtonImages = new ArrayList<>(Arrays.asList(sitButton1IV, sitButton2IV, sitButton3IV, sitButton4IV, sitButton5IV, sitButton6IV));

        interactionButtonsHB.setVisible(false);
        interactionButtonsHB.setDisable(true);

        sitButtonsHB.setVisible(false);
        sitButtonsHB.setDisable(true);

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

        if(Game.getNumberOfLivingHeroes() < Game.getMaxHeroes()) {

            slug = getSpeakingHeroSlug();
            HashMap<String, String> dict = getHeroDictFromFile(slug);
            System.out.println(dict.get("name"));
            int cost = Integer.valueOf(dict.get("cost"));
            ArrayList<String> slugList = getTableSlugList();

            if (Game.hasEnoughGoldPieces(cost)) {

                Hero toAdd = null;
                slugList.set(Game.getSpeakingHero(), "empty");

                switch (dict.get("class")) {

                    case "warrior":
                        toAdd = new Warrior(dict.get("slug"));
                        updateTableFile(slugList);
                        setTableImages(heroImages);
                        break;
                    case "nain":
                        toAdd = new Nain(dict.get("slug"));
                        updateTableFile(slugList);
                        setTableImages(heroImages);
                        break;
                    case "mage":
                        toAdd = new Mage(dict.get("slug"));
                        updateTableFile(slugList);
                        setTableImages(heroImages);
                        break;
                    case "elfe":
                        toAdd = new Elfe(dict.get("slug"));
                        updateTableFile(slugList);
                        setTableImages(heroImages);
                        break;
                    case "ogre":
                        toAdd = new Ogre(dict.get("slug"));
                        updateTableFile(slugList);
                        setTableImages(heroImages);
                        break;
                    case "ranger":
                        toAdd = new Ranger(dict.get("slug"));
                        updateTableFile(slugList);
                        setTableImages(heroImages);
                        break;

                }
                Game.recruitHero(toAdd);
                Game.takeGoldPieces(cost);
            }
        } else {

            //Faire en sorte que héros dise que la team est pleine
            System.out.println("Too many heroes in your team");

        }
    }

    public void onSitButtonClicked() throws FileNotFoundException {

        sitButtonsHB.getChildren().clear();
        sitButtons = new ArrayList<>(Arrays.asList(sitButton1, sitButton2, sitButton3, sitButton4, sitButton5, sitButton6));
        for(Button validBtn : sitButtons){
            sitButtonsHB.getChildren().add(validBtn);
        }

        sitButtonsHB.setVisible(true);
        sitButtonsHB.setDisable(false);
        interactionButtonsHB.setVisible(false);
        interactionButtonsHB.setDisable(true);

        ArrayList<String> sl = Game.getLivingHeroSlugs();
        for (int i = 5; i >= 0; i--){

            if(sl.get(i).equals("empty")){
                sitButtonsHB.getChildren().remove(i);
            } else {
                String path = resPath + "tavernImages/";
                InputStream stream = new FileInputStream(path + sl.get(i) + "_head.png");
                Image image = new Image(stream);
                sitButtons.get(i).setDisable(false);
                sitButtons.get(i).setVisible(true);
                sitButtonImages.get(i).setImage(image);
            }
        }
    }

    public void onHeroSitButtonClicked(int index) throws IOException {

        boolean seated = false;
        String slugToSit = Game.getLivingHeroSlugs().get(index);
        ArrayList<String> tsl = getTableSlugList();

        for (int i = 0; i <= 5; i++){
            if(tsl.get(i).equals("empty")){
                Game.sitHero(index);
                //System.out.println("On est dans la boucle");
                tsl.set(i, slugToSit);
                seated = true;
                break;
            }
        }

        if(!seated){
            System.out.println("all seats are taken");
        }

        Functions.updateTableFile(tsl);
        onSitButtonClicked();
        Functions.setTableImages(heroImages);

    }

    public void onHero1SitButtonClicked() throws IOException {
        onHeroSitButtonClicked(0);
    }

    public void onHero2SitButtonClicked() throws IOException {
        onHeroSitButtonClicked(1);
    }

    public void onHero3SitButtonClicked() throws IOException {
        onHeroSitButtonClicked(2);
    }

    public void onHero4SitButtonClicked() throws IOException {
        onHeroSitButtonClicked(3);
    }

    public void onHero5SitButtonClicked() throws IOException {
        onHeroSitButtonClicked(4);
    }

    public void onHero6SitButtonClicked() throws IOException {
        onHeroSitButtonClicked(5);
    }

    private void onHeroIVClicked() throws IOException {
        if(!Functions.getTableSlugList().get(Game.getSpeakingHero()).equals("empty")){
            interactionButtonsHB.setVisible(true);
            interactionButtonsHB.setDisable(false);
        } else {
            interactionButtonsHB.setVisible(false);
            interactionButtonsHB.setDisable(true);
        }
        sitButtonsHB.setVisible(false);
        sitButtonsHB.setDisable(true);
    }

    public void onHero1Clicked() throws IOException {
        Game.setSpeakingHero(0);
        onHeroIVClicked();
    }

    public void onHero2Clicked() throws IOException {
        Game.setSpeakingHero(1);
        onHeroIVClicked();
    }

    public void onHero3Clicked() throws IOException {
        Game.setSpeakingHero(2);
        onHeroIVClicked();
    }

    public void onHero4Clicked() throws IOException {
        Game.setSpeakingHero(3);
        onHeroIVClicked();
    }

    public void onHero5Clicked() throws IOException {
        Game.setSpeakingHero(4);
        onHeroIVClicked();
    }

    public void onHero6Clicked() throws IOException {
        Game.setSpeakingHero(5);
        onHeroIVClicked();
    }


    public void onSitButtonHovering() throws FileNotFoundException {

        String path = resPath + "tavernImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_tabouret_fleche.png");
        Image image = new Image(stream);
        sitButtonIV.setImage(image);

    }

    public void onSitButtonStoppedHovering() throws FileNotFoundException {

        String path = resPath + "tavernImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_tabouret.png");
        Image image = new Image(stream);
        sitButtonIV.setImage(image);

    }
}
