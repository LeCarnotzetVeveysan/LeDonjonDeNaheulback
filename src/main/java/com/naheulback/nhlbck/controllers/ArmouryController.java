package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.*;
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
import static java.lang.Math.round;

public class ArmouryController {

    @FXML
    private VBox armouryItem1VB, armouryItem2VB, armouryItem3VB, armouryItem4VB, armouryItem5VB;
    @FXML
    private StackPane armouryItem1SP, armouryItem2SP, armouryItem3SP, armouryItem4SP, armouryItem5SP;
    @FXML
    private ImageView armouryItem1BtnIV, armouryItem2BtnIV, armouryItem3BtnIV, armouryItem4BtnIV, armouryItem5BtnIV;
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
    private ArrayList<StackPane> itemStackPanes;

    private int currentItem, currentHeroIndex;
    private Hero curHero;
    private ArrayList<String> itemList;
    private ArrayList<Hero> livingHeroes;
    private ArrayList<Label> heroRecapLabels;
    private ArrayList<ImageView> heroRecapIVs;
    @FXML
    private Label coinCountLB, heroRecapTitleLB;
    @FXML
    private StackPane heroRecapSP;

    @FXML
    private ImageView heroRecapBodyItemIV, heroRecapHeadItemIV, heroRecapMainWeaponIV, heroRecapThrowableWeaponIV;

    @FXML
    private Label heroRecapBodyItemLB1, heroRecapBodyItemLB2, heroRecapHeadItemLB1, heroRecapHeadItemLB2,
            heroRecapMainWeaponLB1, heroRecapMainWeaponLB2, heroRecapThrowableWeaponLB1, heroRecapThrowableWeaponLB2;

    public void initialize() throws FileNotFoundException {

        curHero = null;
        currentHeroIndex = 0;
        armourymanSpeakLbl.setText("");

        armouryItemsHB.setDisable(true);
        armouryItemsHB.setVisible(false);
        itemImages = new ArrayList<>(Arrays.asList(armouryItem1BtnIV, armouryItem2BtnIV, armouryItem3BtnIV, armouryItem4BtnIV, armouryItem5BtnIV));
        itemLabels = new ArrayList<>(Arrays.asList(armouryItem1Label, armouryItem2Label, armouryItem3Label, armouryItem4Label, armouryItem5Label));
        itemStackPanes = new ArrayList<>(Arrays.asList(armouryItem1SP, armouryItem2SP, armouryItem3SP, armouryItem4SP, armouryItem5SP));
        ArrayList<ImageView> heroImages = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        heroRecapLabels = new ArrayList<>(Arrays.asList(heroRecapTitleLB, heroRecapHeadItemLB1, heroRecapHeadItemLB2,
                heroRecapBodyItemLB1, heroRecapBodyItemLB2, heroRecapMainWeaponLB1, heroRecapMainWeaponLB2,
                heroRecapThrowableWeaponLB1, heroRecapThrowableWeaponLB2));
        heroRecapIVs = new ArrayList<>(Arrays.asList(heroRecapHeadItemIV, heroRecapBodyItemIV, heroRecapMainWeaponIV, heroRecapThrowableWeaponIV));


        for(StackPane sp : itemStackPanes){
            sp.setVisible(false);
        }

        setImage(mainIV, "dungeonImages", "armoury_background" );

        armourymanIV.setVisible(false);
        setImage(armourymanIV, "dungeonImages", "d" + Game.getDungeon() + "_armouryman" );

        livingHeroes = Game.getLivingHeroes();
        Functions.setBarImages(livingHeroes, heroImages);

        coinCountLB.setText(String.valueOf(Game.getGoldPieces()));

        heroRecapSP.setVisible(false);
        heroRecapSP.setDisable(true);
    }

    public void onBackBtnClk() throws IOException { LoadScene.changeScene("dungeon-entry-hall"); }

