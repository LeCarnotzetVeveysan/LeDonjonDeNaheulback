package com.naheulback.ledonjondenaheulback.classes;

public class Elfe extends Hero {

    private String saySomething;

    public Elfe(String slug){

        super(slug);
        saySomething = "J'aime pas les nain";

    }

    @Override
    public void speak() {

        System.out.println(saySomething);

    }
}