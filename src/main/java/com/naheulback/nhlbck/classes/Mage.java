package com.naheulback.nhlbck.classes;

public class Mage extends Hero {

    private String saySomething;
    private Grimoire grimoire1, grimoire2;

    public Mage(String slug, String name){

        super(slug, name, "mage");
        saySomething = "J'aime les ogres ;)";

    }

    @Override
    public void speak() {
        System.out.println(saySomething);
    }

}
