package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.classes.GameData;
import com.naheulback.nhlbck.classes.PlayerData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultsScreenController {

    @FXML
    private Label resultsLbl;

    public void initialize(){

        if(PlayerData.getIsDefeated()){
            resultsLbl.setText("defeat");
        } else {
            resultsLbl.setText("victory");
        }

    }
}
