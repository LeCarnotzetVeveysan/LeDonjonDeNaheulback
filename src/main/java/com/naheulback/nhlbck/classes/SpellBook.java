package com.naheulback.nhlbck.classes;

import com.naheulback.nhlbck.Functions;

import java.io.IOException;
import java.util.HashMap;

public class SpellBook extends Item {

    private final Spell spell1;
    private final Spell spell2;

    public SpellBook(String inputSlug, String inputName, int inputLevel) throws IOException {
        super(inputSlug, inputName, inputLevel);

        HashMap<String, String> spellbookDict = Functions.getDictFromFile("armoury","spellbooks");
        String[] sorts = spellbookDict.get(inputSlug).split(",");

        HashMap<String,String> spellDict = Functions.getDictFromFile("armoury", "spells");
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
