package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Functions;
import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static com.naheulback.ledonjondenaheulback.Functions.getDictFromFile;

public class ArmouryController {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";
    @FXML
    private VBox armouryItem1VB, armouryItem2VB, armouryItem3VB, armouryItem4VB, armouryItem5VB;
    @FXML
    private StackPane armouryItem1SP, armouryItem2SP, armouryItem3SP, armouryItem4SP, armouryItem5SP;
    @FXML
    private ImageView armouryItem1ButtonIV, armouryItem2ButtonIV, armouryItem3ButtonIV, armouryItem4ButtonIV, armouryItem5ButtonIV;
    @FXML
    private ImageView barmanIV;
    @FXML
    private Label armouryItem1Label, armouryItem2Label, armouryItem3Label, armouryItem4Label, armouryItem5Label;
    @FXML
    private Label barmanSpeakLbl;
    @FXML
    private ImageView barmanSpeakIV;
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
    private String currentHeroClass;
    private int currentItem;

    private int currentHeroIndex;
    private Hero currentHero;
    private ArrayList<String> livingHeroSlugs;
    private ArrayList<String> itemList;

    public void initialize() throws FileNotFoundException {

        currentHero = null;
        currentHeroIndex = 0;
        barmanSpeakLbl.setText("");

        armouryItemsHB.setDisable(true);
        armouryItemsHB.setVisible(false);
        itemImages = new ArrayList<>(Arrays.asList(armouryItem1ButtonIV, armouryItem2ButtonIV, armouryItem3ButtonIV, armouryItem4ButtonIV, armouryItem5ButtonIV));
        itemLabels = new ArrayList<>(Arrays.asList(armouryItem1Label, armouryItem2Label, armouryItem3Label, armouryItem4Label, armouryItem5Label));
        itemStackPanes = new ArrayList<>(Arrays.asList(armouryItem1SP, armouryItem2SP, armouryItem3SP, armouryItem4SP, armouryItem5SP));
        heroImages = new ArrayList(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));

        for(StackPane sp : itemStackPanes){
            sp.setVisible(false);
        }

        String path = resPath + "armouryImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_armoury_background.png");
        Image image = new Image(stream);
        mainIV.setImage(image);

        livingHeroSlugs = Game.getLivingHeroSlugs();
        Functions.setBarImages(livingHeroSlugs, heroImages);

        //path = resPath + "armouryImages/d";
        //barmanIV.setVisible(false);
        //stream = new FileInputStream(path + Game.getDungeon() + "_barman.png");
        //image = new Image(stream);
        //barmanIV.setImage(image);

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
            if(itemList.get(i).equals("empty")){
                armouryItemsHB.getChildren().remove(i);
            } else {
                String path = resPath + "armouryImages/";
                InputStream stream = new FileInputStream(path + itemList.get(i) + ".png");
                Image image = new Image(stream);
                itemImages.get(i).setImage(image);
            }
        }

        for(int i = 0; i < 5; i++){
            if(!itemList.get(i).equals("empty")) {
                String path = resPath + "armouryFiles/" + itemList.get(i);
                BufferedReader br = new BufferedReader(new FileReader(path));
                StringBuilder toDisplay = new StringBuilder();
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    String[] parts = line.split(":");
                    toDisplay.append(parts[1]);
                    if (!line.equals("")) {
                        toDisplay.append("\n");
                    }
                }
                itemLabels.get(i).setText(toDisplay.toString());
            }
        }

        armouryItemsHB.setVisible(true);
        armouryItemsHB.setDisable(false);
        //armouryItemsHB.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));

        int width = switch (armouryItemsHB.getChildren().size()) {
            case 1 -> 166;
            case 2 -> 352;
            case 3 -> 538;
            case 4 -> 744;
            case 5 -> 930;
            default -> 0;
        };
        armouryItemsHB.setLayoutX(500.0 - (width/2.0));
    }

    @FXML
    void onDrinkMenuHovering() {

    }
    @FXML
    void onDrinkMenuStoppedHovering() {

    }
    @FXML
    void onFoodMenuHovering() {

    }
    @FXML
    void onFoodMenuStoppedHovering() {

    }

    @FXML
    void onHeroClicked() throws IOException {
        if (!currentHeroName.equals("empty")) {
            currentHero = Game.getLivingHeroes().get(currentHeroIndex);
            System.out.println(currentHero.getName());
            //set image with barman
            barmanIV.setVisible(true);
            barmanIV.setLayoutX(25 + currentHeroIndex*153);
            loadArmouryItems(currentHero.getType());
        }

        //rien je crois

    }

    @FXML
    void onItemButtonClicked() throws IOException, InterruptedException {

        String itemName = itemList.get(currentItem);
        HashMap<String, String> dict = getDictFromFile("armoury", itemName);
        double cost = Integer.parseInt(dict.get("cost"));
        if (!(currentHero == null)) {
            if (Game.hasEnoughGoldPieces(cost)) {

                Game.takeGoldPieces(cost);

                currentHero.setMainWeapon(itemName, Integer.parseInt(dict.get("level")));
                System.out.println(currentHero.getMainWeapon().getName());

                switch (new Random().nextInt(5)){
                    case 1 -> {
                        barmanSpeakLbl.setText("Bon choix");
                    }
                    case 2 -> {
                        barmanSpeakLbl.setText("Belle arme");
                    }
                    case 3 -> {
                        barmanSpeakLbl.setText("Vous avez fait un bon choix");
                    }
                    case 4 -> {
                        barmanSpeakLbl.setText("Vos ennemis vont déguster");
                    }
                }

            } else {
                barmanSpeakLbl.setText("Tu n'as pas assez de pièces d'or pour ça");
                String path = "src/main/resources/com/naheulback/ledonjondenaheulback/tavernImages/";
                InputStream stream = new FileInputStream(path + "barman_pos" + currentHeroIndex + "_bubble.png");
                Image image = new Image(stream);
                barmanSpeakIV.setImage(image);
            }
        } else {
            barmanSpeakLbl.setText("Tu n'as pas choisi de héros");
            barmanIV.setVisible(true);
            barmanIV.setLayoutX(25);
            String path = "src/main/resources/com/naheulback/ledonjondenaheulback/tavernImages/";
            InputStream stream = new FileInputStream(path + "barman_pos0_bubble.png");
            Image image = new Image(stream);
            barmanSpeakIV.setImage(image);
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
