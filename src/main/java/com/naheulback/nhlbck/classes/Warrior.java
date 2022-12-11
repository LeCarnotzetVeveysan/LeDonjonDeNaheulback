package com.naheulback.nhlbck.classes;

public class Warrior extends Hero {

    private String saySomething;

    public Warrior(String slug, String name){

        super(slug, name, "warrior");
        saySomething = "I am a warrior";

    }

    @Override
    public void speak() {
        System.out.println(saySomething);
    }




}
