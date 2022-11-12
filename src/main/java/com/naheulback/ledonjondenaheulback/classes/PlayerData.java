package com.naheulback.ledonjondenaheulback.classes;

import java.util.ArrayList;

public class PlayerData {

    private String teamName;

    private ArrayList<Hero> livingHeroes;
    private ArrayList<Hero> deadHeroes;
    private int[] currentLocation;
    private static int goldPieces;


    public PlayerData(){

        teamName = "La compagnie des forts de café";
        livingHeroes = new ArrayList<>();
        deadHeroes = new ArrayList<>();

        currentLocation = new int[]{0, 0};
        goldPieces = 0;

    }

    public String getName(){
        return teamName;
    }

    public int getZone(){ return currentLocation[0]; }

    public void setZone(int zone){ currentLocation[0] = zone;}

    public int getRoom(){ return currentLocation[1]; }

    public void setRoom(int room){ currentLocation[1] = room;}

    public static void initGoldPieces(){
        switch (GameData.getLevel()) {
            case 1 -> goldPieces = 2000;
            case 2 -> goldPieces = 1500;
            case 3 -> goldPieces = 1000;
            case 4 -> goldPieces = 500;
        }
    }

    public static void addGoldPieces(int gold){
        goldPieces += gold;
    }

    public static boolean takeGoldPieces(int gold){

        if(goldPieces >= gold){
            goldPieces -= gold;
            return true;
        } else {
            return false;
        }

    }

    public static int getGoldPieces(){
        return goldPieces;
    }

}
