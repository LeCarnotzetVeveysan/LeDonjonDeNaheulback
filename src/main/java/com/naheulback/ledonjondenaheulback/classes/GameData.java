package com.naheulback.ledonjondenaheulback.classes;

public class GameData {

    private static int maxHeroes;
    private static int level;

    public GameData(){

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


}
