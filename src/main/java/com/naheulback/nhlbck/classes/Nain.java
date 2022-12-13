package com.naheulback.nhlbck.classes;

public class Nain extends Hero {

    private String saySomething;
    public Nain(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){

        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "nain");
        saySomething = "J'aime pas les elfes";

    }
}
