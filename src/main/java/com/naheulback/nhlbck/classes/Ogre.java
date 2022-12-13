package com.naheulback.nhlbck.classes;

public class Ogre extends Hero {

    private String saySomething;

    public Ogre(String slug, String name){

        super(slug, name, "ogre");
        saySomething = "TAGAZOG !";

    }

    @Override
    public void speak() {

        System.out.println(saySomething);

    }
}