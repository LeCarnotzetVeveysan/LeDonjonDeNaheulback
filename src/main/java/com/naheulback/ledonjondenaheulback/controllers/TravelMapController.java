package com.naheulback.ledonjondenaheulback.controllers;

import com.naheulback.ledonjondenaheulback.Game;
import com.naheulback.ledonjondenaheulback.LoadScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static javafx.scene.layout.BackgroundPosition.CENTER;
import static javafx.scene.layout.BackgroundRepeat.NO_REPEAT;
import static javafx.scene.layout.BackgroundRepeat.REPEAT;
import static javafx.scene.layout.BackgroundSize.DEFAULT;

public class TravelMapController {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";
    private int actualDungeon;

    @FXML
    private StackPane donj1InfoSP;
    @FXML
    private StackPane donj2InfoSP;
    @FXML
    private StackPane donj3InfoSP;
    @FXML
    private StackPane donj4InfoSP;
    @FXML
    private StackPane donj5InfoSP;
    @FXML
    private StackPane donj6InfoSP;
    @FXML
    private StackPane donj7InfoSP;
    @FXML
    private StackPane donj8InfoSP;
    @FXML
    private StackPane donj9InfoSP;
    @FXML
    private StackPane donj10InfoSP;

    @FXML
    private Label donj1StatsLbl;
    @FXML
    private Label donj2StatsLbl;
    @FXML
    private Label donj3StatsLbl;
    @FXML
    private Label donj4StatsLbl;
    @FXML
    private Label donj5StatsLbl;
    @FXML
    private Label donj6StatsLbl;
    @FXML
    private Label donj7StatsLbl;
    @FXML
    private Label donj8StatsLbl;
    @FXML
    private Label donj9StatsLbl;
    @FXML
    private Label donj10StatsLbl;

    public void initialize() throws IOException {

        ArrayList<StackPane> stackPanes = new ArrayList<>(Arrays.asList(donj1InfoSP,donj2InfoSP,donj3InfoSP,donj4InfoSP,
                                                                        donj5InfoSP,donj6InfoSP,donj7InfoSP,donj8InfoSP,
                                                                        donj9InfoSP,donj10InfoSP));
        ArrayList<Label> statLabels = new ArrayList<>(Arrays.asList(donj1StatsLbl,donj2StatsLbl,donj3StatsLbl,donj4StatsLbl,
                                                                    donj5StatsLbl,donj6StatsLbl,donj7StatsLbl,donj8StatsLbl,
                                                                    donj9StatsLbl,donj10StatsLbl));

        for (StackPane sp : stackPanes){ sp.setVisible(false); }

        for(Label lbl : statLabels){
            String path = resPath + "mapFiles/donj" + (statLabels.indexOf(lbl) + 1) + "_stats";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String toDisplay = "";
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                toDisplay += line;
                if(!line.equals("")){
                    toDisplay += "\n";
                }
            }
            lbl.setText(toDisplay);
        }
    }

    public void onDonjButtonClicked() throws IOException {
        Game.setDungeon(actualDungeon);
        Game.setRoom(0);
        LoadScene.changeScene("dungeon-outside");
    }
    public void onDonj1ButtonHover() { actualDungeon = 1; donj1InfoSP.setVisible(true); }
    public void onDonj1StoppedButtonHover() { donj1InfoSP.setVisible(false); }
    public void onDonj2ButtonHover() { actualDungeon = 2; donj2InfoSP.setVisible(true); }
    public void onDonj2StoppedButtonHover() { donj2InfoSP.setVisible(false); }
    public void onDonj3ButtonHover() { actualDungeon = 3; donj3InfoSP.setVisible(true); }
    public void onDonj3StoppedButtonHover() { donj3InfoSP.setVisible(false); }
    public void onDonj4ButtonHover() { actualDungeon = 4; donj4InfoSP.setVisible(true); }
    public void onDonj4StoppedButtonHover() { donj4InfoSP.setVisible(false); }
    public void onDonj5ButtonHover() { actualDungeon = 5; donj5InfoSP.setVisible(true); }
    public void onDonj5StoppedButtonHover() { donj5InfoSP.setVisible(false); }
    public void onDonj6ButtonHover() { actualDungeon = 6; donj6InfoSP.setVisible(true); }
    public void onDonj6StoppedButtonHover() { donj6InfoSP.setVisible(false); }
    public void onDonj7ButtonHover() { actualDungeon = 7; donj7InfoSP.setVisible(true); }
    public void onDonj7StoppedButtonHover() { donj7InfoSP.setVisible(false); }
    public void onDonj8ButtonHover() { actualDungeon = 8; donj8InfoSP.setVisible(true); }
    public void onDonj8StoppedButtonHover() { donj8InfoSP.setVisible(false); }
    public void onDonj9ButtonHover() { actualDungeon = 9; donj9InfoSP.setVisible(true); }
    public void onDonj9StoppedButtonHover() { donj9InfoSP.setVisible(false); }
    public void onDonj10ButtonHover() { actualDungeon = 10; donj10InfoSP.setVisible(true); }
    public void onDonj10StoppedButtonHover() { donj10InfoSP.setVisible(false); }
}
