package com.naheulback.nhlbck.classes;

public abstract class Item {

    private final String slug;
    private final String name;
    private final int level;

    public Item(String inSlug, String inName, int inLevel){
        slug = inSlug;
        name = inName;
        level = inLevel;
    }

    public String getName(){
        return name;
    }

    public String getSlug(){
        return slug;
    }

    public int getLevel() { return level;}

}
