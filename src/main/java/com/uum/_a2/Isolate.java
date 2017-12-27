package com.uum._a2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Isolate {
    LinkedList<String> listFileContent;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;
    String task;
    String matric;
    public int total;
    
    public JSONObject SearchLine(String[] listJavaFile) {
        for (int i = 0; i < listJavaFile.length; i++) {
            int command = 0;
            int kosong = 0;
            int code = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                total = 0;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matric = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    if (readLine.contains("//")) {
                        command++;
                    } else if (readLine.isEmpty()) {
                        kosong++;
                    } else {
                        code++;
                    }
                    total++;
                }
            } catch (IOException e) {
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matric);
                item.put("Command", command);
                item.put("Empty", kosong);
                item.put("Actual", code);
                array.put(item);
                json.put("line", array);
            } catch (JSONException ex) {
            }
        }
        return json;
    
     }
}
