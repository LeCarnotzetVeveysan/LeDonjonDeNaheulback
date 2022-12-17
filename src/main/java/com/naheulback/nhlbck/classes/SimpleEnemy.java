package com.naheulback.nhlbck.classes;

public class SimpleEnemy extends Enemy {

    public SimpleEnemy(String inSlug, String[] inArray, Boolean inAlive){
        super(inSlug, inArray[0], Integer.parseInt(inArray[1]), Integer.parseInt(inArray[2]),
                Integer.parseInt(inArray[3]), Integer.parseInt(inArray[4]), Integer.parseInt(inArray[5]),
                Integer.parseInt(inArray[6]), Integer.parseInt(inArray[7]), inAlive);
    }

    

}
