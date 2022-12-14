package com.naheulback.nhlbck.classes;

public class HeadItem extends Item {

    private int armor;
    private int quality;

    public HeadItem(String inputSlug, String inputName, int inputLevel, int inputQuality, int inputArmor){
        super(inputSlug, inputName, inputLevel);
        armor = inputArmor;
        quality = inputQuality;
    }

    public int getArmor(){ return armor; }

    public double getQuality(){ return quality; }
}
