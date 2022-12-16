package com.naheulback.nhlbck.classes;

public abstract class EtreVivant {

    private String slug;
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int resistance;
    private boolean isAlive;
    

    protected EtreVivant(String inSlug, String inName, int inHealth, int inMaxHealth, int inAttack, int inResistance, Boolean inIsAlive) {
        slug = inSlug;
        name = inName;
        health = inHealth;
        maxHealth = inMaxHealth;
        attack = inAttack;
        resistance = inResistance;
        isAlive = inIsAlive;
    }

    public String getSlug() { return slug; }

    public String getName() { return name; }

    public int getHealth() { return health; }

    public int getMaxHealth(){ return maxHealth; }

    public int getBaseAttack() { return attack; }
    
    public int getBaseResistance() { return resistance; }

    public boolean getIsAlive(){
        return isAlive;
    }
    public void setIsAlive(boolean toSet){
        isAlive = toSet;
    }

    public void addHealth(int amount){
        health += amount;
        if (health > maxHealth){
            health = maxHealth;
        }
    }
    public void removeHealth(int amount){
        health -= amount;
    }
}
