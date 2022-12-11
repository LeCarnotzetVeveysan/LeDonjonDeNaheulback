package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static com.naheulback.nhlbck.Functions.getDictFromFile;
import static com.naheulback.nhlbck.Functions.setImage;
import static java.lang.Math.floor;

public class ArmouryController {

    private static String resPath = "src/main/resources/com/naheulback/nhlbck/";
    @FXML
    private VBox armouryItem1VB, armouryItem2VB, armouryItem3VB, armouryItem4VB, armouryItem5VB;
    @FXML
    private StackPane armouryItem1SP, armouryItem2SP, armouryItem3SP, armouryItem4SP, armouryItem5SP;
    @FXML
    private ImageView armouryItem1ButtonIV, armouryItem2ButtonIV, armouryItem3ButtonIV, armouryItem4ButtonIV, armouryItem5ButtonIV;
    @FXML
    private ImageView armourymanIV;
    @FXML
    private Label armouryItem1Label, armouryItem2Label, armouryItem3Label, armouryItem4Label, armouryItem5Label;
    @FXML
    private Label armourymanSpeakLbl;
    @FXML
    private ImageView armourymanSpeakIV;
    @FXML
    private HBox armouryItemsHB;
    @FXML
    private ImageView mainIV;
    @FXML
    private ImageView hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV;
    private ArrayList<ImageView> itemImages;
    private ArrayList<Label> itemLabels;
    private ArrayList<VBox> armouryItems;
    private ArrayList<StackPane> itemStackPanes;
    private ArrayList<ImageView> heroImages;

    private String currentHeroName;
    private int currentItem, currentHeroIndex;
    private Hero currentHero;
    private ArrayList<String> livingHeroSlugs;
    private ArrayList<String> itemList;
    private ArrayList<Hero> livingHeroes;

    public void initialize() throws FileNotFoundException {

        currentHero = null;
        currentHeroIndex = 0;
        armourymanSpeakLbl.setText("");

        armouryItemsHB.setDisable(true);
        armouryItemsHB.setVisible(false);
        itemImages = new ArrayList<>(Arrays.asList(armouryItem1ButtonIV, armouryItem2ButtonIV, armouryItem3ButtonIV, armouryItem4ButtonIV, armouryItem5ButtonIV));
        itemLabels = new ArrayList<>(Arrays.asList(armouryItem1Label, armouryItem2Label, armouryItem3Label, armouryItem4Label, armouryItem5Label));
        itemStackPanes = new ArrayList<>(Arrays.asList(armouryItem1SP, armouryItem2SP, armouryItem3SP, armouryItem4SP, armouryItem5SP));
        heroImages = new ArrayList(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));

        for(StackPane sp : itemStackPanes){
            sp.setVisible(false);
        }

        setImage(mainIV, "armouryImages", "d" + Game.getDungeon() + "_armoury_background" );

        armourymanIV.setVisible(false);
        setImage(mainIV, "armouryImages", "d" + Game.getDungeon() + "_armouryman" );

        livingHeroes = Game.getLivingHeroes();
        Functions.setBarImages(livingHeroes, heroImages);

