package com.uum._a2;


import java.io.File;
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
public class Assignment2 {

    public static void main(String[] arg) {

        File f = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\233131_A2\\test\\Assignment1");
        Keyword k = new Keyword(f);
        String[] list = k.list;
        
        Identify pa = new Identify();        
        JSONObject lista = pa.jsonlist;
        pa.data(list);
        
        ClassKeyWord y = new ClassKeyWord();
        y.CalculateMainW(list);
         JSONObject word =y.json;
         
        Isolate i = new Isolate();
        i.SearchLine(list);
         JSONObject emp = i.json;
        
        
        
    }
}
