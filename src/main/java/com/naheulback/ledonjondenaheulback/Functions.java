package com.naheulback.ledonjondenaheulback;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Functions {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";

    public static HashMap<String, String> getHeroDictFromFile(String fileName) throws IOException {

        String path = resPath + "heroFiles/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));

        HashMap<String, String> toReturn = new HashMap<>() {};

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            toReturn.put(parts[0],parts[1]);
        }

        return toReturn;
    }

    public static void setTableImages(ArrayList<ImageView> al) throws IOException {

        int dungeon = Game.getDungeon();
        int table = Game.getTable();

        String path = resPath + "gameFiles/" + "tavern" + dungeon + "table" + table;
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> slugList = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            slugList.add(parts[1]);
        }

        for(int i=0;i<=5;i++){

            if(!slugList.get(i).equals("empty")) {
                path = resPath + "/tavernImages/" + slugList.get(i) + "_table.png";
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                al.get(i).setImage(image);
            }
        }

    }

}
