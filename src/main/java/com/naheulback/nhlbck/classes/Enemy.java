package com.naheulback.nhlbck.classes;

public abstract class Enemy extends LivingThing {

    private final int expGain;
    private final int goldGain;

    public Enemy(String inSlug, String inName, int inHealth, int inMaxHealth, int inAttack, int inMagic, int inResistance, int inExp, int inGold, Boolean inIsAlive){
        super(inSlug, inName, inHealth, inMaxHealth, inAttack, inMagic, inResistance, inIsAlive);
        expGain = inExp;
        goldGain = inGold;
    }

    public double getResistanceMultiplier(){
        double factor = 1.00 - getBaseResistance()/100.0;
        return factor;
    }

    public int getExpGain(){ return expGain; }

    public int getGoldGain() { return goldGain; }

}
