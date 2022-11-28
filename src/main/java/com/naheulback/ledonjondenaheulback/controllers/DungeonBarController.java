package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Functions;
import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DungeonBarController {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";

    @FXML
    private VBox barItem1VB, barItem2VB, barItem3VB, barItem4VB, barItem5VB;
    @FXML
    private StackPane barItem1SP, barItem2SP, barItem3SP, barItem4SP, barItem5SP;
    @FXML
    private ImageView barFoodButton1IV;
    @FXML
    private ImageView barFoodButton2IV;
    @FXML
    private ImageView barFoodButton3IV;
    @FXML
    private ImageView barFoodButton4IV;
    @FXML
    private ImageView barFoodButton5IV;
    @FXML
    private Label barFoodLabel1;
    @FXML
    private Label barFoodLabel2;
    @FXML
    private Label barFoodLabel3;
    @FXML
    private Label barFoodLabel4;
    @FXML
    private Label barFoodLabel5;
    @FXML
    private HBox barItemsHB;
    @FXML
    private ImageView drinkMenuIV;
    @FXML
    private ImageView foodMenuIV;

    @FXML
    private ImageView mainIV;
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
    private ArrayList<ImageView> itemImages;
    private ArrayList<Label> itemLabels;
    private ArrayList<VBox> barItems;
    private ArrayList<StackPane> itemStackPanes;

    private Hero currentHero;
    private int currentItem;

    public void initialize() throws FileNotFoundException {

        barItemsHB.setDisable(true);
        barItemsHB.setVisible(false);
        itemImages = new ArrayList<>(Arrays.asList(barFoodButton1IV, barFoodButton2IV, barFoodButton3IV, barFoodButton4IV, barFoodButton5IV));
        itemLabels = new ArrayList<>(Arrays.asList(barFoodLabel1, barFoodLabel2, barFoodLabel3, barFoodLabel4, barFoodLabel5));
        itemStackPanes = new ArrayList<>(Arrays.asList(barItem1SP, barItem2SP, barItem3SP, barItem4SP, barItem5SP));
        ArrayList<ImageView> heroImages = new ArrayList(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));

        for(StackPane sp : itemStackPanes){
            sp.setVisible(false);
        }

        String path = resPath + "dungeonImages/d";
        InputStream stream = new FileInputStream(path + Game.getDungeon() + "_bar_background.png");
        Image image = new Image(stream);
        mainIV.setImage(image);
        Functions.setBarImages(heroImages);

    }

    public void onBackButtonClicked() throws IOException { LoadScene.changeScene("dungeon-tavern"); }

    @FXML
    void onFoodMenuClicked() throws IOException {
        onMenuClicked("food");
    }
    @FXML
    void onDrinkMenuClicked() throws IOException {
        onMenuClicked("drinks");
    }

    private void onMenuClicked(String type) throws IOException {
        barItemsHB.getChildren().clear();
        barItems = new ArrayList<>(Arrays.asList(barItem1VB, barItem2VB, barItem3VB, barItem4VB, barItem5VB));
        for(VBox validVBox : barItems){
            barItemsHB.getChildren().add(validVBox);
        }

        ArrayList<String> itemList = Functions.getBarItems(type);
        for (int i = 4; i >= 0; i--){
            if(itemList.get(i).equals("empty")){
                barItemsHB.getChildren().remove(i);
            } else {
                String path = resPath + "tavernImages/";
                InputStream stream = new FileInputStream(path + itemList.get(i) + ".png");
                Image image = new Image(stream);
                itemImages.get(i).setImage(image);


            }
        }

        for(int i = 0; i < 5; i++){
            if(!itemList.get(i).equals("empty")) {
                String path = resPath + "tavernFiles/" + itemList.get(i);
                BufferedReader br = new BufferedReader(new FileReader(path));
                String toDisplay = "";
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    String[] parts = line.split(":");
                    toDisplay += parts[1];
                    if (!line.equals("")) {
                        toDisplay += "\n";
                    }
                }
                itemLabels.get(i).setText(toDisplay);
            }
        }

        barItemsHB.setVisible(true);
        barItemsHB.setDisable(false);
        //barItemsHB.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));

        int width = 0;
        switch (barItemsHB.getChildren().size()){
            case 1:
                width = 166;
                break;
            case 2:
                width = 352;
                break;
            case 3:
                width = 538;
                break;
            case 4:
                width = 744;
                break;
            case 5:
                width = 930;
                break;
        }
        barItemsHB.setLayoutX(500.0 - (width/2.0));
    }

    @FXML
    void onDrinkMenuHovering() {

    }
    @FXML
    void onDrinkMenuStoppedHovering() {

    }
    @FXML
    void onFoodMenuHovering(MouseEvent event) {

    }
    @FXML
    void onFoodMenuStoppedHovering(MouseEvent event) {

    }

    @FXML
    void onItemButtonClicked(MouseEvent event) {

    }

    @FXML
    void onItem1ButtonHovering(MouseEvent event) {
        currentItem = 0;
        itemStackPanes.get(0).setVisible(true);
    }

    @FXML
    void onItem1StoppedButtonHovering(MouseEvent event) {
        itemStackPanes.get(0).setVisible(false);
    }

    @FXML
    void onItem2ButtonHovering(MouseEvent event) {
        currentItem = 1;
        itemStackPanes.get(1).setVisible(true);
    }

    @FXML
    void onItem2StoppedButtonHovering(MouseEvent event) {
        itemStackPanes.get(1).setVisible(false);
    }

    @FXML
    void onItem3ButtonHovering(MouseEvent event) {
        currentItem = 2;
        itemStackPanes.get(2).setVisible(true);
    }

    @FXML
    void onItem3StoppedButtonHovering(MouseEvent event) {
        itemStackPanes.get(2).setVisible(false);
    }

    @FXML
    void onItem4ButtonHovering(MouseEvent event) {
        currentItem = 3;
        itemStackPanes.get(3).setVisible(true);
    }

    @FXML
    void onItem4StoppedButtonHovering(MouseEvent event) {
        itemStackPanes.get(3).setVisible(false);
    }

    @FXML
    void onItem5ButtonHovering(MouseEvent event) {
        currentItem = 4;
        itemStackPanes.get(4).setVisible(true);
    }

    @FXML
    void onItem5StoppedButtonHovering(MouseEvent event) {
        itemStackPanes.get(4).setVisible(true);
    }




}
