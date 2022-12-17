package com.naheulback.nhlbck;

import com.naheulback.nhlbck.classes.GameData;
import com.naheulback.nhlbck.classes.Hero;
import com.naheulback.nhlbck.classes.PlayerData;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private final Stage mainStage;
    private static GameData gameData;
    private static PlayerData playerData;

    public Game(Stage inputStage){

        mainStage = inputStage;
        gameData = new GameData();
        playerData = new PlayerData();

    }

    public void main() throws IOException {

        LoadScene ls = new LoadScene(mainStage);
        LoadScene.changeScene("menu-main-menu");

    }

    public static ArrayList<Hero> getLivingHeroes(){ return PlayerData.getLivingHeroes(); }

    public static void setLivingHeroes(ArrayList<Hero> al){ PlayerData.setLivingHeroes(al);}

    public static int getNumberOfLivingHeroes(){ return PlayerData.getNumberOfLivingHeroes(); }

    public static void setLevel(int inputLevel){
        gameData.setLevel(inputLevel);
    }

    public static int getLevel(){
        return GameData.getLevel();
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

    public static void addGoldPieces(double amount){ PlayerData.addGoldPieces(amount); }

    public static void takeGoldPieces(double amount){ PlayerData.takeGoldPieces(amount); }

    public static boolean hasEnoughGoldPieces(double amount){ return PlayerData.hasEnoughGoldPieces(amount);}

    public static double getGoldPieces(){ return PlayerData.getGoldPieces(); }

    public static void recruitHero(Hero hero){ PlayerData.recruitHero(hero);}

    public static void sitHero(int index){ PlayerData.sitHero(index); }

    public static ArrayList<String> getLivingHeroSlugs(){ return PlayerData.getLivingHeroSlugs();}
}
