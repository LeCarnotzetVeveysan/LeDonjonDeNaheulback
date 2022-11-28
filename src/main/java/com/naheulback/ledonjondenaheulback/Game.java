package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.classes.GameData;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.naheulback.ledonjondenaheulback.Functions.initTableFiles;

public class Game {

    private Stage mainStage;
    private static GameData gameData;
    private static PlayerData playerData;

    public Game(Stage inputStage){

        mainStage = inputStage;
        gameData = new GameData();
        playerData = new PlayerData();

    }

    public void main() throws IOException {

        initTableFiles();
        LoadScene ls = new LoadScene(mainStage);
        ls.changeScene("menu-main-menu");

    }

    public static ArrayList<Hero> getLivingHeroes(){ return PlayerData.getLivingHeroes(); }

    public static void setLivingHeroes(ArrayList<Hero> al){ PlayerData.setLivingHeroes(al);}

    public static int getNumberOfLivingHeroes(){ return PlayerData.getNumberOfLivingHeroes(); }

    public static void setLevel(int inputLevel){
        gameData.setLevel(inputLevel);
    }

    public static int getLevel(){
        return gameData.getLevel();
    }

    public static int getMaxHeroes(){ return GameData.getMaxHeroes(); }

    public static int getDungeon(){ return playerData.getDungeon(); }

    public static void setDungeon(int dungeon){ playerData.setDungeon(dungeon);}

    public static int getRoom(){ return playerData.getRoom(); }

    public static void setRoom(int room){ playerData.setRoom(room);}

    public static int getTable(){ return playerData.getTable(); }

    public static void setTable(int table){ playerData.setTable(table);}

    public static int getSpeakingHero(){ return playerData.getSpeakingHero(); }

    public static void setSpeakingHero(int hero){ playerData.setSpeakingHero(hero);}

    public static void addGoldPieces(int amount){ playerData.addGoldPieces(amount); }

    public static void takeGoldPieces(int amount){ playerData.takeGoldPieces(amount); }

    public static boolean hasEnoughGoldPieces(int amount){ return playerData.hasEnoughGoldPieces(amount);}

    public static int getGoldPieces(){ return PlayerData.getGoldPieces(); }

    public static void recruitHero(Hero hero){ playerData.recruitHero(hero);}

    public static void sitHero(int index){ playerData.sitHero(index); }

    public static ArrayList<String> getLivingHeroSlugs(){ return PlayerData.getLivingHeroSlugs();}


}
