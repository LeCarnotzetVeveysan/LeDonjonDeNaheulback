package com.naheulback.nhlbck.classes;

public class BodyItem extends Item {
    private final int armor;
    private final int quality;
    public BodyItem(String inSlug, String inName, int inLevel, int inQuality, int inArmor){
        super(inSlug, inName, inLevel);
        armor = inArmor;
        quality = inQuality;
    }

    public double getQuality(){ return quality; }

    public int getArmor(){ return armor; }

}
