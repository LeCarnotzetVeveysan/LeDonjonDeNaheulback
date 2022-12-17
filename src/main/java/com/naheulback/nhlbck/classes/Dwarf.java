package com.naheulback.nhlbck.classes;

import java.util.HashMap;

public class Dwarf extends Hero {
    public Dwarf(HashMap<String, String> inDict) {
        super(inDict.get("slug"), inDict.get("name"), Integer.parseInt(inDict.get("health")),
                Integer.parseInt(inDict.get("maxHealth")), Integer.parseInt(inDict.get("attack")),
                Integer.parseInt(inDict.get("magic")), Integer.parseInt(inDict.get("resistance")),
                true, "nain");
    }
}
