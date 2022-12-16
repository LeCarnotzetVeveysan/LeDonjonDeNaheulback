package com.naheulback.nhlbck.classes;

public class Grimoire extends Item {

    private Spell spell1;
    private Spell spell2;

    public Grimoire(String inputSlug, String inputName, int inputLevel) {
        super(inputSlug, inputName, inputLevel);
        spell1 = null;
        spell2 = null;
    }

    public String toString(){
        return getName();
    }

    public Spell getSpell1(){
        return spell1;
    }

    public Spell getSpell2(){
        return spell2;
    }

}
