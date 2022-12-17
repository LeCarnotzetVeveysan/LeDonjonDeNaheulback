package com.naheulback.nhlbck.classes;

public class HeadItem extends Item {

    private final int armor;
    private final int quality;

    public HeadItem(String inSlug, String inName, int inLevel, int inQuality, int inArmor){
        super(inSlug, inName, inLevel);
        armor = inArmor;
        quality = inQuality;
    }

    public int getArmor(){ return armor; }

    public double getQuality(){ return quality; }
}
