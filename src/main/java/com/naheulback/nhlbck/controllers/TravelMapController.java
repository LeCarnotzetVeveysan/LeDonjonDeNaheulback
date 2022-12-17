package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.Functions;
import com.naheulback.nhlbck.Game;
import com.naheulback.nhlbck.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TravelMapController {

    private static final String resPath = "src/main/resources/com/naheulback/nhlbck/";
    private int actualDungeon;

    @FXML
    private StackPane d1iSP, d2iSP, d3iSP, d4iSP, d5iSP, d6iSP, d7iSP, d8iSP, d9iSP, d10iSP;

    @FXML
    private Label d1sLB, d2sLB, d3sLB, d4sLB, d5sLB, d6LB, d7sLB, d8sLB, d9sLB, d10sLB;

    public void initialize() throws IOException {

        ArrayList<StackPane> stackPanes = new ArrayList<>(Arrays.asList(d1iSP, d2iSP, d3iSP, d4iSP,
                d5iSP, d6iSP, d7iSP, d8iSP, d9iSP, d10iSP));
        ArrayList<Label> statLabels = new ArrayList<>(Arrays.asList(d1sLB, d2sLB, d3sLB, d4sLB,
                d5sLB, d6LB, d7sLB, d8sLB, d9sLB, d10sLB));

        for (StackPane sp : stackPanes){ sp.setVisible(false); }

        HashMap<String,String> nameDict = Functions.getDictFromFile("game","dungeonNames");
        int i = 1;
        for(Label lbl : statLabels){
            String[] arr = nameDict.get(String.valueOf(i)).split(",");
            String toDisplay = arr[0] + "\n" + arr[1];
            lbl.setText(toDisplay);
            i+=1;
        }
    }

    public void onDonjButtonClicked() throws IOException {
        Game.setDungeon(actualDungeon);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");
    }

    public void onDonj1ButtonHover() { actualDungeon = 1; d1iSP.setVisible(true); }
    public void onDonj1StoppedButtonHover() { d1iSP.setVisible(false); }
    public void onDonj2ButtonHover() { actualDungeon = 2; d2iSP.setVisible(true); }
    public void onDonj2StoppedButtonHover() { d2iSP.setVisible(false); }
    public void onDonj3ButtonHover() { actualDungeon = 3; d3iSP.setVisible(true); }
    public void onDonj3StoppedButtonHover() { d3iSP.setVisible(false); }
    public void onDonj4ButtonHover() { actualDungeon = 4; d4iSP.setVisible(true); }
    public void onDonj4StoppedButtonHover() { d4iSP.setVisible(false); }
    public void onDonj5ButtonHover() { actualDungeon = 5; d5iSP.setVisible(true); }
    public void onDonj5StoppedButtonHover() { d5iSP.setVisible(false); }
    public void onDonj6ButtonHover() { actualDungeon = 6; d6iSP.setVisible(true); }
    public void onDonj6StoppedButtonHover() { d6iSP.setVisible(false); }
    public void onDonj7ButtonHover() { actualDungeon = 7; d7iSP.setVisible(true); }
    public void onDonj7StoppedButtonHover() { d7iSP.setVisible(false); }
    public void onDonj8ButtonHover() { actualDungeon = 8; d8iSP.setVisible(true); }
    public void onDonj8StoppedButtonHover() { d8iSP.setVisible(false); }
    public void onDonj9ButtonHover() { actualDungeon = 9; d9iSP.setVisible(true); }
    public void onDonj9StoppedButtonHover() { d9iSP.setVisible(false); }
    public void onDonj10ButtonHover() { actualDungeon = 10; d10iSP.setVisible(true); }
    public void onDonj10StoppedButtonHover() { d10iSP.setVisible(false); }
}
