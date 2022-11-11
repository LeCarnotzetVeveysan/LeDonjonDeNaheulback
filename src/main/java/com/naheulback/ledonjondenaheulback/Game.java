package com.naheulback.ledonjondenaheulback;

import com.naheulback.ledonjondenaheulback.classes.GameData;
import com.naheulback.ledonjondenaheulback.classes.PlayerData;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {

    private Stage mainStage;
    private static GameData gameData;
    private static PlayerData playerData;

    public Game(Stage inputStage){

        mainStage = inputStage;
        gameData = new GameData();
        playerData = new PlayerData();

    }

    public void main() throws IOException {

          LoadScene ls = new LoadScene(mainStage);
          ls.changeScene("menu-main-menu");

    }

    public static void setLevel(int inputLevel){
        gameData.setLevel(inputLevel);
    }

    public static int getLevel(){
        return gameData.getLevel();
    }

    public static int getZone(){ return playerData.getZone(); }

    public static void setZone(int zone){ playerData.setZone(zone);}

    public static int getRoom(){ return playerData.getRoom(); }

    public static void setRoom(int room){ playerData.setRoom(room);}

}
