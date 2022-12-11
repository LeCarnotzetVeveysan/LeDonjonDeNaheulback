package com.naheulback.nhlbck.classes;

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
    private HeadItem headItem;
    private BodyItem bodyItem;

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

    public void setMainWeapon(String weaponName, int weaponLevel, int weaponPower){
        Weapon wpn = new Weapon(weaponName, weaponLevel, weaponPower);
        mainWeapon = wpn;
    }

    public Weapon getMainWeapon() {
        return mainWeapon;
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
