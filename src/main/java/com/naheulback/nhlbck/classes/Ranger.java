package com.naheulback.nhlbck.classes;

public class Ranger extends Hero {

    private String saySomething;

    public Ranger(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){

        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "ranger");
        saySomething = "Hop ! Hop ! Hop !";

    }
}
