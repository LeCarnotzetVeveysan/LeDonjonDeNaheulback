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
    private int armor;
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
        armor = 100;
        attack = 100;
        magic = 100;
        mana = 100;
        speed = 100;
    }

    public String toString(){
        return "name : " + name + ", level : " + level;
    }

    public static Hero buildHeroFromDict(HashMap<String,String> hm) throws FileNotFoundException {

        String slug = hm.get("slug");
        String name = hm.get("name");

        Hero toReturn = new Warrior(slug, name);
        return toReturn;
    }

    public abstract void speak();

    public String getName(){

        return name;

    }

    public int getCost(){

        return recruitementCost;

    }

    private int getHealth(){

        return health;

    }

}
