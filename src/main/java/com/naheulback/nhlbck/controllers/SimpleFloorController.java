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
import java.util.*;

import static com.naheulback.nhlbck.Game.addGoldPieces;
import static com.naheulback.nhlbck.Game.getRoom;

public class SimpleFloorController {

    private int currentHeroIndex, activeHeroIndex, currentEnemyIndex, activeEnemyIndex;
    private Hero activeHero;
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
    private Label arrowsCountLB;

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
        //Pour les tests de donjons
        HashMap<String,String> heroDict = Functions.getDictFromFile("hero","lachaud");
        if(livingHeroes.size() == 0){livingHeroes.add(new Warrior(heroDict));}
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
        inventoryIVs = new ArrayList<>(Arrays.asList(invSlot1IV, invSlot2IV, invSlot3IV, invSlot4IV, invSlot5IV, invSlot6IV, invSlot7IV, invSlot8IV, invSlot9IV, invSlot10IV));
        inventorySP.setVisible(false);
        inventorySP.setDisable(true);
        actionButtonHB.setDisable(true);
        actionButtonHB.setVisible(false);

        if(getRoom() == 10){
            nextFloorButton.setDisable(true);
            nextFloorButton.setVisible(false);
        }

        cleanActiveHero();
        postCombatCheck();
        sceneRefresh();

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
            LoadScene.changeScene("menu-main-menu");
        }

        if(!(activeEnemy == null)) {
            if (activeEnemy.getHealth() <= 0) { getEnemyReward(); setDeadEnemy(); }
            cleanActiveEnemy();
        }

        if(allDeadEnemies()){
            if(!(getRoom() == 10)){
                nextFloorButton.setDisable(false);
            }
            for(int i = 0; i <= 5; i++){
                Functions.setEnemyStateInFile(Game.getRoom(), i ,"false");
            }
            retrieveActiveHero();
            for(Hero h : livingHeroes){
                if(!(h == null)) { h.setWeaponThrowed(false); }
            }
            throwableWeapons.clear();
        }

        if(Functions.areAllBossesDefeated()){
            PlayerData.setIsDefeated(false);
            PlayerData.setHasSucceeded(true);
            LoadScene.changeScene("menu-main-menu");
        }

    }

    private void checkHeroHealthPoints() throws FileNotFoundException {

        if(!(activeHero == null)) {
            if (activeHero.getHealth() <= 0) {
                activeHero.setIsAlive(false);
                activeHero = null;
                cleanActiveHero();
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

        if(!(activeHero == null)) {
            activeHero.addExperience((int) Math.round(expToAdd));
            activeHero.setLevel();
        }
        for(Hero h : livingHeroes){
            if(!(h == null)){
                h.addExperience((int) Math.round(expToAdd));
                h.setLevel();
            }
        }
    }

    private void retrieveActiveHero() throws FileNotFoundException {
        if(!(activeHero == null)) {
            livingHeroes.set(activeHeroIndex, activeHero);
            activeHero = null;
        }
        cleanActiveHero();
    }

    private void cleanActiveHero() throws FileNotFoundException {
        if(activeHero == null){
            Functions.setImage(activeHeroIV,"heroImages","empty_combat");
            activeHeroHPBarIV.setVisible(false);
            activeHeroHPBarLB.setText("");
            activeHeroManaBarIV.setVisible(false);
            activeHeroManaBarLB.setText("");
        }
    }

    private void cleanActiveEnemy() throws FileNotFoundException {
        if(activeEnemy == null){
            Functions.setImage(activeEnemyIV,"heroImages","empty_combat");
            activeEnemyHPBarIV.setVisible(false);
            activeEnemyHPBarLB.setText("");
        }
    }

    private void removeNullHeroes(){
        ArrayList<Hero> tempList = new ArrayList<>();
        for(Hero h : livingHeroes){
            if(!(h == null)){
                tempList.add(h);
            }
        }
        livingHeroes = tempList;
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

        Random rand = new Random();
        if(!(activeHero == null)) {

            arrowsCountLB.setText("");
            Functions.setImage(thirdActionButtonIV, "otherImages", "speech_bubble");

            if (!(activeHero.getMainWeapon() == null)) {
                Functions.setImage(mainActionButtonIV, "armouryImages", "weaponItems_" + rand.nextInt(1, 8));
            } else {
                Functions.setImage(mainActionButtonIV, "combatImages", "fists");
            }

            if (!(activeHero.getThrowableWeapon() == null) && !activeHero.getWeaponThrowed()) {
                Functions.setImage(secondaryActionButtonIV, "armouryImages", "weaponItems_" + rand.nextInt(1, 8));
            } else {
                Functions.setImage(secondaryActionButtonIV, "combatImages", "fists");
            }

            if ((activeHero.getType().equals("elfe"))) {
                if(!(((Elven) activeHero).getQuiver() == null)) {
                    switch (((Elven) activeHero).getQuiver().getSlug()) {
                        case "quiver_base" -> Functions.setImage(secondaryActionButtonIV, "armouryImages", "arrow_base");
                        case "quiver_quality" -> Functions.setImage(secondaryActionButtonIV, "armouryImages", "arrow_quality");
                        case "quiver_elven" -> Functions.setImage(secondaryActionButtonIV, "armouryImages", "arrow_elvene");
                    }
                    arrowsCountLB.setText(String.valueOf(((Elven) activeHero).getQuiver().getArrows()));
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
        postCombatCheck();
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
        if(!(activeEnemy == null)) {
            double damage = activeEnemy.getBaseAttack();
            damage *= activeHero.getResistanceMultiplier();
            damage = Math.round(damage);
            activeHero.removeHealth((int) damage);
        }
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

    private void arrowAttack(Quiver quiver){
        double damage;
        damage = activeHero.getFlatAttack(quiver.getArrow());
        if(!(activeHero.getMainWeapon() == null)) {
            damage += activeHero.getMainWeapon().getPower();
        } else {
            damage = 0;
        }
        damage *= activeEnemy.getResistanceMultiplier();
        damage = Math.round(damage);
        activeEnemy.removeHealth((int) damage);
        quiver.setArrows(-1);
    }

    public void onThrowableWeaponButtonClicked() throws IOException {
        if(!(activeEnemy == null)) {
            if(activeHero.getWeaponThrowed() || (activeHero.getThrowableWeapon() == null)){
                weaponAttack(null);
            } else {
                if(activeHero.getType().equals("mage") && !(((Mage) activeHero).getFirstSpell() == null)){
                    spellAttack(((Mage) activeHero).getFirstSpell());
                } else if (activeHero.getType().equals("elfe") && !(((Elven) activeHero).getQuiver() == null)){
                    Quiver quiver = ((Elven) activeHero).getQuiver();
                    if(quiver.getArrows() > 0){ arrowAttack(quiver); }
                } else {
                    weaponAttack(activeHero.getThrowableWeapon());
                    activeHero.setWeaponThrowed(true);
                    throwableWeapons.add(activeHero.getThrowableWeapon());
                }
            }
        }
        postCombatCheck();
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
        postCombatCheck();
        enemyAttack();
        postCombatCheck();
        sceneRefresh();

    }

    private void combatQuote(Hero hero) {

    }


    public void onNextButtonClicked() throws IOException {
        retrieveActiveHero();
        removeNullHeroes();
        Game.setRoom(Game.getRoom() + 1);
        LoadScene.changeScene("dungeon-simple-floor");
    }

    public void onBackButtonClicked() throws IOException {
        retrieveActiveHero();
        removeNullHeroes();
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
            if (slug.contains("spellbook")) {
                SpellBook grim = (SpellBook) activeHero.getInventory().get(currentInventoryItem);
                ((Mage) activeHero).setMainSpell(grim.getSpell1());
                ((Mage) activeHero).setSecondarySpell(grim.getSpell2());
            }
            if(slug.contains("quiver")){
                switch (slug){
                    case "quiver_base" -> ((Elven) activeHero).setQuiver(1);
                    case "quiver_quality" -> ((Elven) activeHero).setQuiver(2);
                    case "quiver_elven" -> ((Elven) activeHero).setQuiver(3);
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


