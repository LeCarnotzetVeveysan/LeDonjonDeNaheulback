package com.naheulback.nhlbck;

import com.naheulback.nhlbck.classes.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.*;

import static java.lang.Math.ceil;

public class Functions {

    private static final String resPath = "src/main/resources/com/naheulback/nhlbck/";

    public static void setImage(ImageView iv, String folder, String imageName) throws FileNotFoundException {
        InputStream stream = new FileInputStream(resPath + folder + "/" + imageName + ".png");
        Image image = new Image(stream);
        iv.setImage(image);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            if(!(is == null)){
                is.close();
            }
            if(!(os == null)){
                os.close();
            }

        }
    }
    public static void copyFile(String folder, String inputSource, String inputDest) throws IOException {
        File source = new File(resPath + folder + "/" + inputSource);
        File dest = new File(resPath + folder + "/" + inputDest);
        copyFileUsingStream(source, dest);
    }

    public static HashMap<String, String> getDictFromFile(String folder, String fileName) throws IOException {

        if(Objects.equals(fileName, "empty")){
            return new HashMap<>();
        }

        String path = resPath + folder + "Files/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));

        HashMap<String, String> toReturn = new HashMap<>() {};

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            toReturn.put(parts[0], parts[1]);
        }

        return toReturn;
    }

    public static void initTableFiles() throws IOException {

        String[] d1t1 = {"tavern1table1","hero1:lenain&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:lebarbare"};
        String[] d1t2 = {"tavern1table2","hero1:empty&hero2:empty&hero3:lamagicienne&hero4:empty&hero5:lelfe&hero6:empty"};
        String[] d2t1 = {"tavern2table1","hero1:lepaladin&hero2:empty&hero3:empty&hero4:caspied&hero5:empty&hero6:empty"};
        String[] d2t2 = {"tavern2table2","hero1:empty&hero2:empty&hero3:amanita&hero4:empty&hero5:tarken&hero6:empty"};
        String[] d3t1 = {"tavern3table1","hero1:empty&hero2:empty&hero3:gragan&hero4:empty&hero5:empty&hero6:empty"};
        String[] d3t2 = {"tavern3table2","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:borduz"};
        String[] d4t1 = {"tavern4table1","hero1:empty&hero2:empty&hero3:empty&hero4:feigaff&hero5:empty&hero6:lucrece"};
        String[] d4t2 = {"tavern4table2","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d5t1 = {"tavern5table1","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d5t2 = {"tavern5table2","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:gerard&hero6:empty"};
        String[] d6t1 = {"tavern6table1","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d6t2 = {"tavern6table2","hero1:empty&hero2:empty&hero3:norelenilia&hero4:empty&hero5:empty&hero6:empty"};
        String[] d7t1 = {"tavern7table1","hero1:empty&hero2:mimolett&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d7t2 = {"tavern7table2","hero1:empty&hero2:empty&hero3:empty&hero4:helrugar&hero5:empty&hero6:empty"};
        String[] d8t1 = {"tavern8table1","hero1:empty&hero2:empty&hero3:kzaranagax&hero4:empty&hero5:bifftanaen&hero6:empty"};
        String[] d8t2 = {"tavern8table2","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d9t1 = {"tavern9table1","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:empty"};
        String[] d9t2 = {"tavern9table2","hero1:empty&hero2:empty&hero3:empty&hero4:danjeliss&hero5:empty&hero6:empty"};
        String[] d10t1 = {"tavern10table1","hero1:empty&hero2:empty&hero3:wuxxus&hero4:empty&hero5:empty&hero6:empty"};
        String[] d10t2 = {"tavern10table2","hero1:empty&hero2:empty&hero3:empty&hero4:empty&hero5:empty&hero6:goltor"};
        ArrayList<String[]> partList = new ArrayList<>(Arrays.asList(d1t1,d1t2,d2t1,d2t2,d3t1,d3t2,d4t1,d4t2,d5t1,d5t2,
                d6t1,d6t2,d7t1,d7t2,d8t1,d8t2,d9t1,d9t2,d10t1,d10t2));

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

    public static void initDungeonFiles() throws IOException {
        for(int i = 1; i<= 10; i++) {
            copyFile("gameFiles","dungeon" + i + "floors_default", "dungeon" + i + "floors");
        }
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
            setImage(al.get(i), "heroImages",slugList.get(i) + "_table");
        }
    }

    public static ArrayList<String> getBarItems(String type) throws IOException {
        ArrayList<String> itemList = new ArrayList<>();
        HashMap<String,String> dict = getDictFromFile("game",type);
        ArrayList<String> al = new ArrayList<>(dict.keySet());
        Random rand = new Random();
        for(int i = 1; i <= 5; i++){
            int index = rand.nextInt(al.size() -1);
            itemList.add(al.get(index));
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

    public static void setCombatHeroImages(ArrayList<Hero> lhs, ArrayList<ImageView> al, Hero ah, ImageView ahiv) throws FileNotFoundException {

        for( ImageView iv : al){
            setImage(iv, "heroImages", "empty_combat");
        }
        for (int i = 0; i < lhs.size(); i++) {
            if(lhs.get(i) == null){
                setImage(al.get(i), "heroImages", "empty_combat");
            } else {
                setImage(al.get(i), "heroImages", lhs.get(i).getSlug() + "_combat");
            }

        }
        if(ah == null){
            setImage(ahiv, "heroImages", "empty_combat");
        } else {
            setImage(ahiv, "heroImages", ah.getSlug() + "_combat");
        }
    }

    public static void setBarImages(ArrayList<Hero> lhs, ArrayList<ImageView> al) throws FileNotFoundException {

        for( ImageView iv : al){
            setImage(iv, "heroImages", "empty_bar");
        }
        for (int i = 0; i < lhs.size(); i++) {
            setImage(al.get(i), "heroImages", lhs.get(i).getSlug() + "_bar");
        }

    }

    public static void setHeroHPBars(ArrayList<Hero> lhs, ArrayList<ImageView> al, ArrayList<Label> lb, ArrayList<ImageView> manaIVs, ArrayList<Label> manaLBs) throws FileNotFoundException {

        for( ImageView iv : al){ iv.setVisible(false); }
        for(Label lbl : lb){ lbl.setText("");}
        for (ImageView iv : manaIVs) { iv.setVisible(false);}
        for(Label lbl : manaLBs){ lbl.setText("");}
        for(int i=0;i < lhs.size();i++){
            if(!(lhs.get(i) == null)) {
                double percentage = 100 * (ceil(10.0 * lhs.get(i).getHealth() / lhs.get(i).getMaxHealth()) / 10);
                int rounded = (int) percentage;
                if(rounded < 0){ rounded = 0; }
                if(rounded > 100){ rounded = 100; }
                setImage(al.get(i), "otherImages", rounded + "HPbar");
                lb.get(i).setText(lhs.get(i).getHealth() + "/" + lhs.get(i).getMaxHealth());
                al.get(i).setVisible(true);

                if(lhs.get(i).getType().equals("mage")){
                    percentage = 100 * (ceil(10.0 * lhs.get(i).getMana() / lhs.get(i).getMaxMana()) / 10);
                    rounded = (int) percentage;
                    setImage(manaIVs.get(i), "otherImages", rounded + "HPbar");
                    manaLBs.get(i).setText(lhs.get(i).getMana() + "/" + lhs.get(i).getMaxMana());
                    manaIVs.get(i).setVisible(true);
                }
            }
        }
    }

    public static void setActiveHeroHPBars(Hero hero, ImageView hpiv, Label hplbl, ImageView manaiv, Label manalbl) throws FileNotFoundException {

        hpiv.setVisible(false);
        hplbl.setText("");
        manaiv.setVisible(false);
        manalbl.setText("");

        if(!(hero == null)) {
            double percentage = 100 * (ceil(10.0 * hero.getHealth() / hero.getMaxHealth()) / 10);
            int rounded = (int) percentage;
            if(rounded < 0){ rounded = 0; }
            if(rounded >= 100){ rounded = 100; }
            setImage(hpiv, "otherImages", rounded + "HPbar");
            hpiv.setVisible(true);
            hplbl.setText(hero.getHealth() + "/" + hero.getMaxHealth());

            if (hero.getType().equals("mage")) {
                percentage = 100 * (ceil(10.0 * hero.getMana() / hero.getMaxMana()) / 10);
                rounded = (int) percentage;
                setImage(manaiv, "otherImages", rounded + "HPbar");
                manalbl.setText(hero.getMana() + "/" + hero.getMaxMana());
                manaiv.setVisible(true);
            }
        }
    }

    public static void setInventoryImages(ArrayList<Item> inventory, ArrayList<ImageView> ivs) throws FileNotFoundException {

        for(ImageView iv : ivs){
            setImage(iv, "armouryImages", "empty_icon");
        }
        for(int i = 0; i < inventory.size(); i++){
            setImage(ivs.get(i), "armouryImages", inventory.get(i).getSlug() + "_icon");
        }

    }

    public static void initHeroFiles() {
        //reset hero files
    }

    public static void setHeroRecap(Hero hero, ArrayList<Label> lbls, ArrayList<ImageView> ivs ) throws IOException {
        String toDisplay = hero.getName() + " - " + hero.getType().substring(0, 1).toUpperCase() +
                hero.getType().substring(1) + " de niveau " + hero.getLevel();
        lbls.get(0).setText(toDisplay);

        setHeroRecapItemLabelsAndIVs(hero, 1, lbls.get(1), lbls.get(2), ivs.get(0));
        setHeroRecapItemLabelsAndIVs(hero, 2, lbls.get(3), lbls.get(4), ivs.get(1));
        setHeroRecapItemLabelsAndIVs(hero, 3, lbls.get(5), lbls.get(6), ivs.get(2));
        setHeroRecapItemLabelsAndIVs(hero, 4, lbls.get(7), lbls.get(8), ivs.get(3));
    }

    private static void setHeroRecapItemLabelsAndIVs(Hero hero, int item, Label lbl1, Label lbl2, ImageView iv) throws IOException {
        String itemName = "";
        String quality = "";
        String stat = "";

        switch (item) {
            case 1 -> {
                itemName = hero.getHeadItem() == null ? "null" : hero.getHeadItem().getSlug();
                quality = hero.getHeadItem() == null ? "null" : String.valueOf(hero.getHeadItem().getQuality());
                stat = hero.getHeadItem() == null ? "null" : String.valueOf(hero.getHeadItem().getArmor());
            }
            case 2 -> {
                itemName = hero.getBodyItem() == null ? "null" : hero.getBodyItem().getSlug();
                quality = hero.getBodyItem() == null ? "null" : String.valueOf(hero.getBodyItem().getQuality());
                stat = hero.getBodyItem() == null ? "null" : String.valueOf(hero.getBodyItem().getArmor());
            }
            case 3 -> {
                itemName = hero.getMainWeapon() == null ? "null" : hero.getMainWeapon().getSlug();
                quality = hero.getMainWeapon() == null ? "null" : String.valueOf(hero.getMainWeapon().getQuality());
                stat = hero.getMainWeapon() == null ? "null" : String.valueOf(hero.getMainWeapon().getPower());
            }
            case 4 -> {
                itemName = hero.getThrowableWeapon() == null ? "null" : hero.getThrowableWeapon().getSlug();
                quality = hero.getThrowableWeapon() == null ? "null" : String.valueOf(hero.getThrowableWeapon().getQuality());
                stat = hero.getThrowableWeapon() == null ? "null" : String.valueOf(hero.getThrowableWeapon().getPower());
            }
        }

        if(itemName.equals("null")){
            lbl1.setText("Il n'y a rien d'??quip??");
            lbl2.setText("");
            setImage(iv, "armouryImages", "null_icon");
        } else {
            String toDisplay;
            HashMap<String, String> dict = getDictFromFile("armoury", "armouryItems");
            String[] itemArr = dict.get(itemName).split(",");

            String name = itemArr[0].split("\\|")[1];
            String[] effet = itemArr[3].split("\\|")[1].split(" ");

            toDisplay = name;
            lbl1.setText(toDisplay);
            toDisplay = "Effet: " + effet[0] + " " + stat + " " + effet[2] + ", Qualit?? " + quality;
            lbl2.setText(toDisplay);

            switch (item){
                case 1 -> setImage(iv, "armouryImages", "helmet_icon");
                case 2 -> setImage(iv, "armouryImages", "armor_icon");
                case 3 -> setImage(iv, "armouryImages", "sword_icon");
                case 4 -> setImage(iv, "armouryImages", "dagger_icon");
            }

        }
    }

    public static void setThrowableWeaponImages(ArrayList<Weapon> weaps, ArrayList<ImageView> ivs) throws FileNotFoundException {
        for( ImageView iv : ivs){
            setImage(iv, "armouryImages", "empty_icon");
        }
        for (int i = 0; i < weaps.size(); i++) {
            setImage(ivs.get(i), "armouryImages", "dagger_icon");
        }
    }

    public static ArrayList<Enemy> getEnemyList(int floor) throws IOException {
        ArrayList<Enemy> toReturn = new ArrayList<>();
        ArrayList<Boolean> boolList = getEnemyStateList(floor);

        HashMap<String, String> bestiary = getDictFromFile("game", "bestiary");
        HashMap<String, String> dict = getDictFromFile("game", "dungeon" + Game.getDungeon() + "floors");
        String[] enemies = dict.get("floor" + floor).split(",") ;
        for(String slug : enemies){
            if(slug.equals("null")){
                toReturn.add(null);
            } else {
                String[] inDict = bestiary.get(slug).split(",");
                Boolean inAlive = boolList.get(Arrays.asList(enemies).indexOf(slug));
                if(inDict[0].equals("simple")){toReturn.add(new SimpleEnemy(slug, inDict, inAlive));}
                else {toReturn.add(new Boss(slug, inDict, inAlive));}

            }
        }
        return toReturn;
    }


    public static ArrayList<Boolean> getEnemyStateList(int floor) throws IOException {
        ArrayList<Boolean> toReturn = new ArrayList<>();
        HashMap<String, String> dict = getDictFromFile("game", "dungeon" + Game.getDungeon() + "floors");
        String[] states = dict.get("floor" + floor + "state").split(",") ;
        for(String s : states){
            if(s.equals("null")){
                toReturn.add(null);
            } else {
                toReturn.add(Boolean.valueOf(s));
            }

        }
        return toReturn;
    }
    public static void setCombatEnemyImages(ArrayList<Enemy> enemies, ArrayList<ImageView> enemyIVs, Enemy ae, ImageView aeiv) throws FileNotFoundException {
        for( ImageView iv : enemyIVs){
            setImage(iv, "combatImages", "empty_combat");
        }
        for (int i = 0; i < enemies.size(); i++) {

            if(enemies.get(i) == null){
                setImage(enemyIVs.get(i), "combatImages", "empty_combat");
            } else if(!enemies.get(i).getIsAlive()) {
                setImage(enemyIVs.get(i), "combatImages", enemies.get(i).getSlug() + "_dead");
            } else {
                setImage(enemyIVs.get(i), "combatImages", enemies.get(i).getSlug() + "_combat");
            }

        }
        if(ae == null){
            setImage(aeiv, "combatImages", "empty_combat");
        } else {
            setImage(aeiv, "combatImages", ae.getSlug() + "_combat");
        }
    }

    public static void setEnemyHPBars(ArrayList<Enemy> lhs, ArrayList<ImageView> al, ArrayList<Label> lb) throws FileNotFoundException {

        for( ImageView iv : al){ iv.setVisible(false); }
        for(Label lbl : lb){ lbl.setText("");}
        for(int i=0;i < lhs.size();i++){
            if(!(lhs.get(i) == null)) {
                if (lhs.get(i).getIsAlive()) {
                    double percentage = 100 * (ceil(10.0 * lhs.get(i).getHealth() / lhs.get(i).getMaxHealth()) / 10);
                    int rounded = (int) percentage;
                    if(rounded < 0){ rounded = 0; }
                    if(rounded > 100){ rounded = 100; }
                    setImage(al.get(i), "otherImages", rounded + "HPbar");
                    lb.get(i).setText(lhs.get(i).getHealth() + "/" + lhs.get(i).getMaxHealth());
                    al.get(i).setVisible(true);
                } else {
                    setImage(al.get(i), "otherImages",  "0HPbar");
                    lb.get(i).setText("");
                    al.get(i).setVisible(false);
                }
            }
        }
    }

    public static void setEnemyStateInFile(int floor, int index, String toSet) throws IOException {

        HashMap<String, String> dict = getDictFromFile("game", "dungeon" + Game.getDungeon() + "floors");
        String[] enemies = dict.get("floor" + floor + "state").split(",") ;
        enemies[index] = toSet;
        dict.put("floor" + floor + "state", enemies[0] + "," + enemies[1] + "," + enemies[2] + "," + enemies[3] + "," + enemies[4] + "," + enemies[5]);

        String fileName = resPath + "gameFiles/dungeon" + Game.getDungeon() + "floors";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for(String k : dict.keySet()){
            writer.write(k + ":" + dict.get(k));
            writer.newLine();
        }
        writer.close();
    }

    public static boolean areAllBossesDefeated() throws IOException {

        for(int i = 1; i <= 10; i++){
            HashMap<String, String> dict = getDictFromFile("game", "dungeon" + i + "floors");
            String bossState = dict.get("floor" + 10 + "state").split(",")[0];
            boolean isBossAlive = Boolean.parseBoolean(bossState);
            if(isBossAlive){
                return false;
            }
        }
        return true;
    }
}
