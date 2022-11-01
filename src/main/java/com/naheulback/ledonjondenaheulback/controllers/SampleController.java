package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.heroClasses.TestChar;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SampleController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        TestChar tc = new TestChar();
        String newTitle = tc.getName();
        welcomeText.setText(newTitle);
    }

}
