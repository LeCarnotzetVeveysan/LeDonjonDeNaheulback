package com.naheulback.nhlbck.classes;

public class GameData {

    private static String pictureType;
    private static int volume;
    private static int maxHeroes;
    private static int level;

    public GameData(){

        pictureType = "Alpha";
        volume = 5;
        level = 0;
        maxHeroes = 0;

    }

    public static void setMaxHeroes(){
        switch (level) {
            case 1 -> maxHeroes = 6;
            case 2 -> maxHeroes = 4;
            case 3 -> maxHeroes = 3;
            case 4 -> maxHeroes = 1;
        }
    }

    public static int getMaxHeroes(){
        return maxHeroes;
    }

    public void setLevel(int inputLevel){
        level = inputLevel;
    }

    public static int getLevel(){
        return level;
    }

    public static String getPictureType(){ return pictureType; }
    public static void setPictureType(String input){ pictureType = input; }

    public static int getVolume(){ return volume; }
    public static void setVolume(int input){ volume = input; }


}
