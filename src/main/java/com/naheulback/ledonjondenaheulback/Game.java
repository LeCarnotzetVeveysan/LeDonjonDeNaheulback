package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.classes.GameData;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {

    private Stage mainStage;
    private static GameData gameData;

    public Game(Stage inputStage){

        mainStage = inputStage;
        gameData = new GameData();

    }

    public void main() throws IOException {

          LoadScene ls = new LoadScene(mainStage);
          ls.changeScene("main-menu");

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

    public static int getZone(){ return gameData.getZone(); }

    public static int getRoom(){ return gameData.getRoom(); }

}
