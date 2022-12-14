package com.naheulback.nhlbck.classes;

public class Grimoire extends Item {

    public Grimoire(String inputSlug, String inputName, int inputLevel) {
        super(inputSlug, inputName, inputLevel);
    }

    public String toString(){
        return getName();
    }

}
