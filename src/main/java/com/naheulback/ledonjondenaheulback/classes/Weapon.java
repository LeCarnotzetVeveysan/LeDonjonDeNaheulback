package com.naheulback.ledonjondenaheulback.classes;

public class Weapon {

    private String slug;
    private String name;
    private int level;
    private int power;
    private double quality;

    public Weapon(String inputSlug, int inputLevel, int inputPower){
        slug = inputSlug;
        //get true name from slug in dictionary
        name = inputSlug;
        level = inputLevel;
        power = inputPower;
        quality = 100;
    }

    public String getName(){
        return name + " (Niveau " + level + ")";
    }

    public String getStats(){
        return name + " (Niveau " + level + "), Qualité: " + quality;
    }

    public double getQuality(){ return quality; }

    public void decreaseQuality(int factor){
        quality -= factor;
    }

}