        livingHeroSlugs = Game.getLivingHeroSlugs();

    }

    public void onBackButtonClicked() throws IOException { LoadScene.changeScene("dungeon-entry-hall"); }

    private void loadArmouryItems(String type) throws IOException {
        armouryItemsHB.getChildren().clear();
        armouryItems = new ArrayList<>(Arrays.asList(armouryItem1VB, armouryItem2VB, armouryItem3VB, armouryItem4VB, armouryItem5VB));
        for(VBox validVBox : armouryItems){
            armouryItemsHB.getChildren().add(validVBox);
        }

        itemList = Functions.getArmouryItems(type);

        for (int i = 4; i >= 0; i--){
            String[] item = itemList.get(i).split("\\|");
            if(item[0].equals("empty")){
                armouryItemsHB.getChildren().remove(i);

            } else {

                setImage(itemImages.get(i), "armouryImages", item[0]);

                HashMap<String, String> dict = getDictFromFile("armoury", item[0]);

                String name = dict.get("name");
                String[] effet = dict.get("effet").split(" ");
                String cout = dict.get("cost");
                String desc = dict.get("desc");
                String tempStat = switch (dict.get("type")){
                    case "weapon" -> dict.get("power");
                    case "armor" -> dict.get("armor");
                    default -> "rien";
                };
                effet[1] = tempStat;

                String toDisplay = "";
                toDisplay += name + " (Niveau " + item[1] + ")" + "\n";
                toDisplay += "Effet: " + effet[0] + " " + effet[1] + " " + effet[2] + "\n";
                toDisplay += "Coût: " + cout + " PO" + "\n";
                toDisplay += desc;

                itemLabels.get(i).setText(toDisplay);
            }
        }

        Functions.setItemButtonHBSize(armouryItemsHB);
    }



    @FXML
    void onHeroClicked() throws IOException {
        if (!currentHeroName.equals("empty")) {
            currentHero = Game.getLivingHeroes().get(currentHeroIndex);
            armourymanIV.setVisible(true);
            int armourymanX = switch (currentHeroIndex){
                case 0 -> 2*153;
                case 1 -> 3*153;
                case 2 -> 1*153;
                case 3 -> 4*153;
                case 4 -> 5*153;
                case 5 -> 0;
                default -> throw new IllegalStateException("Unexpected value: " + currentHeroIndex);
            };
            armourymanIV.setLayoutX(25 + armourymanX);
            loadArmouryItems(currentHero.getType());
        }
    }

    @FXML
    void onItemButtonClicked() throws IOException, InterruptedException {

        String[] item = itemList.get(currentItem).split("\\|");
        String itemName = item[0];
        HashMap<String, String> dict = getDictFromFile("armoury", itemName);
        double cost = Integer.parseInt(dict.get("cost"));
        if (!(currentHero == null)) {
            if (Game.hasEnoughGoldPieces(cost)) {

                Game.takeGoldPieces(cost);

                int level = Integer.parseInt(item[1]);
                int power = (int) floor((0.75 + (0.25 * level)) * Integer.parseInt(dict.get("power")));

                currentHero.setMainWeapon(itemName, level , power );

                switch (new Random().nextInt(5)){
                    case 1 -> {
                        armourymanSpeakLbl.setText("Bon choix");
                    }
                    case 2 -> {
                        armourymanSpeakLbl.setText("Belle arme");
                    }
                    case 3 -> {
                        armourymanSpeakLbl.setText("Vous avez fait un bon choix");
                    }
                    case 4 -> {
                        armourymanSpeakLbl.setText("Vos ennemis vont déguster");
                    }
                }

            } else {
                armourymanSpeakLbl.setText("Tu n'as pas assez de pièces d'or pour ça");
                setImage(armourymanSpeakIV, "tavernImages","barman_pos" + currentHeroIndex + "_bubble" );
            }
        } else {
            armourymanSpeakLbl.setText("Tu n'as pas choisi de héros");
            armourymanIV.setVisible(true);
            armourymanIV.setLayoutX(25);
            setImage(armourymanSpeakIV, "tavernImages","barman_pos0_bubble.png" );
        }
    }

    @FXML
    void onItem1ButtonHovering() {
        currentItem = 0;
        itemStackPanes.get(0).setVisible(true);
    }

    @FXML
    void onItem1StoppedButtonHovering() {
        itemStackPanes.get(0).setVisible(false);
    }

    @FXML
    void onItem2ButtonHovering() {
        currentItem = 1;
        itemStackPanes.get(1).setVisible(true);
    }

    @FXML
    void onItem2StoppedButtonHovering() {
        itemStackPanes.get(1).setVisible(false);
    }

    @FXML
    void onItem3ButtonHovering() {
        currentItem = 2;
        itemStackPanes.get(2).setVisible(true);
    }

    @FXML
    void onItem3StoppedButtonHovering() {
        itemStackPanes.get(2).setVisible(false);
    }

    @FXML
    void onItem4ButtonHovering() {
        currentItem = 3;
        itemStackPanes.get(3).setVisible(true);
    }

    @FXML
    void onItem4StoppedButtonHovering() {
        itemStackPanes.get(3).setVisible(false);
    }

    @FXML
    void onItem5ButtonHovering() {
        currentItem = 4;
        itemStackPanes.get(4).setVisible(true);
    }

    @FXML
    void onItem5StoppedButtonHovering() {
        itemStackPanes.get(4).setVisible(false);
    }

    @FXML
    void onHero1Hover() {
        currentHeroName = livingHeroSlugs.get(0);
        currentHeroIndex = 0;
        //setImage
    }

    @FXML
    void onHero1StoppedHover() {

    }

    @FXML
    void onHero2Hover() {
        currentHeroName = livingHeroSlugs.get(1);
        currentHeroIndex = 1;
    }

    @FXML
    void onHero2StoppedHover() {

    }

    @FXML
    void onHero3Hover() {
        currentHeroName = livingHeroSlugs.get(2);
        currentHeroIndex = 2;
    }

    @FXML
    void onHero3StoppedHover() {

    }

    @FXML
    void onHero4Hover() {
        currentHeroName = livingHeroSlugs.get(3);
        currentHeroIndex = 3;
    }

    @FXML
    void onHero4StoppedHover() {

    }

    @FXML
    void onHero5Hover() {
        currentHeroName = livingHeroSlugs.get(4);
        currentHeroIndex = 4;
    }

    @FXML
    void onHero5StoppedHover() {

    }

    @FXML
    void onHero6Hover() {
        currentHeroName = livingHeroSlugs.get(5);
        currentHeroIndex = 5;
    }

    @FXML
    void onHero6StoppedHover() {

    }
}
