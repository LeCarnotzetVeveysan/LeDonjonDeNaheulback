package com.naheulback.ledonjondenaheulback.classes;

import java.util.ArrayList;

public class PlayerData {

    private String teamName;

    private ArrayList<Hero> heroes;
    private int[] currentLocation;


    public PlayerData(){

        teamName = "La compagnie des forts de café";
        heroes = new ArrayList<>();

        currentLocation = new int[]{0, 0};

    }

    public String getName(){
        return teamName;
    }

    public int getZone(){ return currentLocation[0]; }

    public void setZone(int zone){ currentLocation[0] = zone;}

    public int getRoom(){ return currentLocation[1]; }

    public void setRoom(int room){ currentLocation[1] = room;}

}
