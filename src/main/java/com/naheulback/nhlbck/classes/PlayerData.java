package com.naheulback.nhlbck.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerData {

    private String teamName;

    private static ArrayList<Hero> livingHeroes;
    private static ArrayList<Hero> deadHeroes;
    private int[] currentLocation;
    private static double goldPieces;


    public PlayerData(){

        teamName = "La compagnie des forts de café";
        livingHeroes = new ArrayList<>();
        deadHeroes = new ArrayList<>();

        currentLocation = new int[]{0, 0, 0, 0};
        goldPieces = 0.0;

    }

    public String getName(){
        return teamName;
    }

    public static ArrayList<Hero> getLivingHeroes(){ return livingHeroes; }

    public static void setLivingHeroes(ArrayList<Hero> al){ livingHeroes = al; }

    public static ArrayList<Hero> getDeadHeroes(){ return deadHeroes; }

    public static void setDeadHeroes(ArrayList<Hero> al){ deadHeroes = al; }

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
            case 1 -> goldPieces = 2000.0;
            case 2 -> goldPieces = 1500.0;
            case 3 -> goldPieces = 1000.0;
            case 4 -> goldPieces = 500.0;
        }
    }

    public static void addGoldPieces(double gold){
        goldPieces += gold;
    }

    public static boolean hasEnoughGoldPieces(double gold){

        if(goldPieces >= gold){
            return true;
        } else {
            return false;
        }

    }

    public static void takeGoldPieces(double gold){ goldPieces -= gold; }

    public static double getGoldPieces(){
        return goldPieces;
    }

    public static ArrayList<String> getLivingHeroSlugs(){

        ArrayList<String> lhs = new ArrayList<>(Arrays.asList("empty","empty","empty","empty","empty","empty"));
        for(int i = 0; i < livingHeroes.size(); i++){
            lhs.set(i,livingHeroes.get(i).getSlug());
        }
        return lhs;
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
