package com.naheulback.nhlbck.controllers;

import com.naheulback.nhlbck.LoadScene;

import java.io.IOException;

public class InstructionsController {
    public void onReturnButtonClick() throws IOException {

        LoadScene.changeScene("menu-main-menu");
    }
}
