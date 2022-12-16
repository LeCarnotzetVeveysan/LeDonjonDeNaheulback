package com.naheulback.nhlbck.classes;

public class Ranger extends Hero {
    
    public Ranger(String slug, String name, int inHealth, int inMaxHealth, int inAttack, int inResistance, Boolean inIsAlive){
        super(slug, name, inHealth, inMaxHealth, inAttack, inResistance, inIsAlive, "ranger");
    }
}
