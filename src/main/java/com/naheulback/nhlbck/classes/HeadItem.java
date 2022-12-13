package com.naheulback.nhlbck.classes;

public class HeadItem {

    private String slug;
    private String name;
    private int level;
    private int armor;
    private int quality;

    public HeadItem(String inputSlug, int inputLevel, int inputArmor){
        slug = inputSlug;
        level = inputLevel;
        //get true name from slug in dictionary
        name = inputSlug;
        armor = inputArmor;
        quality = 100;
    }

    public String getName(){
        return name + " (Niveau " + level + ")";
    }

    public String getSlug(){
        return slug;
    }

    public int getArmor(){ return armor; }

    public int getLevel() { return level;}

    public double getQuality(){ return quality; }

    public String getStats(){
        return name + " (Niveau " + level + "), Qualité: " + quality;
    }
}