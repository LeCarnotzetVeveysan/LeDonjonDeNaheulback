package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import com.naheulback.ledonjondenaheulback.classes.Hero;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TravelMapController {

    public void initialize() throws FileNotFoundException {

    }
    public void onDonj1ButtonClicked() throws IOException {

        Game.setDungeon(1);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");

    }

    public void onDonj2ButtonClicked() throws IOException {

        Game.setDungeon(2);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");

    }
}
