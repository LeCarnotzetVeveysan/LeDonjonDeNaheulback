package com.naheulback.ledonjondenaheulback.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Dictionary;
import java.util.HashMap;

public abstract class Hero {

    private String slug;
    private String name;
    private String type;
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
    private Weapon mainWeapon;

    public Hero(String inputSlug, String inputName, String inputType){

        slug = inputSlug;
        type = inputType;
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
        mainWeapon = null;
    }

    public String toString(){
        return "name : " + name + ", level : " + level;
    }


    public abstract void speak();

    public String getName(){ return name; }

    public int getCost(){ return recruitementCost; }

    public int getHealth(){ return health; }

    public int getMaxHealth(){ return maxHealth; }

    public int getArmor(){ return armor; }

    public int getMaxArmor(){ return maxArmor; }

    public String getSlug() { return slug; }

    public void addHP(int inputHealth) {
        health += inputHealth;
        if(health > maxHealth){
            health = maxHealth;
        }
    }

    public String getType() {
        return type;
    }

    public void setMainWeapon(String weaponName, int weaponLevel){
        Weapon wpn = new Weapon(weaponName, weaponLevel);
        mainWeapon = wpn;
    }


    public Weapon getWeapon() {
        return mainWeapon;
    }
}
