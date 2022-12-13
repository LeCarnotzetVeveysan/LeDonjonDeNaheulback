package com.naheulback.nhlbck.classes;

public class Ogre extends Hero {

    private String saySomething;

    public Ogre(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){

        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "ogre");
        saySomething = "TAGAZOG!!";

    }
}
