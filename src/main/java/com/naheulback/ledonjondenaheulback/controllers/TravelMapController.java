package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.GameData;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;

import java.io.IOException;

public class TravelMapController {

    public void initialize(){

    }
    public void onDonj1ButtonClicked() throws IOException {

        Game.setZone(1);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");

    }
}
