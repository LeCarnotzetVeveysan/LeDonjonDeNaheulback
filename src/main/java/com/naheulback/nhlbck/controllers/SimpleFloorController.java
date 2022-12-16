package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.Enemy;
import com.naheulback.nhlbck.classes.Grimoire;
import com.naheulback.nhlbck.classes.Hero;
import com.naheulback.nhlbck.classes.Weapon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleFloorController {

    private int currentHeroIndex;
    private int activeHeroIndex;
    private Hero activeHero;
    private int currentEnemyIndex;
    private int activeEnemyIndex;
    private Enemy activeEnemy;
    private ArrayList<String> livingHeroSlugs;
    private ArrayList<Hero> livingHeroes;
    private ArrayList<ImageView> heroIVs;
    private ArrayList<Enemy> livingEnemies;
    private ArrayList<ImageView> enemyIVs;

    @FXML
    private ImageView activeHeroIV, hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV;
    @FXML
    private ImageView activeHeroHPBarIV, hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV;
    @FXML
    private Label activeHeroHPBarLB, hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB;
    private ArrayList<ImageView> heroHPBarivs;
    private ArrayList<Label> heroHPBarlbls;

    @FXML
    private ImageView activeEnemyIV, enemy1IV, enemy2IV, enemy3IV, enemy4IV, enemy5IV, enemy6IV;
    @FXML
    private ImageView activeEnemyHPBarIV, enemy1HPBarIV, enemy2HPBarIV, enemy3HPBarIV, enemy4HPBarIV, enemy5HPBarIV, enemy6HPBarIV;
    @FXML
    private Label activeEnemyHPBarLB, enemy1HPBarLB, enemy2HPBarLB, enemy3HPBarLB, enemy4HPBarLB, enemy5HPBarLB, enemy6HPBarLB;
    private ArrayList<ImageView> enemyHPBarivs;
    private ArrayList<Label> enemyHPBarlbls;

    @FXML
    private ImageView throwableWeapon1IV, throwableWeapon2IV, throwableWeapon3IV, throwableWeapon4IV, throwableWeapon5IV, throwableWeapon6IV;
    private ArrayList<ImageView> throwableWeaponIVs;
    private ArrayList<Weapon> throwableWeapons;

    @FXML
    private StackPane inventorySP;
    @FXML
    private ImageView invSlot1IV, invSlot2IV, invSlot3IV, invSlot4IV, invSlot5IV, invSlot6IV, invSlot7IV, invSlot8IV, invSlot9IV, invSlot10IV;
    private ArrayList<ImageView> inventoryIVs;
    private int currentInventoryItem;

    @FXML
    private HBox actionButtonHB;
    @FXML
    private ImageView mainActionButtonIV, secondaryActionButtonIV;
    @FXML
    private Button nextFloorButton;

    public void initialize() throws IOException {

        activeHero = null;
        activeHeroIndex = -1;
        activeEnemyIndex = -1;
        livingHeroSlugs = Game.getLivingHeroSlugs();
        livingHeroes = Game.getLivingHeroes();
        heroIVs = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        heroHPBarivs = new ArrayList<>(Arrays.asList(hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV));
        heroHPBarlbls = new ArrayList<>(Arrays.asList(hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB));

        throwableWeapons = new ArrayList<>();
        throwableWeaponIVs = new ArrayList<>(Arrays.asList(throwableWeapon1IV, throwableWeapon2IV, throwableWeapon3IV, throwableWeapon4IV, throwableWeapon5IV, throwableWeapon6IV));

        livingEnemies = Functions.getEnemyList(Game.getRoom());

        enemyIVs = new ArrayList<>(Arrays.asList(enemy1IV, enemy2IV, enemy3IV, enemy4IV, enemy5IV, enemy6IV));
        enemyHPBarivs = new ArrayList<>(Arrays.asList(enemy1HPBarIV, enemy2HPBarIV, enemy3HPBarIV, enemy4HPBarIV, enemy5HPBarIV,enemy6HPBarIV));
        enemyHPBarlbls = new ArrayList<>(Arrays.asList(enemy1HPBarLB, enemy2HPBarLB, enemy3HPBarLB, enemy4HPBarLB, enemy5HPBarLB, enemy6HPBarLB));
        refreshImagesAndHPBars();

        inventoryIVs = new ArrayList<>(Arrays.asList(invSlot1IV, invSlot2IV, invSlot3IV, invSlot4IV, invSlot5IV, invSlot6IV, invSlot7IV, invSlot8IV, invSlot9IV, invSlot10IV));
        inventorySP.setVisible(false);
        inventorySP.setDisable(true);

        actionButtonHB.setDisable(true);
        actionButtonHB.setVisible(false);

        postCombatCheck();
    }

    private void refreshImagesAndHPBars() throws FileNotFoundException {
        Functions.setCombatEnemyImages(livingEnemies, enemyIVs, activeEnemy, activeEnemyIV);
        Functions.setEnemyHPBars(livingEnemies, enemyHPBarivs, enemyHPBarlbls);
        Functions.setEnemyHPBars(new ArrayList<>(Arrays.asList(activeEnemy)),new ArrayList<>(Arrays.asList(activeEnemyHPBarIV)), new ArrayList<>(Arrays.asList(activeEnemyHPBarLB)));
        Functions.setCombatHeroImages(livingHeroes, heroIVs, activeHero, activeHeroIV);
        Functions.setHeroHPBars(livingHeroes, heroHPBarivs, heroHPBarlbls);
        Functions.setHeroHPBars(new ArrayList<>(Arrays.asList(activeHero)),new ArrayList<>(Arrays.asList(activeHeroHPBarIV)), new ArrayList<>(Arrays.asList(activeHeroHPBarLB)));
        Functions.setThrowableWeaponImages(throwableWeapons, throwableWeaponIVs);
    }

    private void postCombatCheck() throws IOException {
        if(allDeadEnemies()){
            nextFloorButton.setDisable(false);
            for(int i = 0; i <= 5; i++){
                Functions.setEnemyStateInFile(Game.getRoom(), i ,"false");
            }
            //Get back active hero in heroList
            retrieveActiveHero();
            for(Hero h : livingHeroes){
                if(!(h == null)) {
                    h.setWeaponThrowed(false);
                }
            }
            throwableWeapons.clear();

        } else {
            System.out.println("Il y a encore des ennemis vivants");
        }

    }

    private void retrieveActiveHero() {
        if(!(activeHero == null)) {
            livingHeroes.set(activeHeroIndex, activeHero);
            livingHeroSlugs.set(activeHeroIndex, activeHero.getSlug());
            activeHero = null;
        }
    }

    private boolean allDeadEnemies(){
        boolean tempBool = true;

        for(Enemy e : livingEnemies){
            if(!(e == null)){
                if(e.getIsAlive()){
                    tempBool = false;
                }
            }
        }
        if(!(activeEnemy == null)){
            if(activeEnemy.getIsAlive()){
                tempBool = false;
            }
        }

        return tempBool;
    }

    public void updateActionButtons() throws FileNotFoundException {

        if(!(activeHero == null)) {
            if (!(activeHero.getMainWeapon() == null)) {
                Functions.setImage(mainActionButtonIV, "armouryImages", activeHero.getMainWeapon().getSlug());
            } else {
                Functions.setImage(mainActionButtonIV, "combatImages", "fists");
            }

            if (!(activeHero.getThrowableWeapon() == null) && !activeHero.getWeaponThrowed()) {
                Functions.setImage(secondaryActionButtonIV, "armouryImages", activeHero.getThrowableWeapon().getSlug());
            } else {
                Functions.setImage(secondaryActionButtonIV, "combatImages", "fists");
            }


            if ((activeHero.getType().equals("mage")) || (activeHero.getType().equals("priestess"))) {

            }
        }
    }

    public void onActiveHeroClicked() throws FileNotFoundException {
        if(!(activeHero == null)){
            actionButtonHB.setDisable(false);
            actionButtonHB.setVisible(true);
            updateActionButtons();
        }
    }

    public void onHeroClicked() throws FileNotFoundException {

        if(!livingHeroSlugs.get(currentHeroIndex).equals("empty")) {
            if(!(activeHeroIndex == -1)) {
                if(!(activeHero == null)){
                    livingHeroes.set(activeHeroIndex, activeHero);
                    livingHeroSlugs.set(activeHeroIndex, activeHero.getSlug());
                }

            }
            activeHeroIndex = currentHeroIndex;
            activeHero = livingHeroes.get(currentHeroIndex);
            livingHeroes.set(currentHeroIndex, null);
            livingHeroSlugs.set(currentHeroIndex, "empty");
            actionButtonHB.setDisable(false);
            actionButtonHB.setVisible(true);
            inventorySP.setDisable(false);
            inventorySP.setVisible(true);
            Functions.setInventoryImages(activeHero.getInventory(), inventoryIVs);
            updateActionButtons();

        } else {
            System.out.println("no selectable hero");
            actionButtonHB.setDisable(true);
            actionButtonHB.setVisible(false);
            inventorySP.setDisable(true);
            inventorySP.setVisible(false);
        }
        refreshImagesAndHPBars();
    }

    public void onActiveEnemyClicked() {
        System.out.println(activeEnemy);
    }

    public void onEnemyClicked() throws FileNotFoundException {

        if ((livingEnemies.get(currentEnemyIndex) == null) || !livingEnemies.get(currentEnemyIndex).getIsAlive()) {
            System.out.println("no selectable enemy");
        } else {
            if (activeEnemy != null) {
                livingEnemies.set(activeEnemyIndex, activeEnemy);
            }
            activeEnemy = livingEnemies.get(currentEnemyIndex);
            livingEnemies.set(currentEnemyIndex, null);
            activeEnemyIndex = currentEnemyIndex;
        }
        refreshImagesAndHPBars();
    }

    public void onMainWeaponButtonClicked() throws IOException {
        if(!(activeEnemy == null)) {
            activeEnemy.removeHealth(25);
            if(activeEnemy.getHealth() <= 0){
                activeEnemy.setIsAlive(false);
            }
            if(!activeEnemy.getIsAlive()){

                livingEnemies.set(activeEnemyIndex, activeEnemy);
                Functions.setImage(enemyIVs.get(activeEnemyIndex),"combatImages",activeEnemy.getSlug() + "_dead" );
                activeEnemy = null;

                if(Game.getLevel() == 1){
                    Functions.setEnemyStateInFile(1,activeEnemyIndex,"false");
                }

            }

        } else {
            System.out.println("Il n'y a pas d'ennemi actif");
        }

        postCombatCheck();
        refreshImagesAndHPBars();
        updateActionButtons();
    }

    public void onThrowableWeaponButtonClicked() throws IOException {
        if(!(activeEnemy == null)) {
            if (activeHero.getThrowableWeapon() == null) {
                System.out.println("no throwable weaon equipped");
            } else {
                if (activeHero.getWeaponThrowed()) {
                    System.out.println("weapon is already throwed");
                } else {
                    activeHero.setWeaponThrowed(true);
                    //deal damage
                    throwableWeapons.add(activeHero.getThrowableWeapon());
                }
            }
        } else {
            System.out.println("Il n'y a pas d'ennemi actif");
        }
        postCombatCheck();
        refreshImagesAndHPBars();
        updateActionButtons();
    }

    public void onThirdActionButtonClicked() throws FileNotFoundException {

    }


    public void onNextButtonClicked() throws IOException {
        retrieveActiveHero();
        Game.setRoom(Game.getRoom() + 1);
        LoadScene.changeScene("dungeon-simple-floor");
    }

    public void onBackButtonClicked() throws IOException {
        retrieveActiveHero();
        Game.setRoom(Game.getRoom() -1);
        if(Game.getRoom() == 0){
            LoadScene.changeScene("dungeon-entry-hall");
        } else {
            LoadScene.changeScene("dungeon-simple-floor");
        }
    }

    public void onSlotClicked() {
        if(!(activeHero == null)){
            if (activeHero.getInventory().get(currentInventoryItem).getSlug().contains("grimoire")) {
                System.out.println("C'est un grimoire");
                Grimoire grim = (Grimoire) activeHero.getInventory().get(currentInventoryItem);
                activeHero.setMainSpell(grim.getSpell1());
                activeHero.setSecondarySpell(grim.getSpell2());
            }
            if(activeHero.getInventory().get(currentInventoryItem).getSlug().contains("carquois")){
                System.out.println("C'est un carquois");
                activeHero.setActiveCarquois(activeHero.getInventory().get(currentInventoryItem).getSlug());
            }
        }

    }

    public void onEnemy1Hover() {
        currentEnemyIndex = 0;
    }
    public void onEnemy1StoppedHover() {
    }
    public void onEnemy2Hover() {
        currentEnemyIndex = 1;
    }
    public void onEnemy2StoppedHover() {
    }
    public void onEnemy3Hover() {
        currentEnemyIndex = 2;
    }
    public void onEnemy3StoppedHover() {
    }
    public void onEnemy4Hover() {
        currentEnemyIndex = 3;
    }
    public void onEnemy4StoppedHover() {
    }
    public void onEnemy5Hover() {
        currentEnemyIndex = 4;
    }
    public void onEnemy5StoppedHover() {
    }
    public void onEnemy6Hover() {
        currentEnemyIndex = 5;
    }
    public void onEnemy6StoppedHover() {
    }
    public void onHero1Hover() {
        currentHeroIndex = 0;
    }
    public void onHero1StoppedHover() {
    }
    public void onHero2Hover() {
        currentHeroIndex = 1;
    }
    public void onHero2StoppedHover() {
    }
    public void onHero3Hover() {
        currentHeroIndex = 2;
    }
    public void onHero3StoppedHover() {
    }
    public void onHero4Hover() {
        currentHeroIndex = 3;
    }
    public void onHero4StoppedHover() {

    }
    public void onHero5Hover() {
        currentHeroIndex = 4;
    }
    public void onHero5StoppedHover() {
    }
    public void onHero6Hover() {
        currentHeroIndex = 5;
    }
    public void onHero6StoppedHover() {
    }


    public void onSlot1Hover() {
        currentInventoryItem = 0;
    }
    public void onSlot1EndHover() {
    }
    public void onSlot2Hover() {
        currentInventoryItem = 1;
    }
    public void onSlot2EndHover() {
    }
    public void onSlot3Hover() {
        currentInventoryItem = 2;
    }
    public void onSlot3EndHover() {
    }
    public void onSlot4Hover() {
        currentInventoryItem = 3;
    }
    public void onSlot4EndHover() {
    }
    public void onSlot5Hover() {
        currentInventoryItem = 4;
    }
    public void onSlot5EndHover() {
    }
    public void onSlot6Hover() {
        currentInventoryItem = 5;
    }
    public void onSlot6EndHover() {
    }
    public void onSlot7Hover() {
        currentInventoryItem = 6;
    }
    public void onSlot7EndHover() {
    }
    public void onSlot8Hover() {
        currentInventoryItem = 7;
    }
    public void onSlot8EndHover() {
    }
    public void onSlot9Hover() {
        currentInventoryItem = 8;
    }
    public void onSlot9EndHover() {
    }
    public void onSlot10Hover() {
        currentInventoryItem = 9;
    }
    public void onSlot10EndHover() {
    }

}


