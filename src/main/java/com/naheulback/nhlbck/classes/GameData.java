package com.naheulback.nhlbck.classes;

public class GameData {

    private static int maxHeroes;
    private static int level;

    private static double strengthMult;
    private static double rewardMult;

    public GameData(){

        level = 0;
        maxHeroes = 0;
        strengthMult = 1;
        setStrengthMult();
        rewardMult = 1;
        setRewardMult();

    }

    public static void setMaxHeroes(){
        switch (level) {
            case 1 -> maxHeroes = 6;
            case 2 -> maxHeroes = 4;
            case 3 -> maxHeroes = 3;
            case 4 -> maxHeroes = 1;
        }
    }

    public static void setStrengthMult(){
        switch (GameData.getLevel()) {
            case 1 -> strengthMult = 1.0;
            case 2 -> strengthMult = 1.5;
            case 3 -> strengthMult = 2.0;
            case 4 -> strengthMult = 3.0;
        }
    }

    public static void setRewardMult(){
        switch (GameData.getLevel()) {
            case 1 -> rewardMult = 1.0;
            case 2 -> rewardMult = 1.25;
            case 3, 4 -> rewardMult = 1.5;
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

    public static double getStrengthMult(){ return strengthMult; }
    public static double getRewardMult(){ return rewardMult; }

}
