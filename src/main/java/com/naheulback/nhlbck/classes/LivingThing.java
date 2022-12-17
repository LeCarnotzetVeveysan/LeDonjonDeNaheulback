package com.naheulback.nhlbck.classes;

public abstract class LivingThing {

    private final String slug;
    private final String name;
    private int health;
    private final int maxHealth;
    private final int attack;
    private final int magic;
    private final int resistance;
    private boolean isAlive;
    

    protected LivingThing(String inSlug, String inName, int inHealth, int inMaxHealth, int inAttack, int inMagic, int inResistance, Boolean inIsAlive) {
        slug = inSlug;
        name = inName;
        health = inHealth;
        maxHealth = inMaxHealth;
        attack = inAttack;
        magic = inMagic;
        resistance = inResistance;
        isAlive = inIsAlive;
    }

    public String getSlug() { return slug; }

    public String getName() { return name; }

    public int getHealth() { return health; }

    public int getMaxHealth(){ return maxHealth; }

    public int getBaseAttack() { return attack; }

    public int getBaseMagic() { return magic; }
    
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
