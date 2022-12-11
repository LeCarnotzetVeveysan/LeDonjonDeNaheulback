package com.naheulback.ledonjondenaheulback.classes;

public class BodyItem {
    private String slug;
    private String name;
    private int level;
    private double quality;

    public BodyItem(String inputSlug, int inputLevel){
        slug = inputSlug;
        level = inputLevel;
        //get true name from slug in dictionary
        name = inputSlug;
        quality = 1;
    }

    public String getName(){
        return name + " (Niveau " + level + ")";
    }

    public String getStats(){
        return name + " (Niveau " + level + "), Qualité: " + quality;
    }
}
