package com.naheulback.ledonjondenaheulback.classes;

public class Mage extends Hero {

    private String saySomething;

    public Mage(String slug, String name){

        super(slug, name);
        saySomething = "J'aime les ogres ;)";

    }

    @Override
    public void speak() {
        System.out.println(saySomething);
    }

}
