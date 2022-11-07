package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisplaySeneController {

    @FXML
    private Label displayLabel;

    public void initialize(){

        displayLabel.setText(String.valueOf(Game.getLevel()));

    }

}
