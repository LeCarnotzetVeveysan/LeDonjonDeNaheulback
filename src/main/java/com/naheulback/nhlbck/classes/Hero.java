package com.naheulback.nhlbck.classes;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Hero extends EtreVivant {
    private String type;
    private int level;
    private int experience;
    private int recruitementCost;
    private int armor;
    private int attack;
    private int magic;
    private int mana;
    private int maxMana;
    private Weapon mainWeapon;
    private Weapon throwableWeapon;
    private boolean weaponThrowed;
    private Spell mainSpell;
    private Spell secondarySpell;
    private String activeCarquois;
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
        attack = 1;
        magic = 100;
        mana = 100;
        maxMana = 200;
        mainWeapon = null;
        throwableWeapon = null;
        weaponThrowed= false;
        activeCarquois = "";
        mainSpell = null;
        secondarySpell = null;
        inventory = new ArrayList<>();
    }

    public String toString(){
        return "name : " + super.getName() + ", level : " + level;
    }

    public int getCost(){ return recruitementCost; }

    public int getMana() { return mana; }

    public int getMaxMana(){ return maxMana; }

    public void addMana(int amount){
        mana += amount;
        if (mana > maxMana){
            mana = maxMana;
        }
    }
    public void removeMana(int amount){
        mana -= amount;
    }

    public int getArmor(){ return armor; }

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


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item i){
        inventory.add(i);
    }

    public Spell getFirstSpell(){
        return mainSpell;
    }

    public void setMainSpell(Spell inputSpell){
        mainSpell = inputSpell;
    }

    public void setSecondarySpell(Spell inputSpell){
        secondarySpell = inputSpell;
    }

    public Spell getSecondarySpell(){
        return secondarySpell;
    }

    public void setActiveCarquois(String carquois){ activeCarquois = carquois; }

    public String getActiveCarquois(){ return activeCarquois; }

}
