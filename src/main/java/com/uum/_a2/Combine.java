package com.uum._a2;


import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Combine {

    public JSONObject json;
    public JSONArray array;
    public JSONObject item;
    public String matric;

    public void combinejson(JSONObject lista, JSONObject word, JSONObject emp) {
        try {
            array = lista.getJSONArray("information");
            array.put(word);
            array.put(emp);
        } catch (JSONException ex) {
            Logger.getLogger(Combine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista.toString());
    }
}
