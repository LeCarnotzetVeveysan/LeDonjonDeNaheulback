package com.naheulback.ledonjondenaheulback;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Functions {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";

    public static HashMap<String, String> getHeroDictFromFile(String fileName) throws IOException {

        if(fileName == "empty"){
            return new HashMap<String,String>();
        }

        String path = resPath + "heroFiles/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));

        HashMap<String, String> toReturn = new HashMap<>() {};

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            toReturn.put(parts[0],parts[1]);
        }

        return toReturn;
    }

    public static void updateTableFile() throws IOException {

        ArrayList<String> slugList = getTableSlugList();
        slugList.set(Game.getSpeakingHero(), "empty");

        String path = resPath + "gameFiles/tavern" + Game.getDungeon() + "table" + Game.getTable();
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        for(int i = 0; i <= 5; i++){
            writer.write("hero" + (i + 1) + ":" + slugList.get(i));
            writer.newLine();
        }

        writer.close();
        System.out.println("fichier est censé etre mis à jour");


    }

    private static ArrayList<String> getTableSlugList() throws IOException {
        String path = resPath + "gameFiles/" + "tavern" + Game.getDungeon() + "table" + Game.getTable();
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> slugList = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            slugList.add(parts[1]);
        }

        return slugList;
    }

    public static void setTableImages(ArrayList<ImageView> al) throws IOException {

        ArrayList<String> slugList = getTableSlugList();

        for(int i=0;i<=5;i++){
            String path = resPath + "/tavernImages/" + slugList.get(i) + "_table.png";
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            al.get(i).setImage(image);
        }
    }

    public static String getSpeakingHeroSlug() throws IOException {
        ArrayList<String> slugList = getTableSlugList();
        return slugList.get(Game.getSpeakingHero());
    }



}
