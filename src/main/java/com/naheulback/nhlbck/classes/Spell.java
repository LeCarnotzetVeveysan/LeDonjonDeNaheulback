package com.naheulback.nhlbck.classes;

public class Spell {

    private String slug;
    private String name;
    private int manaCost;
    private int magicDamage;

    public Spell(String inputSlug, String inputName, int inputManaCost, int inputMagicDamage){
        slug = inputSlug;
        name = inputName;
        manaCost = inputManaCost;
        magicDamage =inputMagicDamage;
    }

    public String getSlug(){
        return slug;
    }

    public int getManaCost(){ return manaCost; }

    public int getMagicDamage(){ return magicDamage; }

}
