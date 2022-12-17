package com.naheulback.nhlbck.classes;

public class Boss extends Enemy {
    public Boss(String inSlug, String[] inArray, Boolean inAlive){
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


