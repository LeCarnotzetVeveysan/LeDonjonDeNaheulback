package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;

import java.io.IOException;

public class TravelMapController {

    public void initialize(){

    }
    public void onDonj1ButtonClicked() throws IOException {

        Game.setDungeon(1);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");

    }
}
