package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.Elfe;
import com.naheulback.nhlbck.classes.Grimoire;
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
    private ArrayList<VBox> armouryItems;
    private ArrayList<StackPane> itemStackPanes;
    private ArrayList<ImageView> heroImages;

    private String currentHeroName;
    private int currentItem, currentHeroIndex;
    private Hero curHero;
    private ArrayList<String> livingHeroSlugs;
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
        heroImages = new ArrayList(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        heroRecapLabels = new ArrayList<>(Arrays.asList(heroRecapTitleLB, heroRecapHeadItemLB1, heroRecapHeadItemLB2,
                heroRecapBodyItemLB1, heroRecapBodyItemLB2, heroRecapMainWeaponLB1, heroRecapMainWeaponLB2,
                heroRecapThrowableWeaponLB1, heroRecapThrowableWeaponLB2));
        heroRecapIVs = new ArrayList<>(Arrays.asList(heroRecapHeadItemIV, heroRecapBodyItemIV, heroRecapMainWeaponIV, heroRecapThrowableWeaponIV));


        for(StackPane sp : itemStackPanes){
            sp.setVisible(false);
        }

        setImage(mainIV, "armouryImages", "d" + Game.getDungeon() + "_armoury_background" );

        armourymanIV.setVisible(false);
        setImage(armourymanIV, "armouryImages", "d" + Game.getDungeon() + "_armouryman" );

        livingHeroes = Game.getLivingHeroes();
        Functions.setBarImages(livingHeroes, heroImages);

        livingHeroSlugs = Game.getLivingHeroSlugs();

        coinCountLB.setText(String.valueOf(Game.getGoldPieces()));

        heroRecapSP.setVisible(false);
        heroRecapSP.setDisable(true);


    }

    public void onBackBtnClk() throws IOException { LoadScene.changeScene("dungeon-entry-hall"); }

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
                int stat = 0;
                if(!(item[4].equals("grimoire") || item[4].equals("consumable"))) {
                    stat = (int) round((0.75 + (0.25 * Integer.valueOf(item[2]))) * Integer.parseInt(dict.get("stat")));
                }

                String toDisplay = "";
                toDisplay += name + "\n";

                if((item[4].equals("grimoire") || item[4].equals("consumable"))){
                    toDisplay += "Sorts inclus: " + dict.get("effet");
                } else {
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
            System.out.println("test");
            armourymanIV.setLayoutX(25);
            heroRecapSP.setVisible(false);
            heroRecapSP.setDisable(true);
        }
    }


    @FXML
    void onItemBtnClk() throws IOException {

        String[] item = itemList.get(currentItem).split("\\|");
        String itemSlug = item[0];

        HashMap<String, String> dict = getDictFromFile("armoury", itemSlug);
        double cost = Double.parseDouble(dict.get("cost"));
        if (!(curHero == null)) {
            if (Game.hasEnoughGoldPieces(cost)) {

                Game.takeGoldPieces(cost);
                coinCountLB.setText(String.valueOf(Game.getGoldPieces()));

                String itemName = dict.get("name") + item[1];
                int level = Integer.parseInt(item[2]);
                int quality = Integer.parseInt(item[3]);
                int stat = 0;
                if(!(item[4].equals("grimoire") || item[4].equals("consumable"))) {
                    stat = (int) round((0.75 + (0.25 * level)) * Integer.parseInt(dict.get("stat")));
                }
                switch(item[4]){
                    case "mainWeapon":
                        curHero.setMainWeapon(itemSlug, itemName, level , quality, stat );
                        break;
                    case "throwableWeapon":
                        curHero.setThrowableWeapon(itemSlug, itemName, level , quality, stat );
                        break;
                    case "headItem":
                        curHero.setHeadItem(itemSlug, itemName, level , quality, stat );
                        break;
                    case "bodyItem":
                        curHero.setBodyItem(itemSlug, itemName, level , quality, stat );
                        break;
                    case "grimoire":
                        Grimoire grim = new Grimoire(itemSlug, itemName, level);
                        curHero.addItem(grim);
                        break;
                    case "fleche":
                        ((Elfe) curHero).setFleches(level, 1);
                        break;
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
        currentHeroName = livingHeroSlugs.get(0);
        currentHeroIndex = 0;
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