    private void loadArmouryItems(String type) throws IOException {
        armouryItemsHB.getChildren().clear();
        ArrayList<VBox> armouryItems = new ArrayList<>(Arrays.asList(armouryItem1VB, armouryItem2VB, armouryItem3VB, armouryItem4VB, armouryItem5VB));
        for(VBox validVBox : armouryItems){
            armouryItemsHB.getChildren().add(validVBox);
        }
        itemList = Functions.getArmouryItems(type);

        for (int i = 4; i >= 0; i--){
            String[] item = itemList.get(i).split("\\|");
            if(item[0].equals("empty")){
                armouryItemsHB.getChildren().remove(i);
            } else {
                setArmouryItemImage(itemImages.get(i),item[0]);
                HashMap<String, String> dict = getDictFromFile("armoury", "armouryItems");
                System.out.println(item[0]);
                String[] item2 = dict.get(item[0]).split(",");
                String name = item2[0].split("\\|")[1];
                String[] effet = item2[3].split("\\|")[1].split(" ");
                String cout = item2[1].split("\\|")[1];
                String desc = item2[4].split("\\|")[1];
                int stat = 0;
                if(!(item[4].equals("spellbook") || item[4].equals("consumable"))) {
                    stat = (int) round((0.9 + (0.1 * Integer.parseInt(item[2]))) * Integer.parseInt(item2[2].split("\\|")[1]));
                }
                String toDisplay = "";
                toDisplay += name + "\n";

                if(!(item[4].equals("spellbook") || item[4].equals("consumable"))){
                    toDisplay += "Qualité: " + item[3] + item[1] +"\n";
                    toDisplay += "Effet: " + effet[0] + " " + stat + " " + effet[2] + "\n";
                }

                toDisplay += "Coût: " + cout + " PO" + "\n";
                toDisplay += desc;

                itemLabels.get(i).setText(toDisplay);
            }
        }
        Functions.setItemButtonHBSize(armouryItemsHB);
    }

    private void setArmouryItemImage(ImageView iv, String itemName) throws FileNotFoundException {
        Random rand = new Random();
        String imageName;
        if(itemName.contains("spellbook") || itemName.contains("potion")|| itemName.contains("arrow")|| itemName.contains("quiver")){
            imageName = itemName;
        } else {
            if (itemName.contains("plastron") || itemName.contains("cotte") || itemName.contains("robe") || itemName.contains("casque")){
                imageName = "bodyItems_" + rand.nextInt(1, 8);
            } else {
                if (itemName.contains("dague") || itemName.contains("epee") || itemName.contains("hache") || itemName.contains("arc")) {
                    imageName = "weaponItems_" + rand.nextInt(1, 8);
                } else {
                    imageName = "unknownItem";
                }
            }
        }
        setImage(iv, "armouryImages", imageName);
    }

    @FXML
    void onHeroClicked() throws IOException {
        if(currentHeroIndex <= livingHeroes.size() - 1){
            armourymanSpeakIV.setVisible(false);
            armourymanSpeakLbl.setText("");
            curHero = Game.getLivingHeroes().get(currentHeroIndex);
            armourymanIV.setVisible(true);
            int armourymanX = switch (currentHeroIndex){
                case 0 -> 2*153;
                case 1 -> 3*153;
                case 2 -> 153;
                case 3 -> 4*153;
                case 4 -> 5*153;
                case 5 -> 0;
                default -> throw new IllegalStateException("Unexpected value: " + currentHeroIndex);
            };
            armourymanIV.setLayoutX(25 + armourymanX);
            loadArmouryItems(curHero.getType());
            Functions.setHeroRecap(curHero, heroRecapLabels, heroRecapIVs);
            heroRecapSP.setVisible(true);
            heroRecapSP.setDisable(false);
        } else {
            armourymanIV.setLayoutX(25);
            heroRecapSP.setVisible(false);
            heroRecapSP.setDisable(true);
        }
    }


