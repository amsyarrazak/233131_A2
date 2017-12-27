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
public class ClassKeyWord {
     LinkedList<String> listFileContent;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;
    String task;
    String matric;
    public int total;
    
    String mainkeyword[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue",
        "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for",
        "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package",
        "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
        "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "null",
        "false", "const", "goto"};
    
    public JSONObject CalculateMainW (String [] list){
         for (int i = 0; i < list.length; i++) {
            int[] q = new int[mainkeyword.length];
            try (BufferedReader br = new BufferedReader(new FileReader(list[i]))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matric = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    for (int j = 0; j < mainkeyword.length; j++) {
                        if (readLine.contains(mainkeyword[j])) {
                            q[j] = q[j] + 1;
                        }
                    }
                }
            } catch (IOException e) {
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matric);
                for (int l = 0; l < mainkeyword.length; l++) {
                    item.put(mainkeyword[l], q[l]);
                }
                array.put(item);
                json.put("listKeyword", array);
            } catch (JSONException ex) {
            }
        }
        return json;
    }
    
     
    
}
