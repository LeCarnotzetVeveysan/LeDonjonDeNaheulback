package com.naheulback.ledonjondenaheulback.classes;

public class Ranger extends Hero {

    private String saySomething;

    public Ranger(String slug){

        super(slug);
        saySomething = "Hop ! Hop ! Hop !";

    }

    @Override
    public void speak() {

        System.out.println(saySomething);

    }
}
