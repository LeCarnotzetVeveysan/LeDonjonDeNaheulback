package com.naheulback.nhlbck.classes;

public abstract class Enemy extends EtreVivant {
    
    public Enemy(String inSlug, String inName, int inHealth, int inMaxHealth, int inAttack, int inResistance, Boolean inIsAlive){
        super(inSlug, inName, inHealth, inMaxHealth,inAttack,inResistance, inIsAlive);
    }

    public double getResistanceMultiplier(){
        double factor = 1.00 - getBaseResistance()/100.0;
        return factor;
    }

}
