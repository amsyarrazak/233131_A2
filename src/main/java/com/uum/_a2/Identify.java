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
public class Identify {
    LinkedList<String> listFileContent;
    public String sem, course ,group ,task ,matric, nme;
    public JSONArray arry = new JSONArray();
    public JSONObject jsonlist = new JSONObject();
    
    public JSONObject data (String [] list){
        for (int i = 0; i < list.length; i++) {
            try (BufferedReader read = new BufferedReader(new FileReader(list[i]))) {
                String readline;
                while ((readline = read.readLine()) != null) {
                    if (readline.contains("//Semester:")) {
                        //System.out.println(listJavaFile[i]);
                        sem = readline.replaceAll("\\s*//Semester:\\s*#", "");
                    } else if (readline.contains("//Course:")) {
                        course = readline.replaceAll("\\s*//Course:\\s*#", "");
                    } else if (readline.contains("//Task:")) {
                        task = readline.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readline.contains("//Matrik:")) {
                        matric = readline.replaceAll("\\s*//Matrik:\\s*#", "");
                    } else if (readline.contains("//Name:")) {
                        nme = readline.replaceAll("\\s*//Name:\\s*#", "");
                    }
                }
            } catch (IOException e) {
            }
            try {
                JSONObject item = new JSONObject();
                item.put("File Name", list[i]);
                item.put("Semester", sem);
                item.put("Course", course);
                item.put("Task", task);
                item.put("Matrik", matric);
                item.put("Name", nme);
                arry.put(item);

                jsonlist.put("information", arry);
            } catch (JSONException ex) {
            }
        }
        return jsonlist;
    }
    
}
