package com.naheulback.nhlbck.classes;

public class Boss extends Enemy {
    public Boss(String inSlug, String inName, int inHealth, int inMaxHealth, int inAttack, int inMagic, int inResistance, int inExp, int inGold, Boolean inIsAlive) {
        super(inSlug, inName, inHealth, inMaxHealth, inAttack, inResistance, inMagic, inExp, inGold, inIsAlive);
    }

}
