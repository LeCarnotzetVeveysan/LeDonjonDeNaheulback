package com.naheulback.nhlbck.classes;

import com.naheulback.nhlbck.Game;

import java.util.ArrayList;

public abstract class Hero extends LivingThing {
    private final String type;
    private int level;
    private int experience;
    private int mana;
    private final int maxMana;
    private Weapon mainWeapon;
    private Weapon throwableWeapon;
    private boolean weaponThrowed;

    private HeadItem headItem;
    private BodyItem bodyItem;
    private final ArrayList<Item> inventory;

    public Hero(String inSlug, String inName, int inHealth, int inMaxHealth, int inAttack, int inMagic, int inResistance, Boolean inIsAlive, String inType){

        super(inSlug, inName, inHealth, inMaxHealth,inAttack, inMagic, inResistance, inIsAlive);

        type = inType;
        level = 1;
        experience = 0;
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

    public void setLevel(){
        int[] xp = {200,907,1612,2341,3107,3923,4796,5734,6747,7840,9024,10306,11696,13202,14836,16608,18530,20615,22877,2500};
        int levelToSet = 1;
        for(int k : xp){
            if(experience > k){
                level += 1;
            }
        }
        level = levelToSet;
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

    public double getFlatMagic(Hero hero, Spell spell){
        double magic = getBaseMagic();
        magic *= (1 + (level/10.0));
        magic += spell.getMagicDamage();
        if(!(hero.getMainWeapon() == null)){
            magic += hero.getMainWeapon().getPower();
        }
        if(!(hero.getHeadItem() == null)){
            magic += hero.getHeadItem().getArmor();
        }
        if(!(hero.getMainWeapon() == null)){
            magic += hero.getBodyItem().getArmor();
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
        mainWeapon = new Weapon(weaponSlug, weaponName, weaponLevel, weaponQuality, weaponPower);
    }

    public Weapon getMainWeapon() {
        return mainWeapon;
    }

    public void setThrowableWeapon(String weaponSlug, String weaponName, int weaponLevel, int weaponQuality, int weaponPower){
        throwableWeapon = new Weapon(weaponSlug, weaponName, weaponLevel, weaponQuality, weaponPower);
    }

    public Weapon getThrowableWeapon() {
        return throwableWeapon;
    }

    public boolean getWeaponThrowed() { return weaponThrowed; }

    public void setWeaponThrowed(boolean in) { weaponThrowed = in; }

    public void setHeadItem(String itemSlug, String itemName, int itemLevel, int inQuality, int inArmor){
        headItem = new HeadItem(itemSlug, itemName, itemLevel, inQuality, inArmor );
    }

    public HeadItem getHeadItem() {
        return headItem;
    }

    public void setBodyItem(String itemSlug, String itemName, int itemLevel, int inQuality, int inArmor){
        bodyItem = new BodyItem(itemSlug, itemName, itemLevel, inQuality, inArmor );
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

    public void addExperience(int amount){ experience += amount; }



}
