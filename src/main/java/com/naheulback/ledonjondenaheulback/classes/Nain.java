package com.naheulback.ledonjondenaheulback.classes;

public class Nain extends Hero {

    private String saySomething;

    public Nain(String slug){

        super(slug);
        saySomething = "J'aime pas les elfes";

    }

    @Override
    public void speak() {

        System.out.println(saySomething);

    }
}