    @FXML
    void onItemBtnClk() throws IOException {

        String[] item = itemList.get(currentItem).split("\\|");
        String itemSlug = item[0];
        HashMap<String, String> dict = getDictFromFile("armoury", "armouryItems");
        String[] item2 = dict.get(item[0]).split(",");

        double cost = Double.parseDouble(item2[1].split("\\|")[1]);
        if (!(curHero == null)) {
            if (Game.hasEnoughGoldPieces(cost)) {

                Game.takeGoldPieces(cost);
                coinCountLB.setText(String.valueOf(Game.getGoldPieces()));

                String itemName = item2[0].split("\\|")[1] + item[1];
                int level = Integer.parseInt(item[2]);
                int quality = Integer.parseInt(item[3]);
                int stat = 0;
                if(!(item[4].equals("spellbook") || item[4].equals("consumable"))) {
                    stat = (int) round((0.9 + (0.1 * level)) * Integer.parseInt(item2[2].split("\\|")[1]));
                }
                switch (item[4]) {
                    case "mainWeapon" -> curHero.setMainWeapon(itemSlug, itemName, level, quality, stat);
                    case "throwableWeapon" -> curHero.setThrowableWeapon(itemSlug, itemName, level, quality, stat);
                    case "headItem" -> curHero.setHeadItem(itemSlug, itemName, level, quality, stat);
                    case "bodyItem" -> curHero.setBodyItem(itemSlug, itemName, level, quality, stat);
                    case "spellbook" -> { SpellBook grim = new SpellBook(itemSlug, itemName, level); curHero.addItem(grim); }
                    case "arrow" -> ((Elven) curHero).setArrows(level, 1);
                    case "quiver" -> curHero.addItem(new Quiver(itemSlug,itemName,level));
                    case "consumable" -> curHero.addItem(new Consumable(itemSlug, itemName, level));
                }

                switch (new Random().nextInt(5)){
                    case 1 -> armourymanSpeakLbl.setText("Bon choix");
                    case 2 -> armourymanSpeakLbl.setText("Belle arme");
                    case 3 -> armourymanSpeakLbl.setText("Vous avez fait un bon choix");
                    case 4 -> armourymanSpeakLbl.setText("Vos ennemis vont déguster");
                }

                Functions.setHeroRecap(curHero, heroRecapLabels, heroRecapIVs);

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
    void onItem1BtnHov() {
        currentItem = 0;
        itemStackPanes.get(0).setVisible(true);
    }

    @FXML
    void onItem1BtnHovEnd() {
        itemStackPanes.get(0).setVisible(false);
    }

    @FXML
    void onItem2BtnHov() {
        currentItem = 1;
        itemStackPanes.get(1).setVisible(true);
    }

    @FXML
    void onItem2BtnHovEnd() {
        itemStackPanes.get(1).setVisible(false);
    }

    @FXML
    void onItem3BtnHov() {
        currentItem = 2;
        itemStackPanes.get(2).setVisible(true);
    }

    @FXML
    void onItem3BtnHovEnd() {
        itemStackPanes.get(2).setVisible(false);
    }

    @FXML
    void onItem4BtnHov() {
        currentItem = 3;
        itemStackPanes.get(3).setVisible(true);
    }

    @FXML
    void onItem4BtnHovEnd() {
        itemStackPanes.get(3).setVisible(false);
    }

    @FXML
    void onItem5BtnHov() {
        currentItem = 4;
        itemStackPanes.get(4).setVisible(true);
    }

    @FXML
    void onItem5BtnHovEnd() {
        itemStackPanes.get(4).setVisible(false);
    }

    @FXML
    void onHero1Hover() {
        currentHeroIndex = 0;
    }

    @FXML
    void onHero1StoppedHover() {

    }

    @FXML
    void onHero2Hover() {
        currentHeroIndex = 1;
    }

    @FXML
    void onHero2StoppedHover() {

    }

    @FXML
    void onHero3Hover() {
        currentHeroIndex = 2;
    }

    @FXML
    void onHero3StoppedHover() {

    }

    @FXML
    void onHero4Hover() {
        currentHeroIndex = 3;
    }

    @FXML
    void onHero4StoppedHover() {

    }

    @FXML
    void onHero5Hover() {
        currentHeroIndex = 4;
    }

    @FXML
    void onHero5StoppedHover() {

    }

    @FXML
    void onHero6Hover() {
        currentHeroIndex = 5;
    }

    @FXML
    void onHero6StoppedHover() {

    }
}
