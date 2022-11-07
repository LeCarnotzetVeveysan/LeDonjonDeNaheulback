package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.classes.GameData;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game {

    private Stage mainStage;
    private static GameData gameData;

    public Game(Stage inputStage){

        mainStage = inputStage;
        gameData = new GameData();

    }

    public void main() throws IOException {

          SceneLoad sl = new SceneLoad(mainStage);
          sl.changeScene("main-menu");

    }

    public static void nameTest(){

        gameData.setName("youyou");
        gameData.getName();

    }

    public static void setLevel(int inputLevel){
        gameData.setLevel(inputLevel);
    }

    public static int getLevel(){
        return gameData.getLevel();
    }

}
