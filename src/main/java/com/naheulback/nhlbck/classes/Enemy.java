package com.naheulback.nhlbck.classes;

public class Enemy {

    private String slug;
    private String name;
    private int health;
    private int maxHealth;
    private int armor;
    private int resistance;

    public Enemy(String inputSlug, String inputName){
        slug = inputSlug;
        name = inputName;
        health = 50;
        maxHealth = 100;
        armor = 20;
        resistance = 20;
    }


}
