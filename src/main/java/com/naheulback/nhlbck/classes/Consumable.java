package com.naheulback.nhlbck.classes;

import com.naheulback.nhlbck.Functions;

import java.io.IOException;
import java.util.HashMap;

public class Consumable extends Item {

    private int health;
    private int mana;
    public Consumable(String inSlug, String inName, int inLevel) throws IOException {
        super(inSlug, inName, inLevel);
        HashMap<String,String> dict = Functions.getDictFromFile("armoury","consumables");
        String[] arr = dict.get(inSlug).split(",");
        health = Integer.parseInt(arr[0]);
        mana = Integer.parseInt(arr[1]);
    }

    public int getHealth(){ return health; }

    public int getMana(){ return mana; }

}
