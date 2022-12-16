package com.naheulback.nhlbck.classes;

import java.util.HashMap;

public class Mage extends Hero {

    private Spell mainSpell;
    private Spell secondarySpell;

    public Mage(HashMap<String, String> inDict) {
        super(inDict.get("slug"), inDict.get("name"), Integer.parseInt(inDict.get("health")),
                Integer.parseInt(inDict.get("maxHealth")), Integer.parseInt(inDict.get("attack")),
                Integer.parseInt(inDict.get("magic")), Integer.parseInt(inDict.get("resistance")),
                true, "mage");

        mainSpell = null;
        secondarySpell = null;
    }

    public Spell getFirstSpell(){
        return mainSpell;
    }

    public void setMainSpell(Spell inputSpell){
        mainSpell = inputSpell;
    }

    public void setSecondarySpell(Spell inputSpell){
        secondarySpell = inputSpell;
    }

    public Spell getSecondarySpell(){
        return secondarySpell;
    }

}
