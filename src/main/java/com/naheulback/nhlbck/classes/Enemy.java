package com.naheulback.nhlbck.classes;

public abstract class Enemy extends EtreVivant {

    private int armor;
    private int resistance;

    public Enemy(String inputSlug, String inputName, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){
        super(inputSlug, inputName, inputHealth, inputMaxHealth, inputIsAlive);
        armor = 20;
        resistance = 20;
    }
}
