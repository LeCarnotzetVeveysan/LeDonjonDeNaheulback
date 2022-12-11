package com.naheulback.ledonjondenaheulback;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.*;

public class Functions {

    private static String resPath = "src/main/resources/com/naheulback/ledonjondenaheulback/";

    public static HashMap<String, String> getDictFromFile(String folder, String fileName) throws IOException {

        if(fileName == "empty"){
            return new HashMap<String,String>();
        }

        String path = resPath + folder + "Files/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));

        HashMap<String, String> toReturn = new HashMap<>() {};

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            toReturn.put(parts[0],parts[1]);
        }

        return toReturn;
    }

    public static void initTableFiles() throws IOException {

        String[] d1t1 = {"tavern1table1","hero1:lenain&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:lebarbare"};
        String[] d1t2 = {"tavern1table2","hero1:logre&hero2:empty&hero3:lamagicienne&hero4:empty&hero5:lelfe&hero6:empty"};
        String[] d1t3 = {"tavern1table3","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d2t1 = {"tavern2table1","hero1:levoleur&hero2:empty&hero3:gontran&hero4:empty&hero5:empty&hero6:empty"};
        ArrayList<String[]> partList = new ArrayList<String[]>(Arrays.asList(d1t1, d1t2, d1t3, d2t1));

        for(String[] strar : partList){

            String path = resPath + "gameFiles/" + strar[0];
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            String[] parts = strar[1].split("&");
            for(int i = 0; i <= 5; i++){
                writer.write(parts[i]);
                writer.newLine();
            }
            writer.close();
        }

    }

    public static void setImage(ImageView iv, String folder, String imageName) throws FileNotFoundException {
        InputStream stream = new FileInputStream(resPath + folder + "/" + imageName + ".png");
        Image image = new Image(stream);
        iv.setImage(image);
    }

    public static void setItemButtonHBSize(HBox hb) {
        hb.setVisible(true);
        hb.setDisable(false);

        int width = switch (hb.getChildren().size()) {
            case 1 -> 166;
            case 2 -> 352;
            case 3 -> 538;
            case 4 -> 744;
            case 5 -> 930;
            default -> 0;
        };
        hb.setLayoutX(500.0 - (width/2.0));
    }

    public static void updateTableFile(ArrayList<String> slugList) throws IOException {

        String path = resPath + "gameFiles/tavern" + Game.getDungeon() + "table" + Game.getTable();
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        for(int i = 0; i <= 5; i++){
            writer.write("hero" + (i + 1) + ":" + slugList.get(i));
            writer.newLine();
        }

        writer.close();

    }

    public static ArrayList<String> getTableSlugList() throws IOException {
        String path = resPath + "gameFiles/tavern" + Game.getDungeon() + "table" + Game.getTable();
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

    public static ArrayList<String> getBarItems(String type) throws IOException {
        String path = resPath + "tavernFiles/bar" + Game.getDungeon() + "_" + type;
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> itemList = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            itemList.add(parts[1]);
        }
        return itemList;

    }

    public static ArrayList<String> getArmouryItems(String type) throws IOException {
        String path = resPath + "armouryFiles/armoury" + Game.getDungeon() + "_" + type;
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> itemList = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            itemList.add(parts[1]);
        }
        return itemList;

    }

    public static String getSpeakingHeroSlug() throws IOException {
        ArrayList<String> slugList = getTableSlugList();
        return slugList.get(Game.getSpeakingHero());
    }

    public static void setBarImages(ArrayList<String> lhs, ArrayList<ImageView> al) throws FileNotFoundException {
        for(int i=0;i<=5;i++){
            String path = resPath + "/tavernImages/" + lhs.get(i) + "_bar.png";
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            al.get(i).setImage(image);
        }
    }



}
