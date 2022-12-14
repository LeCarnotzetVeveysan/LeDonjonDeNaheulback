package com.naheulback.nhlbck.classes;

import java.util.ArrayList;

public abstract class Hero extends EtreVivant {
    private String type;
    private int level;
    private int experience;
    private int recruitementCost;
    private int armor;
    private int maxArmor;
    private int attack;
    private int magic;
    private int mana;
    private int speed;
    private Weapon mainWeapon;
    private Weapon throwableWeapon;
    private boolean weaponThrowed;
    private HeadItem headItem;
    private BodyItem bodyItem;
    private ArrayList<Item> inventory;

    public Hero(String inputSlug, String inputName, int inputHealth, int inputMaxHealth, Boolean inputIsAlive, String inputType){

        super(inputSlug, inputName, inputHealth, inputMaxHealth, inputIsAlive);

        type = inputType;
        level = 1;
        experience = 0;
        recruitementCost = 100;
        armor = 100;
        attack = 100;
        magic = 100;
        mana = 100;
        speed = 100;
        mainWeapon = null;
        throwableWeapon = null;
        weaponThrowed= false;
        inventory = new ArrayList<>();
    }

    public String toString(){
        return "name : " + super.getName() + ", level : " + level;
    }

    public int getCost(){ return recruitementCost; }

    public int getArmor(){ return armor; }

    public int getMaxArmor(){ return maxArmor; }

    public int getLevel() { return level; }

    public String getType() {
        return type;
    }

    public void setMainWeapon(String weaponSlug, String weaponName, int weaponLevel, int weaponQuality, int weaponPower){
        Weapon wpn = new Weapon(weaponSlug, weaponName, weaponLevel, weaponQuality, weaponPower);
        mainWeapon = wpn;
    }

    public Weapon getMainWeapon() {
        return mainWeapon;
    }

    public void setThrowableWeapon(String weaponSlug, String weaponName, int weaponLevel, int weaponQuality, int weaponPower){
        Weapon wpn = new Weapon(weaponSlug, weaponName, weaponLevel, weaponQuality, weaponPower);
        throwableWeapon = wpn;
    }

    public Weapon getThrowableWeapon() {
        return throwableWeapon;
    }

    public boolean getWeaponThrowed() { return weaponThrowed; }

    public void setWeaponThrowed(boolean input) { weaponThrowed = input; }

    public void setHeadItem(String itemSlug, String itemName, int itemLevel, int inputQuality, int inputArmor){
        HeadItem hi = new HeadItem(itemSlug, itemName, itemLevel, inputQuality, inputArmor );
        headItem = hi;
    }

    public HeadItem getHeadItem() {
        return headItem;
    }

    public void setBodyItem(String itemSlug, String itemName, int itemLevel, int inputQuality, int inputArmor){
        BodyItem bi = new BodyItem(itemSlug, itemName, itemLevel, inputQuality, inputArmor );
        bodyItem = bi;
    }

    public BodyItem getBodyItem() {
        return bodyItem;
    }

    public void prendreGrimoire(String slug, String name, int level){
        Grimoire grim = new Grimoire(slug, name, level);
        inventory.add(grim);
    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
