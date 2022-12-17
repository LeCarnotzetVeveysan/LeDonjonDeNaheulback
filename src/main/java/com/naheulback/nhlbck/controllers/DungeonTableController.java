package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.naheulback.nhlbck.Functions.*;
import static com.naheulback.nhlbck.Game.getDungeon;

public class DungeonTableController {

    private static final String resPath = "src/main/resources/com/naheulback/nhlbck/";
    private static final String slug = "empty";
    @FXML
    private ImageView mainIV;
    @FXML
    private HBox interactionButtonsHB;
    private ArrayList<ImageView> heroImages;
    private ArrayList<Button> sitButtons;
    private ArrayList<ImageView> sitButtonImages;
    @FXML
    private Label heroSpeakLB;
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
    @FXML
    private Label coinCountLB;
    private HashMap<String,String> heroDict;
    private ArrayList<Hero> livingHeroes;



    public void initialize() throws IOException {

        setImage(mainIV, "dungeonImages","tavern_table" + Game.getTable() );

        heroImages = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        Functions.setTableImages(heroImages);

        sitButtons = new ArrayList<>(Arrays.asList(sitButton1, sitButton2, sitButton3, sitButton4, sitButton5, sitButton6));
        sitButtonImages = new ArrayList<>(Arrays.asList(sitButton1IV, sitButton2IV, sitButton3IV, sitButton4IV, sitButton5IV, sitButton6IV));

        interactionButtonsHB.setVisible(false);
        interactionButtonsHB.setDisable(true);

        sitButtonsHB.setVisible(false);
        sitButtonsHB.setDisable(true);

        coinCountLB.setText(String.valueOf(Game.getGoldPieces()));
        heroSpeakLB.setText("");

        livingHeroes = Game.getLivingHeroes();

    }
    public void onBackButtonClicked() throws IOException {
        LoadScene.changeScene("dungeon-tavern");
    }

    public void startedHovering() {
    }

    public void stoppedHovering() {
    }

    public void onYouButtonClicked() {
        heroSpeakLB.setText(heroDict.get("desc") + " " + heroDict.get("level"));
    }

    public void onQuoteButtonClicked() {
        heroSpeakLB.setText(heroDict.get("quote"));
    }

    public void onJokeButtonClicked() {
        heroSpeakLB.setText(heroDict.get("joke"));
    }

    public void onRecruitPriceButtonClicked() {
        heroSpeakLB.setText("Je coûte " + heroDict.get("cost") + " pièces d'or à recruter.");
    }

    public void onRecruitButtonClicked() throws IOException {

        if(Game.getNumberOfLivingHeroes() < Game.getMaxHeroes()) {

            int cost = Integer.parseInt(heroDict.get("cost"));
            ArrayList<String> slugList = getTableSlugList();

            if (Game.hasEnoughGoldPieces(cost)) {

                Hero toAdd = null;
                slugList.set(Game.getSpeakingHero(), "empty");

                switch (heroDict.get("class")) {
                    case "warrior" -> toAdd = new Warrior(heroDict);
                    case "nain" -> toAdd = new Nain(heroDict);
                    case "mage" -> toAdd = new Mage(heroDict);
                    case "elfe" -> toAdd = new Elfe(heroDict);
                    case "human" -> toAdd = new Human(heroDict);
                }
                updateTableFile(slugList);
                setTableImages(heroImages);
                Game.recruitHero(toAdd);
                Game.takeGoldPieces(cost);
                coinCountLB.setText(String.valueOf(Game.getGoldPieces()));
                interactionButtonsHB.setDisable(true);
                interactionButtonsHB.setVisible(false);
            } else {
                heroSpeakLB.setText("Tu n'as pas assez de pièces d'or pour me recruter");
            }
        } else {
            heroSpeakLB.setText("Ta compagnie est déjà pleine");
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
                setImage(sitButtonImages.get(i), "heroImages", sl.get(i) + "_head");
                sitButtons.get(i).setDisable(false);
                sitButtons.get(i).setVisible(true);
            }
        }
    }

    public void onHeroSitButtonClicked(int index) throws IOException {

        String slugToSit = Game.getLivingHeroSlugs().get(index);
        ArrayList<String> tsl = getTableSlugList();

        for (int i = 0; i <= 5; i++){
            if(tsl.get(i).equals("empty")){
                Game.sitHero(index);
                tsl.set(i, slugToSit);
                break;
            }
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
        if(!getTableSlugList().get(Game.getSpeakingHero()).equals("empty")){
            interactionButtonsHB.setVisible(true);
            interactionButtonsHB.setDisable(false);
            sitButtonsHB.setVisible(false);
            sitButtonsHB.setDisable(true);
            copyFile("heroFiles", getTableSlugList().get(Game.getSpeakingHero()), "heroToLoad");
            heroDict = getDictFromFile("hero", "heroToLoad");
        } else {
            interactionButtonsHB.setVisible(false);
            interactionButtonsHB.setDisable(true);
        }
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
        setImage(sitButtonIV, "tavernImages","d" + getDungeon() + "_tabouret_fleche");
    }

    public void onSitButtonStoppedHovering() throws FileNotFoundException {
        setImage(sitButtonIV, "tavernImages","d" +  getDungeon() + "_tabouret");
    }
}
