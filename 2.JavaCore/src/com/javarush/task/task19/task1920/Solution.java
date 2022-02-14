package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        //String fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
        String fileName = args[0] ; //"span"

        Map<String, Double> map = new HashMap<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String[] line = bufferedReader.readLine().split(" ");
                final String key = line[0];
                //System.out.println(map.keySet().stream().filter(k-> k.equals(key)).findFirst());
                if (map.keySet().stream().filter(k -> k.equals(key)).findFirst().isPresent()) {
                    //map.put(line[0], Math.max(map.get(key), Double.parseDouble(line[1])));
                    map.put(line[0], map.get(key) + Double.parseDouble(line[1]));
                } else {
                    map.put(line[0], Double.parseDouble(line[1]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Double val = map.values().stream().max((o1, o2) -> o1.compareTo(o2)).get();
        List<String> list = new ArrayList<String>(map.keySet().stream().sorted().collect(Collectors.toList()));
        for (String el: list) {
            if (map.get(el).equals(val)) {
                System.out.println(el);
            }
        }
    }
}
