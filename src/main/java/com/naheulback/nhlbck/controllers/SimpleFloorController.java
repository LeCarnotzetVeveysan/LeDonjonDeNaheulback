package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import com.naheulback.nhlbck.classes.Enemy;
import com.naheulback.nhlbck.classes.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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
    private GridPane actionButtonGridPane;

    public void initialize() throws IOException {

        activeHero = null;
        activeHeroIndex = -1;
        activeEnemyIndex = -1;
        livingHeroSlugs = Game.getLivingHeroSlugs();
        livingHeroes = Game.getLivingHeroes();
        heroIVs = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        heroHPBarivs = new ArrayList<>(Arrays.asList(hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV));
        heroHPBarlbls = new ArrayList<>(Arrays.asList(hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB));


        livingEnemies = Functions.getEnemyList(Game.getRoom());

        enemyIVs = new ArrayList<>(Arrays.asList(enemy1IV, enemy2IV, enemy3IV, enemy4IV, enemy5IV, enemy6IV));
        enemyHPBarivs = new ArrayList<>(Arrays.asList(enemy1HPBarIV, enemy2HPBarIV, enemy3HPBarIV, enemy4HPBarIV, enemy5HPBarIV,enemy6HPBarIV));
        enemyHPBarlbls = new ArrayList<>(Arrays.asList(enemy1HPBarLB, enemy2HPBarLB, enemy3HPBarLB, enemy4HPBarLB, enemy5HPBarLB, enemy6HPBarLB));
        refreshImagesAndHPBars();

        actionButtonGridPane.setDisable(true);
        actionButtonGridPane.setVisible(false);
    }

    private void refreshImagesAndHPBars() throws FileNotFoundException {
        Functions.setCombatEnemyImages(livingEnemies, enemyIVs, activeEnemy, activeEnemyIV);
        Functions.setEnemyHPBars(livingEnemies, enemyHPBarivs, enemyHPBarlbls);
        Functions.setEnemyHPBars(new ArrayList<>(Arrays.asList(activeEnemy)),new ArrayList<>(Arrays.asList(activeEnemyHPBarIV)), new ArrayList<>(Arrays.asList(activeEnemyHPBarLB)));
        Functions.setCombatHeroImages(livingHeroes, heroIVs, activeHero, activeHeroIV);
        Functions.setHeroHPBars(livingHeroes, heroHPBarivs, heroHPBarlbls);
        Functions.setHeroHPBars(new ArrayList<>(Arrays.asList(activeHero)),new ArrayList<>(Arrays.asList(activeHeroHPBarIV)), new ArrayList<>(Arrays.asList(activeHeroHPBarLB)));
    }

    public void onActiveHeroClicked() {
        if(!(activeHero == null)){
            actionButtonGridPane.setDisable(false);
            actionButtonGridPane.setVisible(true);
        }
    }

    public void onHeroClicked() throws FileNotFoundException {

        if(!livingHeroSlugs.get(currentHeroIndex).equals("empty")) {
            if(!(activeHeroIndex == -1)) {
                livingHeroes.set(activeHeroIndex, activeHero);
                livingHeroSlugs.set(activeHeroIndex, activeHero.getSlug());
            }
            activeHeroIndex = currentHeroIndex;
            activeHero = livingHeroes.get(currentHeroIndex);
            livingHeroes.set(currentHeroIndex, null);
            livingHeroSlugs.set(currentHeroIndex, "empty");
            actionButtonGridPane.setDisable(false);
            actionButtonGridPane.setVisible(true);

        } else {
            System.out.println("no selectable hero");
            actionButtonGridPane.setDisable(true);
            actionButtonGridPane.setVisible(false);
        }
        refreshImagesAndHPBars();
    }

    public void onActiveEnemyClicked() {
        System.out.println(activeEnemy);
    }
    public void onEnemyClicked() throws FileNotFoundException {

        if ((livingEnemies.get(currentEnemyIndex) == null)) {
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

    public void onMainWeaponButtonClicked() throws FileNotFoundException {
        if(!(activeEnemy == null)) {
            activeEnemy.receiveDamage(25);
            if(activeEnemy.getHealth() <= 0){
                activeEnemy.setDead();
            }
            if(!activeEnemy.isAlive()){
                livingEnemies.set(activeEnemyIndex, activeEnemy);
                Functions.setImage(enemyIVs.get(activeEnemyIndex),"combatImages",activeEnemy.getSlug() + "_dead" );
                activeEnemy = null;
            }
            refreshImagesAndHPBars();
        } else {
            System.out.println("Il n'y a pas d'ennemi actif");
        }
    }

    public void onThrowableWeaponButtonClicked() {
        activeEnemy.receiveDamage(25);

    }


    public void onBackButtonClicked() throws IOException {
        //Get back active hero in heroList
        if(activeHeroIndex != -1) {
            livingHeroes.set(activeHeroIndex, activeHero);
            livingHeroSlugs.set(activeHeroIndex, activeHero.getSlug());
        }
        LoadScene.changeScene("dungeon-entry-hall");
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



}


