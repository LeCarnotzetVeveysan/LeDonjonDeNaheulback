package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Main;
import com.naheulback.ledonjondenaheulback.SceneLoad;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InstructionsPageController {
    public void onReturnButtonClick() throws IOException {

        SceneLoad.initUI("main-menu");
    }
}
