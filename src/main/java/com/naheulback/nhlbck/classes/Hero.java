package com.naheulback.nhlbck.classes;

import com.naheulback.nhlbck.Game;

import java.util.ArrayList;

public abstract class Hero extends LivingThing {
    private final String type;
    private final int level;
    private int experience;
    private final int magic;
    private int mana;
    private final int maxMana;
    private Weapon mainWeapon;
    private Weapon throwableWeapon;
    private boolean weaponThrowed;

    private HeadItem headItem;
    private BodyItem bodyItem;
    private final ArrayList<Item> inventory;

    public Hero(String inputSlug, String inputName, int inputHealth, int inputMaxHealth, int inAttack, int inMagic, int inResistance, Boolean inputIsAlive, String inputType){

        super(inputSlug, inputName, inputHealth, inputMaxHealth,inAttack, inMagic, inResistance, inputIsAlive);

        type = inputType;
        level = 1;
        experience = 0;
        magic = 100;
        mana = 100;
        maxMana = 200;
        mainWeapon = null;
        throwableWeapon = null;
        weaponThrowed= false;
        inventory = new ArrayList<>();
    }

    public String toString(){
        return "name : " + super.getName() + ", level : " + level;
    }
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

    public double getFlatAttack(Weapon weapon){
        double attack = getBaseAttack();
        attack *= (1 + (level/10.0));
        if(!(weapon == null)){
            attack += weapon.getPower();
        }
        return attack;
    }

    public double getFlatMagic(Weapon weapon, Spell spell){
        double magic = getBaseMagic();
        magic *= (1 + (level/10.0));
        magic += spell.getMagicDamage();
        if(!(weapon == null)){
            magic += weapon.getPower();
        }
        return magic;
    }

    public double getFlatResistance(){
        double resistance = getBaseResistance();
        resistance *= (1 + (level/10.0));

        if(!(headItem == null)){
            resistance += headItem.getArmor();
        }
        if(!(bodyItem == null)){
            resistance += bodyItem.getArmor();
        }
        return resistance;
    }

    public double getResistanceMultiplier(){
        double baseFactor = 1.00;
        baseFactor -= getFlatResistance()/100.0;
        double levelDivider = Math.pow(1.25, Game.getLevel());
        return baseFactor/levelDivider;
    }

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

    public ArrayList<String> getInventorySlugs() {
        ArrayList<String> toReturn = new ArrayList<>();
        for(Item e : getInventory()){
            toReturn.add(e.getSlug());
        }
        return toReturn;
    }
    public void addItem(Item i){
        inventory.add(i);
    }

    public int getExperience(){ return experience; }

    public void addExperience(int amount){ experience += amount; }



}
