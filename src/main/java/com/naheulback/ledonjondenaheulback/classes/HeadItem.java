package com.naheulback.ledonjondenaheulback.classes;

public class HeadItem {

    private String slug;
    private String name;
    private int level;
    private int quality;

    public HeadItem(String inputSlug, int inputLevel, int inputQuality){
        slug = inputSlug;
        level = inputLevel;
        //get true name from slug in dictionary
        name = inputSlug;
        quality = inputQuality;

    }

    public String getName(){
        return name + " (Niveau " + level + ")";
    }

    public String getStats(){
        return name + " (Niveau " + level + "), Qualité: " + quality;
    }
}
