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
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.naheulback.nhlbck.Game.addGoldPieces;

public class SimpleFloorController {

    private int currentHeroIndex;
    private int activeHeroIndex;
    private Hero activeHero;
    private int currentEnemyIndex;
    private int activeEnemyIndex;
    private Enemy activeEnemy;
    private ArrayList<Hero> livingHeroes;
    private ArrayList<ImageView> heroIVs;
    private ArrayList<Enemy> livingEnemies;
    private ArrayList<ImageView> enemyIVs;

    @FXML
    private ImageView combatSpeechIV;
    @FXML
    private StackPane combatSpeechSP;
    @FXML
    private Label combatSpeechLbl;

    @FXML
    private ImageView activeHeroIV, hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV;
    @FXML
    private ImageView activeHeroHPBarIV, activeHeroManaBarIV, hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV;
    @FXML
    private Label activeHeroHPBarLB, activeHeroManaBarLB, hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB;
    private ArrayList<ImageView> heroHPBarIVs, heroManaIVs;
    private ArrayList<Label> heroHPBarLBs, heroManaLabels;

    @FXML
    private Label flechesCountLB;

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
    private ImageView hero1ManaBarIV, hero2ManaBarIV, hero3ManaBarIV, hero4ManaBarIV, hero5ManaBarIV, hero6ManaBarIV;
    @FXML
    private Label hero1ManaBarLB, hero2ManaBarLB, hero3ManaBarLB, hero4ManaBarLB, hero5ManaBarLB, hero6ManaBarLB;

    @FXML
    private HBox actionButtonHB;
    @FXML
    private ImageView mainActionButtonIV, secondaryActionButtonIV, thirdActionButtonIV;
    @FXML
    private Button nextFloorButton;

    public void initialize() throws IOException {

        activeHero = null;
        activeHeroIndex = -1;
        activeEnemyIndex = -1;
        livingHeroes = Game.getLivingHeroes();
        heroIVs = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        heroHPBarIVs = new ArrayList<>(Arrays.asList(hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV));
        heroHPBarLBs = new ArrayList<>(Arrays.asList(hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB));
        heroManaIVs = new ArrayList<>(Arrays.asList(hero1ManaBarIV, hero2ManaBarIV, hero3ManaBarIV, hero4ManaBarIV, hero5ManaBarIV, hero6ManaBarIV));
        heroManaLabels = new ArrayList<>(Arrays.asList(hero1ManaBarLB, hero2ManaBarLB, hero3ManaBarLB, hero4ManaBarLB, hero5ManaBarLB, hero6ManaBarLB));
        throwableWeapons = new ArrayList<>();
        throwableWeaponIVs = new ArrayList<>(Arrays.asList(throwableWeapon1IV, throwableWeapon2IV, throwableWeapon3IV, throwableWeapon4IV, throwableWeapon5IV, throwableWeapon6IV));

        livingEnemies = Functions.getEnemyList(Game.getRoom());
        enemyIVs = new ArrayList<>(Arrays.asList(enemy1IV, enemy2IV, enemy3IV, enemy4IV, enemy5IV, enemy6IV));
        enemyHPBarivs = new ArrayList<>(Arrays.asList(enemy1HPBarIV, enemy2HPBarIV, enemy3HPBarIV, enemy4HPBarIV, enemy5HPBarIV,enemy6HPBarIV));
        enemyHPBarlbls = new ArrayList<>(Arrays.asList(enemy1HPBarLB, enemy2HPBarLB, enemy3HPBarLB, enemy4HPBarLB, enemy5HPBarLB, enemy6HPBarLB));
        sceneRefresh();

        inventoryIVs = new ArrayList<>(Arrays.asList(invSlot1IV, invSlot2IV, invSlot3IV, invSlot4IV, invSlot5IV, invSlot6IV, invSlot7IV, invSlot8IV, invSlot9IV, invSlot10IV));
        inventorySP.setVisible(false);
        inventorySP.setDisable(true);

        actionButtonHB.setDisable(true);
        actionButtonHB.setVisible(false);

        postCombatCheck();
    }

