package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;

import java.io.IOException;

public class TravelMapController {

    private int actualDungeon;

    public void initialize() throws IOException {}

    public void onDungeonClicked() throws IOException {
        Game.setDungeon(actualDungeon);
        Game.setRoom(-1);
        LoadScene.changeScene("dungeon-outside");
    }

    public void onD1BtnHov() { actualDungeon = 1; }
    public void onD2BtnHov() { actualDungeon = 2; }
    public void onD3BtnHov() { actualDungeon = 3; }
    public void onD4BtnHov() { actualDungeon = 4; }
    public void onD5BtnHov() { actualDungeon = 5; }
    public void onD6BtnHov() { actualDungeon = 6; }
    public void onD7BtnHov() { actualDungeon = 7; }
    public void onD8BtnHov() { actualDungeon = 8; }
    public void onD9BtnHov() { actualDungeon = 9; }
    public void onD10BtnHov() { actualDungeon = 10; }
}
