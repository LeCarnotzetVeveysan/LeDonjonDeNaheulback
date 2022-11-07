package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.SceneLoad;

import java.io.IOException;

public class InstructionsPageController {
    public void onReturnButtonClick() throws IOException {

        SceneLoad.changeScene("main-menu");
    }
}
