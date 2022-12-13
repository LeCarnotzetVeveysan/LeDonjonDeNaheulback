package com.naheulback.nhlbck.classes;

public class Enemy {

    private String slug;
    public boolean alive;
    private String name;
    private int health;
    private int maxHealth;
    private int armor;
    private int resistance;

    public Enemy(String inputSlug, String inputName){
        slug = inputSlug;
        alive = true;
        name = inputName;
        health = 50;
        maxHealth = 100;
        armor = 20;
        resistance = 20;
    }

    public String getSlug() {
        return slug;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setDead(){
        alive = false;
    }
    public void receiveDamage(int damage){
        health -= damage;
    }
}
