package com.naheulback.nhlbck.classes;

import com.naheulback.nhlbck.Functions;

import java.io.IOException;
import java.util.HashMap;

public class Grimoire extends Item {

    private Spell spell1;
    private Spell spell2;

    public Grimoire(String inputSlug, String inputName, int inputLevel) throws IOException {
        super(inputSlug, inputName, inputLevel);

        HashMap<String, String> grimoireDict = Functions.getDictFromFile("armoury","grimoires");
        String[] sorts = grimoireDict.get(inputSlug).split(",");

        HashMap<String,String> spellDict = Functions.getDictFromFile("armoury", "sorts");
        String[] infos = spellDict.get(sorts[0]).split(",");
        spell1 = new Spell(sorts[0], infos[0], Integer.parseInt(infos[1]), Integer.parseInt(infos[2]));
        infos = spellDict.get(sorts[1]).split(",");
        spell2 = new Spell(sorts[1], infos[0], Integer.parseInt(infos[1]), Integer.parseInt(infos[2]));
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
