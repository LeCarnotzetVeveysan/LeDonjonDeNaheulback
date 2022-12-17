package com.naheulback.nhlbck.classes;

public abstract class Item {

    private final String slug;
    private final String name;
    private final int level;

    public Item(String inputSlug, String inputName, int inputLevel){
        slug = inputSlug;
        name = inputName;
        level =inputLevel;
    }

    public String getName(){
        return name;
    }

    public String getSlug(){
        return slug;
    }

    public int getLevel() { return level;}

}
