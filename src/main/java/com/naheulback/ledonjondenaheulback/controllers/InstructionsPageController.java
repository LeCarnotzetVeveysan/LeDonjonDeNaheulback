package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.LoadScene;

import java.io.IOException;

public class InstructionsPageController {
    public void onReturnButtonClick() throws IOException {

        LoadScene.changeScene("main-menu");
    }
}
