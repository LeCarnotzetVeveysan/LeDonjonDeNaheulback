package com.naheulback.ledonjondenaheulback.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerData {

    private String teamName;

    private static ArrayList<Hero> livingHeroes;
    private static ArrayList<Hero> deadHeroes;
    private int[] currentLocation;
    private static int goldPieces;


    public PlayerData(){

        teamName = "La compagnie des forts de café";
        livingHeroes = new ArrayList<>();
        deadHeroes = new ArrayList<>();

        currentLocation = new int[]{0, 0, 0, 0};
        goldPieces = 0;

    }

    public String getName(){
        return teamName;
    }

    public static int getNumberOfLivingHeroes(){ return livingHeroes.size(); }

    public int getDungeon(){ return currentLocation[0]; }

    public void setDungeon(int dungeon){ currentLocation[0] = dungeon;}

    public int getRoom(){ return currentLocation[1]; }

    public void setRoom(int room){ currentLocation[1] = room;}

    public int getTable(){ return currentLocation[2]; }

    public void setTable(int table){ currentLocation[2] = table;}

    public int getSpeakingHero(){ return currentLocation[3]; }

    public void setSpeakingHero(int hero){ currentLocation[3] = hero;}

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

    public static boolean hasEnoughGoldPieces(int gold){

        if(goldPieces >= gold){
            return true;
        } else {
            return false;
        }

    }

    public static void takeGoldPieces(int gold){ goldPieces -= gold; }

    public static int getGoldPieces(){
        return goldPieces;
    }

    public static String getLivingHeroes(){
        return livingHeroes.toString();
    }

    public static ArrayList<String> getLivingHeroSlugs(){

        ArrayList<String> lhs = new ArrayList<>(Arrays.asList("empty","empty","empty","empty","empty","empty"));
        for(int i = 0; i < livingHeroes.size(); i++){
            lhs.set(i,livingHeroes.get(i).getSlug());
        }
        return lhs;
    }

    public static String getDeadHeroes(){
        return deadHeroes.toString();
    }
    public static void recruitHero(Hero hero){
        livingHeroes.add(hero);
    }

    public static void sitHero(int index){ livingHeroes.remove(index); }

    public static void heroDies(Hero hero){
        //int index = livingHeroes.indexOf(hero);
        deadHeroes.add(hero);
        livingHeroes.remove(hero);
    }

    public static void reviveHero(Hero hero){
        deadHeroes.remove(hero);
        livingHeroes.add(hero);
    }




}
