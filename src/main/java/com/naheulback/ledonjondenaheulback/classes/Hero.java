package com.naheulback.ledonjondenaheulback.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Dictionary;
import java.util.HashMap;

public abstract class Hero {

    private String slug;
    private String name;
    private int level;
    private int experience;
    private int recruitementCost;
    private int health;
    private int maxHealth;
    private int armor;
    private int maxArmor;
    private int attack;
    private int magic;
    private int mana;
    private int speed;
    private String testSpeak;

    public Hero(String inputSlug, String inputName){

        slug = inputSlug;
        name = inputName;
        level = 1;
        experience = 0;
        recruitementCost = 100;
        health = 100;
        maxHealth = 100;
        armor = 100;
        attack = 100;
        magic = 100;
        mana = 100;
        speed = 100;
    }

    public String toString(){
        return "name : " + name + ", level : " + level;
    }


    public abstract void speak();

    public String getName(){ return name; }

    public int getCost(){ return recruitementCost; }

    private int getHealth(){ return health; }

    private int getMaxHealth(){ return maxHealth; }

    private int getArmor(){ return armor; }

    private int getMaxArmor(){ return maxArmor; }

    public String getSlug() { return slug; }
}
