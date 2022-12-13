package com.naheulback.nhlbck.classes;

public class Elfe extends Hero {

    private String saySomething;

    public Elfe(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){
        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "elfe");
        saySomething = "J'aime pas les nains !";
    }

}
