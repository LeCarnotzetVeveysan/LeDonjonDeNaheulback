package com.naheulback.nhlbck.classes;

public class BodyItem extends Item {
    private int armor;
    private int quality;

    public BodyItem(String inputSlug, String inputName, int inputLevel, int inputQuality, int inputArmor){
        super(inputSlug, inputName, inputLevel);
        armor = inputArmor;
        quality = inputQuality;
    }

    public double getQuality(){ return quality; }

    public int getArmor(){ return armor; }

}