    private void sceneRefresh() throws FileNotFoundException {
        Functions.setCombatEnemyImages(livingEnemies, enemyIVs, activeEnemy, activeEnemyIV);
        Functions.setEnemyHPBars(livingEnemies, enemyHPBarivs, enemyHPBarlbls);
        Functions.setEnemyHPBars(new ArrayList<>(Collections.singletonList(activeEnemy)),new ArrayList<>(Collections.singletonList(activeEnemyHPBarIV)), new ArrayList<>(Collections.singletonList(activeEnemyHPBarLB)));
        Functions.setCombatHeroImages(livingHeroes, heroIVs, activeHero, activeHeroIV);
        Functions.setHeroHPBars(livingHeroes, heroHPBarIVs, heroHPBarLBs, heroManaIVs,heroManaLabels );
        Functions.setActiveHeroHPBars(activeHero,activeHeroHPBarIV,activeHeroHPBarLB,activeHeroManaBarIV,activeHeroManaBarLB);
        Functions.setThrowableWeaponImages(throwableWeapons, throwableWeaponIVs);
        if(!(activeHero == null)){Functions.setInventoryImages(activeHero.getInventory(), inventoryIVs);}
        updateActionButtons();
    }

    private void postCombatCheck() throws IOException {

        checkHeroHealthPoints();

        if(allDeadHeroes()){
            PlayerData.setIsDefeated(true);
            LoadScene.changeScene("results-screen");
        }

        if(!(activeEnemy == null)) {
            if (activeEnemy.getHealth() <= 0) { getEnemyReward(); setDeadEnemy(); }
        }

        if(allDeadEnemies()){
            nextFloorButton.setDisable(false);
            for(int i = 0; i <= 5; i++){
                Functions.setEnemyStateInFile(Game.getRoom(), i ,"false");
            }
            retrieveActiveHero();
            for(Hero h : livingHeroes){
                if(!(h == null)) { h.setWeaponThrowed(false); }
            }
            throwableWeapons.clear();
        }
    }

    private void checkHeroHealthPoints() throws FileNotFoundException {

        if(!(activeHero == null)) {
            if (activeHero.getHealth() <= 0) {
                activeHero.setIsAlive(false);
                activeHero = null;
                retrieveActiveHero();
                updateActionButtons();
            }
        }
        for(Hero h : livingHeroes ){
            if(!(h == null)) {
                if (h.getHealth() <= 0) {
                    h.setIsAlive(false);
                    h = null;
                }
            }
        }
        sceneRefresh();
    }

    private void setDeadEnemy() throws IOException {
        activeEnemy.setIsAlive(false);
        livingEnemies.set(activeEnemyIndex, activeEnemy);
        Functions.setImage(enemyIVs.get(activeEnemyIndex), "combatImages", activeEnemy.getSlug() + "_dead");
        activeEnemy = null;
        if (Game.getLevel() == 1) { Functions.setEnemyStateInFile(1, activeEnemyIndex, "false"); }
    }

    private void getEnemyReward() {
        double goldToAdd = activeEnemy.getGoldGain();
        addGoldPieces(Math.round(goldToAdd));

        double expToAdd = activeEnemy.getExpGain();
        activeHero.addExperience((int) Math.round(expToAdd));
        activeHero.setLevel();
        for(Hero h : livingHeroes){
            if(!(h == null)){
                h.addExperience((int) Math.round(expToAdd));
                h.setLevel();
            }
        }
    }

