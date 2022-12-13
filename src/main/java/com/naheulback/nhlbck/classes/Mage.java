package com.naheulback.nhlbck.classes;

public class Mage extends Hero {

    private String saySomething;
    private Grimoire grimoire1, grimoire2;

    public Mage(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){
        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "mage");
        saySomething = "J'aime les ogres ;)";
    }

}
