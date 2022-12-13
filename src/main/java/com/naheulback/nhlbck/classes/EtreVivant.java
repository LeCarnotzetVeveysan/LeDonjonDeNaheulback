package com.naheulback.nhlbck.classes;

public abstract class EtreVivant {

    private String slug;
    private String name;
    private int health;
    private int maxHealth;
    private boolean isAlive;

    protected EtreVivant(String inputSlug, String inputName, int inputHealth, int inputMaxHealth, Boolean inputIsAlive) {
        slug = inputSlug;
        name = inputName;
        health = inputHealth;
        maxHealth = inputMaxHealth;
        isAlive = inputIsAlive;
    }

    public String getSlug() { return slug; }

    public String getName() { return slug; }

    public int getHealth() { return health; }

    public int getMaxHealth(){ return maxHealth; }

    public boolean getIsAlive(){
        return isAlive;
    }
    public void setIsAlive(boolean toSet){
        isAlive = toSet;
    }

    public void addHealth(int inputHealth){
        health += inputHealth;
        if (health > maxHealth){
            health = maxHealth;
        }
    }
    public void removeHealth(int damage){
        health -= damage;
    }
}
