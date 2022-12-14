package com.naheulback.nhlbck.classes;

public abstract class Item {

    private String slug;
    private String name;
    private int level;

    public Item(String inputSlug, String inputName, int inputLevel){
        slug = inputSlug;
        name = inputName;
        level =inputLevel;
    }

    public String getName(){
        return name + " (Niveau " + level + ")";
    }

    public String getSlug(){
        return slug;
    }

    public int getLevel() { return level;}

}