    private void retrieveActiveHero() {
        if(!(activeHero == null)) {
            livingHeroes.set(activeHeroIndex, activeHero);
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

    private boolean allDeadHeroes(){
        boolean tempBool = true;
        for(Hero h : livingHeroes){
            if(!(h == null)){
                if(h.getIsAlive()){
                    tempBool = false;
                }
            }
        }
        if(!(activeHero == null)){
            if(activeHero.getIsAlive()){
                tempBool = false;
            }
        }

        return tempBool;
    }

    public void updateActionButtons() throws FileNotFoundException {

        if(!(activeHero == null)) {

            flechesCountLB.setText("");
            Functions.setImage(thirdActionButtonIV, "otherImages", "speech_bubble");

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

            if ((activeHero.getType().equals("elfe"))) {
                if(!(((Elfe) activeHero).getCarquois() == null)) {
                    switch (((Elfe) activeHero).getCarquois().getSlug()) {
                        case "carquois_base" -> Functions.setImage(secondaryActionButtonIV, "armouryImages", "fleche_base");
                        case "carquois_qualité" -> Functions.setImage(secondaryActionButtonIV, "armouryImages", "fleche_qualité");
                        case "carquois_sylvain" -> Functions.setImage(secondaryActionButtonIV, "armouryImages", "fleche_sylvaine");
                    }
                    flechesCountLB.setText(String.valueOf(((Elfe) activeHero).getCarquois().getFleches()));
                }
            }

            if ((activeHero.getType().equals("mage"))) {
                Spell firstSpell = ((Mage) activeHero).getFirstSpell();
                Spell secondSpell = ((Mage) activeHero).getFirstSpell();
                if(!(firstSpell == null)){ Functions.setImage(secondaryActionButtonIV, "combatImages", firstSpell.getSlug()); }
                if(!(secondSpell == null)){ Functions.setImage(thirdActionButtonIV, "combatImages", secondSpell.getSlug());}
            }
        } else {
            actionButtonHB.setDisable(true);
            actionButtonHB.setVisible(false);
            inventorySP.setDisable(true);
            inventorySP.setVisible(false);
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
        if(currentHeroIndex <= livingHeroes.size() - 1) {
            if (!(livingHeroes.get(currentHeroIndex) == null)) {
                if (!(activeHeroIndex == -1)) {
                    if (!(activeHero == null)) {
                        livingHeroes.set(activeHeroIndex, activeHero);
                    }

                }
                activeHeroIndex = currentHeroIndex;
                activeHero = livingHeroes.get(currentHeroIndex);
                livingHeroes.set(currentHeroIndex, null);
                actionButtonHB.setDisable(false);
                actionButtonHB.setVisible(true);
                inventorySP.setDisable(false);
                inventorySP.setVisible(true);
                Functions.setInventoryImages(activeHero.getInventory(), inventoryIVs);
                updateActionButtons();

            } else {
                actionButtonHB.setDisable(true);
                actionButtonHB.setVisible(false);
                inventorySP.setDisable(true);
                inventorySP.setVisible(false);
            }
        } else {
            actionButtonHB.setDisable(true);
            actionButtonHB.setVisible(false);
            inventorySP.setDisable(true);
            inventorySP.setVisible(false);
        }
        sceneRefresh();
    }
    public void onEnemyClicked() throws FileNotFoundException {
        if (!((livingEnemies.get(currentEnemyIndex) == null) || !livingEnemies.get(currentEnemyIndex).getIsAlive())) {
            if (activeEnemy != null) { livingEnemies.set(activeEnemyIndex, activeEnemy); }
            activeEnemy = livingEnemies.get(currentEnemyIndex);
            livingEnemies.set(currentEnemyIndex, null);
            activeEnemyIndex = currentEnemyIndex;
        }
        sceneRefresh();
    }

    public void onMainWeaponButtonClicked() throws IOException {
        if(!(activeEnemy == null)) {
            Weapon weapon = activeHero.getMainWeapon();
            weaponAttack(weapon);
        } else {
            System.out.println("Il n'y a pas d'ennemi actif");
        }
        enemyAttack();
        postCombatCheck();
        sceneRefresh();
    }

    private void enemyAttack(){

        if(activeEnemy == null) {
            for (int i = 0; i < livingEnemies.size(); i++) {
                if (!((livingEnemies.get(i) == null) || !livingEnemies.get(i).getIsAlive())) {
                    activeEnemy = livingEnemies.get(i);
                    livingEnemies.set(i, null);
                    activeEnemyIndex = i;
                    break;
                }
            }
        }
        double damage = activeEnemy.getBaseAttack();
        damage *= activeHero.getResistanceMultiplier();
        damage = Math.round(damage);
        activeHero.removeHealth((int) damage);
    }

    private void weaponAttack(Weapon weapon) {
        double damage;
        damage = activeHero.getFlatAttack(weapon);
        damage *= activeEnemy.getResistanceMultiplier();
        damage = Math.round(damage);
        activeEnemy.removeHealth((int) damage);

        double qualityLoss = Math.pow(1.25, Game.getLevel());
        qualityLoss = Math.round(100*qualityLoss)/100.0;
        if(!(weapon == null)) {
            weapon.decreaseQuality(qualityLoss);
        }
    }

    private void spellAttack(Spell spell){
        double damage;
        damage = activeHero.getFlatMagic(activeHero, spell);
        damage *= activeEnemy.getResistanceMultiplier();
        damage = Math.round(damage);
        activeEnemy.removeHealth((int) damage);
        activeHero.removeMana(spell.getManaCost());
    }

    private void arrowAttack(Carquois carquois){
        double damage;
        damage = activeHero.getFlatAttack(carquois.getArrow());
        if(!(activeHero.getMainWeapon() == null)) {
            damage += activeHero.getMainWeapon().getPower();
        } else {
            damage = 0;
        }
        damage *= activeEnemy.getResistanceMultiplier();
        damage = Math.round(damage);
        activeEnemy.removeHealth((int) damage);
        carquois.setFleches(-1);
    }

    public void onThrowableWeaponButtonClicked() throws IOException {
        if(!(activeEnemy == null)) {
            if(activeHero.getWeaponThrowed()){
              weaponAttack(null);
            } else {
                if(activeHero.getType().equals("mage") && !(((Mage) activeHero).getFirstSpell() == null)){
                    spellAttack(((Mage) activeHero).getFirstSpell());
                } else if (activeHero.getType().equals("elfe") && !(((Elfe) activeHero).getCarquois() == null)){
                    Carquois carquois = ((Elfe) activeHero).getCarquois();
                    if(carquois.getFleches() > 0){ arrowAttack(carquois); }
                } else {
                    weaponAttack(activeHero.getThrowableWeapon());
                    activeHero.setWeaponThrowed(true);
                    throwableWeapons.add(activeHero.getThrowableWeapon());
                }
            }
        } else {
            System.out.println("Il n'y a pas d'ennemi actif");
        }
        enemyAttack();
        postCombatCheck();
        sceneRefresh();
    }

    public void onThirdActionButtonClicked() throws IOException {

        if(activeHero.getType().equals("mage") && !(((Mage) activeHero).getSecondarySpell() == null)){
            spellAttack(((Mage) activeHero).getSecondarySpell());
        } else {
            combatQuote(activeHero);
        }
        enemyAttack();
        postCombatCheck();
        sceneRefresh();

    }

    private void combatQuote(Hero hero) {
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

    public void onSlotClicked() throws FileNotFoundException {
        if(!(activeHero == null) && !(currentInventoryItem > activeHero.getInventory().size() - 1)){
            String slug = activeHero.getInventory().get(currentInventoryItem).getSlug();
            if (slug.contains("grimoire")) {
                Grimoire grim = (Grimoire) activeHero.getInventory().get(currentInventoryItem);
                ((Mage) activeHero).setMainSpell(grim.getSpell1());
                ((Mage) activeHero).setSecondarySpell(grim.getSpell2());
            }
            if(slug.contains("carquois")){
                switch (slug){
                    case "carquois_base" -> ((Elfe) activeHero).setCarquois(1);
                    case "carquois_qualité" -> ((Elfe) activeHero).setCarquois(2);
                    case "carquois_sylvain" -> ((Elfe) activeHero).setCarquois(3);
                }
            }
            if(slug.contains("potion")){
                Consumable potion = (Consumable) activeHero.getInventory().get(currentInventoryItem);
                activeHero.addHealth(potion.getHealth());
                activeHero.addMana(potion.getMana());
                activeHero.getInventory().remove(currentInventoryItem);
            }
        }
        sceneRefresh();
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


