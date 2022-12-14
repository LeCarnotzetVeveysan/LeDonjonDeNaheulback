package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.Consumable;
import com.naheulback.nhlbck.classes.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static com.naheulback.nhlbck.Functions.*;

public class DungeonBarController {
    @FXML
    private VBox barItem1VB, barItem2VB, barItem3VB, barItem4VB, barItem5VB;
    @FXML
    private StackPane barItem1SP, barItem2SP, barItem3SP, barItem4SP, barItem5SP;
    @FXML
    private ImageView barmanIV, barFoodButton1IV, barFoodButton2IV, barFoodButton3IV, barFoodButton4IV, barFoodButton5IV;
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
    private Label barmanSpeakLbl;
    @FXML
    private ImageView barmanSpeakIV;
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
    @FXML
    private ImageView hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV, hero6HPBarIV;
    @FXML
    private Label hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB;
    @FXML
    private ImageView hero1ManaBarIV, hero2ManaBarIV, hero3ManaBarIV, hero4ManaBarIV, hero5ManaBarIV, hero6ManaBarIV;
    @FXML
    private Label hero1ManaBarLB, hero2ManaBarLB, hero3ManaBarLB, hero4ManaBarLB, hero5ManaBarLB, hero6ManaBarLB;
    private ArrayList<ImageView> itemImages;
    private ArrayList<Label> itemLabels, heroHPLabels, heroManaLabels;
    private ArrayList<StackPane> itemStackPanes;
    private ArrayList heroHPIVs;
    private ArrayList<ImageView> heroManaIVs;
    ArrayList<Hero> livingHeroes;
    private int currentItem;

    private int currentHeroIndex;
    private Hero currentHero;
    private ArrayList<String> itemList;
    @FXML
    private Label coinCountLB;

    public void initialize() throws FileNotFoundException {

        currentHero = null;
        currentHeroIndex = 0;
        barmanSpeakLbl.setText("");

        barItemsHB.setDisable(true);
        barItemsHB.setVisible(false);
        itemImages = new ArrayList<>(Arrays.asList(barFoodButton1IV, barFoodButton2IV, barFoodButton3IV, barFoodButton4IV, barFoodButton5IV));
        itemLabels = new ArrayList<>(Arrays.asList(barFoodLabel1, barFoodLabel2, barFoodLabel3, barFoodLabel4, barFoodLabel5));
        itemStackPanes = new ArrayList<>(Arrays.asList(barItem1SP, barItem2SP, barItem3SP, barItem4SP, barItem5SP));
        ArrayList<ImageView> heroImages = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        heroHPIVs = new ArrayList(Arrays.asList(hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV, hero6HPBarIV));
        heroHPLabels = new ArrayList(Arrays.asList(hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB));
        heroManaIVs = new ArrayList<>(Arrays.asList(hero1ManaBarIV, hero2ManaBarIV, hero3ManaBarIV, hero4ManaBarIV, hero5ManaBarIV, hero6ManaBarIV));
        heroManaLabels = new ArrayList<>(Arrays.asList(hero1ManaBarLB, hero2ManaBarLB, hero3ManaBarLB, hero4ManaBarLB, hero5ManaBarLB, hero6ManaBarLB));

        for(StackPane sp : itemStackPanes){
            sp.setVisible(false);
        }

        setImage(mainIV, "dungeonImages", "bar_background");
        setImage(barmanIV, "tavernImages", "d" + Game.getDungeon() + "_barman");

        livingHeroes = Game.getLivingHeroes();
        Functions.setBarImages(livingHeroes, heroImages);
        Functions.setHeroHPBars(livingHeroes, heroHPIVs, heroHPLabels, heroManaIVs, heroManaLabels);

        coinCountLB.setText(String.valueOf(Game.getGoldPieces()));
    }

    public void onBackButtonClicked() throws IOException { LoadScene.changeScene("dungeon-tavern"); }

    @FXML
    void onFoodMenuClicked() throws IOException { onMenuClicked("food"); }
    @FXML
    void onDrinkMenuClicked() throws IOException { onMenuClicked("drinks"); }

