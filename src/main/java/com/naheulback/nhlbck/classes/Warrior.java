package com.naheulback.nhlbck.classes;

public class Warrior extends Hero {

    private String saySomething;

    public Warrior(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){
        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "warrior");
    }


}
