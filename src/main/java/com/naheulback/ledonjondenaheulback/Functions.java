package com.naheulback.ledonjondenaheulback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class Functions {

    public static HashMap<String, String> getHeroDictFromFile(String fileName) throws IOException {

        String path = "src/main/resources/com/naheulback/ledonjondenaheulback/heroFiles/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));

        HashMap<String, String> toReturn = new HashMap<>() {};

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parts = line.split(":");
            toReturn.put(parts[0],parts[1]);
        }

        return toReturn;
    }

}
