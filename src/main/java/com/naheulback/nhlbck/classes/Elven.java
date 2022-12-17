package com.naheulback.nhlbck.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Elven extends Hero {

    private Quiver quiver;

    public Elven(HashMap<String, String> inDict){
        super(inDict.get("slug"), inDict.get("name"), Integer.parseInt(inDict.get("health")),
                Integer.parseInt(inDict.get("maxHealth")), Integer.parseInt(inDict.get("attack")),
                Integer.parseInt(inDict.get("magic")), Integer.parseInt(inDict.get("resistance")),
                true, "elfe");

        Quiver quiverBase = new Quiver("quiver_base", "Quiver with basic arrows", 1);
        super.addItem(quiverBase);
    }

    public void setQuiver(int level){
        ArrayList<String> inventorySlugs = getInventorySlugs();
        String type = "";
        switch (level){
            case 1 -> type = "quiver_base";
            case 2 -> type = "quiver_quality";
            case 3 -> type = "quiver_elven";
        }
        int index = inventorySlugs.indexOf(type);
        quiver = (Quiver) super.getInventory().get(index);
    }

    public Quiver getQuiver(){ return quiver; }

    public void setArrows(int level, int amount){
        ArrayList<String> inventorySlugs = getInventorySlugs();
        String type = "";
        switch (level){
            case 1 -> type = "quiver_base";
            case 2 -> type = "quiver_quality";
            case 3 -> type = "quiver_elven";
        }
        if(!type.equals("")) {
            int index = inventorySlugs.indexOf(type);
            ((Quiver) super.getInventory().get(index)).setArrows(amount);
        }
    }




}
