package com.naheulback.ledonjondenaheulback.classes;

public class Ranger extends Hero {

    private String saySomething;

    public Ranger(String slug, String name){

        super(slug, name, "ranger");
        saySomething = "Hop ! Hop ! Hop !";

    }

    @Override
    public void speak() {

        System.out.println(saySomething);

    }
}
