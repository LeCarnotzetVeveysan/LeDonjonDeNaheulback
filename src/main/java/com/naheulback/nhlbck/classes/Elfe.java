package com.naheulback.nhlbck.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Elfe extends Hero {

    private Carquois carquois;

    public Elfe(HashMap<String, String> inDict){
        super(inDict.get("slug"), inDict.get("name"), Integer.parseInt(inDict.get("health")),
                Integer.parseInt(inDict.get("maxHealth")), Integer.parseInt(inDict.get("attack")),
                Integer.parseInt(inDict.get("magic")), Integer.parseInt(inDict.get("resistance")),
                true, "elfe");

        Carquois carquoisBase = new Carquois("carquois_base", "Carquois de flèches de base", 1);
        super.addItem(carquoisBase);
    }

    public void setCarquois(int level){
        ArrayList<String> inventorySlugs = getInventorySlugs();
        String type = "";
        switch (level){
            case 1 -> type = "carquois_base";
            case 2 -> type = "carquois_qualité";
            case 3 -> type = "carquois_sylvain";
        }
        int index = inventorySlugs.indexOf(type);
        carquois = (Carquois) super.getInventory().get(index);
    }

    public Carquois getCarquois(){ return carquois; }

    public void setFleches(int level, int amount){
        ArrayList<String> inventorySlugs = getInventorySlugs();
        String type = "";
        switch (level){
            case 1 -> type = "carquois_base";
            case 2 -> type = "carquois_qualité";
            case 3 -> type = "carquois_sylvain";
        }
        if(!type.equals("")) {
            int index = inventorySlugs.indexOf(type);
            ((Carquois) super.getInventory().get(index)).setFleches(amount);
        }
    }




}
