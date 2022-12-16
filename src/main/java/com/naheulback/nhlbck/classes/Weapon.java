package com.naheulback.nhlbck.classes;

public class Weapon extends Item {

    private int power;
    private double quality;
    public Weapon(String inputSlug, String inputName, int inputLevel, int inputQuality, int inputPower){
        super(inputSlug, inputName, inputLevel);
        power = inputPower;
        quality = inputQuality;
    }

    public double getQuality(){ return quality; }

    public void decreaseQuality(double factor){
        quality -= factor;
    }

    public int getPower(){ return power;}

}
