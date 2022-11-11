package com.naheulback.ledonjondenaheulback.classes;

public class Warrior extends Hero {

    private String saySomething;

    public Warrior(){

        super();
        saySomething = "I am a warrior";

    }

    @Override
    public void speak() {
        System.out.println(saySomething);
    }




}