    private void onMenuClicked(String type) throws IOException {
        barItemsHB.getChildren().clear();
        ArrayList<VBox> barItems = new ArrayList<>(Arrays.asList(barItem1VB, barItem2VB, barItem3VB, barItem4VB, barItem5VB));
        for(VBox validVBox : barItems){
            barItemsHB.getChildren().add(validVBox);
        }
        itemList = Functions.getBarItems(type);
        Random rand = new Random();

        String cupOrPlate = type.equals("food") ? "plate" : "cup";
        for (int i = 1; i <= 5; i++){
            int index = rand.nextInt(7) + 1;
            setImage(itemImages.get(i - 1), "tavernImages", cupOrPlate + "_" + index);
        }

        for(int i = 0; i < 5; i++){
            HashMap<String, String> dict = getDictFromFile("game", type);
            String[] item = dict.get(itemList.get(i)).split(",");
            HashMap<String, String> healDict = getDictFromFile("armoury", "consumables");
            String[] item2 = healDict.get(itemList.get(i)).split(",");
            String toShow = item[0] + "\nEffet : + " + item2[0] + " PV, + " + item2[1] + " Mana \n" + item[2];
            itemLabels.get(i).setText(toShow);
        }
        setItemButtonHBSize(barItemsHB);
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
    void onHeroClicked() {
        if (currentHeroIndex <= livingHeroes.size() - 1) {
            barmanSpeakIV.setVisible(false);
            barmanSpeakLbl.setText("");
            currentHero = Game.getLivingHeroes().get(currentHeroIndex);
            barmanIV.setVisible(true);
            int armourymanX = switch (currentHeroIndex){
                case 0 -> 2*153;
                case 1 -> 3*153;
                case 2 -> 153;
                case 3 -> 4*153;
                case 4 -> 5*153;
                case 5 -> 0;
                default -> throw new IllegalStateException("Unexpected value: " + currentHeroIndex);
            };
            barmanIV.setLayoutX(25 + armourymanX);
        }
    }

    @FXML
    void onItemButtonClicked() throws IOException {
        
        String itemName = itemList.get(currentItem);
        String type = (itemName.contains("vin")||itemName.contains("biere")||itemName.contains("jus")||itemName.contains("liqueur")) ? "drinks" : "food";
        HashMap<String, String> dict = getDictFromFile("game", type);
        String[] item = dict.get(itemName).split(",");
        double cost = Double.parseDouble(item[1]);
        if (!(currentHero == null)) {
            if (Game.hasEnoughGoldPieces(cost)) {
                Game.takeGoldPieces(cost);
                
                Consumable cons = new Consumable(itemName, itemName.toLowerCase(),1);
                currentHero.addHealth(cons.getHealth());
                currentHero.addMana(cons.getMana());

                barmanSpeech();

                setHeroHPBars(livingHeroes, heroHPIVs, heroHPLabels, heroManaIVs, heroManaLabels);
                coinCountLB.setText(String.valueOf(Game.getGoldPieces()));

            } else {
                barmanSpeakLbl.setText("Tu n'as pas assez de pi??ces d'or pour ??a");
                setImage(barmanSpeakIV, "tavernImages","barman_pos0_bubble" );
            }
        } else {
            barmanSpeakLbl.setText("Tu n'as pas choisi de h??ros");
            barmanIV.setVisible(true);
            barmanIV.setLayoutX(25);
            setImage(barmanSpeakIV, "tavernImages","barman_pos0_bubble" );
        }
    }

    private void barmanSpeech() {
        switch (new Random().nextInt(5)){
            case 1 -> barmanSpeakLbl.setText("Bon choix");
            case 2 -> barmanSpeakLbl.setText("Bon app??tit");
            case 3 -> barmanSpeakLbl.setText("Vous avez fait un bon choix");
            case 4 -> barmanSpeakLbl.setText("Vos papilles vont se r??galer");
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
    void onHero1Hover() { currentHeroIndex = 0;}
    @FXML
    void onHero2Hover() {
        currentHeroIndex = 1;
    }
    @FXML
    void onHero3Hover() {
        currentHeroIndex = 2;
    }
    @FXML
    void onHero4Hover() {
        currentHeroIndex = 3;
    }
    @FXML
    void onHero5Hover() {
        currentHeroIndex = 4;
    }
    @FXML
    void onHero6Hover() {
        currentHeroIndex = 5;
    }
}
