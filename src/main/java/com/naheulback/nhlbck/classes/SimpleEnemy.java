package com.naheulback.nhlbck.classes;

public class SimpleEnemy extends Enemy {



    public SimpleEnemy(String inSlug, String[] inArray, Boolean inAlive){
        super(inSlug, inArray[0],
                (int) GameData.getStrengthMult()*Integer.parseInt(inArray[2]),
                (int) GameData.getStrengthMult()*Integer.parseInt(inArray[3]),
                (int) GameData.getStrengthMult()*Integer.parseInt(inArray[4]),
                (int) GameData.getStrengthMult()*Integer.parseInt(inArray[5]),
                (int) GameData.getStrengthMult()*Integer.parseInt(inArray[6]),
                (int) GameData.getRewardMult()*Integer.parseInt(inArray[7]),
                (int) GameData.getRewardMult()*Integer.parseInt(inArray[8]),
                inAlive);
    }

    

}
