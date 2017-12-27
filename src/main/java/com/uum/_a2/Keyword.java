package com.uum._a2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Keyword {
 
    public String[] list;
    public int calculate;

    public Keyword(File f) {

        Collection<File> file = new ArrayList();
        set(f, file);
        Collection<File> q = file;
        list = filterjava(q);
        issues(list);

    }

    static void set(File file, Collection<File> all) {
        File[] a = file.listFiles();
        if (a != null) {
            for (File b : a) {
                all.add(b);
                set(b, all);
            }
        }
    }

    static String[] filterjava(Collection<File> a) {
        LinkedList<String> b = new LinkedList();
        Iterator<File> c = a.iterator();
        File d;
        while (c.hasNext()) {
            d = c.next();
            if (d.getName().endsWith(".java")) {
                b.add(d.getAbsolutePath());

            }
        }
        String[] list = new String[b.size()];
        for (int i = 0; i < b.size(); i++) {
            list[i] = b.get(i);
        }
        return list;
    }

    public void issues(String[] list) {
        for (int i = 0; i < list.length; i++) {
            try (BufferedReader read = new BufferedReader(new FileReader(list[i]))) {
                String rLine;

                while ((rLine = read.readLine()) != null) {
                    if (rLine.contains("public static void main")) {
                        calculate++;
                    }
                }
            } catch (IOException e) {
                
            }

        }
    }

}
