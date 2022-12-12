package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.classes.Enemy;
import com.naheulback.nhlbck.classes.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleFloorController {

    private int currentHeroIndex;
    private int activeHeroIndex;
    private Hero activeHero;
    private int currentEnemyIndex;
    private Enemy currentEnemy;
    private ArrayList<String> livingHeroSlugs;
    private ArrayList<Hero> livingHeroes;
    private ArrayList<ImageView> heroIVs;
    private ArrayList<Enemy> livingEnemies;

    @FXML
    private ImageView activeHeroIV, hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV;
    @FXML
    private ImageView activeHeroHPBarIV, hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV;
    @FXML
    private Label activeHeroHPBarLB, hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB;
    private ArrayList<ImageView> hpbarivs;
    private ArrayList<Label> hpbarlbls;

    public void initialize() throws FileNotFoundException {

        activeHero = null;
        activeHeroIndex = -1;
        livingHeroSlugs = Game.getLivingHeroSlugs();
        livingHeroes = Game.getLivingHeroes();
        livingEnemies = Game.getLivingEnemies();
        heroIVs = new ArrayList<>(Arrays.asList(hero1IV, hero2IV, hero3IV, hero4IV, hero5IV, hero6IV));
        hpbarivs = new ArrayList<>(Arrays.asList(hero1HPBarIV, hero2HPBarIV, hero3HPBarIV, hero4HPBarIV, hero5HPBarIV,hero6HPBarIV));
        hpbarlbls = new ArrayList<>(Arrays.asList(hero1HPBarLB, hero2HPBarLB, hero3HPBarLB, hero4HPBarLB, hero5HPBarLB, hero6HPBarLB));

        Functions.setCombatHeroImages(livingHeroes, heroIVs, activeHero, activeHeroIV);

        Functions.setHeroHPBars(livingHeroes, hpbarivs, hpbarlbls);
        Functions.setHeroHPBars(new ArrayList<>(Arrays.asList(activeHero)),new ArrayList<>(Arrays.asList(activeHeroHPBarIV)), new ArrayList<>(Arrays.asList(activeHeroHPBarLB)));

    }

    public void onActiveHeroClicked() {
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

        } else {
            System.out.println("no selectable hero");
        }
        Functions.setCombatHeroImages(livingHeroes, heroIVs, activeHero, activeHeroIV );
        Functions.setHeroHPBars(livingHeroes, hpbarivs, hpbarlbls);
        Functions.setHeroHPBars(new ArrayList<>(Arrays.asList(activeHero)),new ArrayList<>(Arrays.asList(activeHeroHPBarIV)), new ArrayList<>(Arrays.asList(activeHeroHPBarLB)));
    }
    public void onEnemyClicked() {
        currentEnemy = livingEnemies.get(currentEnemyIndex);
        livingEnemies.set(currentEnemyIndex, null);
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

    public void onMainWeaponButtonClicked() {
        System.out.println(activeHero.getMainWeapon().getSlug());
    }
    public void onThrowableWeaponButtonClicked() {
        System.out.println(activeHero.getThrowableWeapon().getSlug());
    }


}


