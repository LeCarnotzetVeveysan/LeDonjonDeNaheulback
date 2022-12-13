package com.naheulback.nhlbck.classes;

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

    public void setMainWeapon(String weaponName, int weaponLevel, int weaponPower){
        Weapon wpn = new Weapon(weaponName, weaponLevel, weaponPower);
        mainWeapon = wpn;
    }

    public Weapon getMainWeapon() {
        return mainWeapon;
    }

    public void setThrowableWeapon(String weaponName, int weaponLevel, int weaponPower){
        Weapon wpn = new Weapon(weaponName, weaponLevel, weaponPower);
        throwableWeapon = wpn;
    }

    public Weapon getThrowableWeapon() {
        return throwableWeapon;
    }

    public void setHeadItem(String itemName, int itemLevel, int inputQuality){
        HeadItem hi = new HeadItem(itemName, itemLevel, inputQuality);
        headItem = hi;
    }

    public HeadItem getHeadItem() {
        return headItem;
    }

    public void setBodyItem(String itemName, int itemLevel, int inputQuality){
        BodyItem bi = new BodyItem(itemName, itemLevel, inputQuality);
        bodyItem = bi;
    }

    public BodyItem getBodyItem() {
        return bodyItem;
    }



}
