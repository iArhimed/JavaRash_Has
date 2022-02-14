package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String fileName = null;
        //fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String sFull = bufferedReader.readLine();
                String[] line = sFull.split(" ");
                StringBuilder builder = new StringBuilder();
                for (String s: line) {
                    final String str = s;
                    if (map.keySet().stream().anyMatch(i-> String.valueOf(i).equals(str) || String.valueOf(i).equals(str.replaceFirst("[!|.|,|?]{0,1}$", "")))) {
                        builder.append(
                                str.replaceFirst("\\d*", map.get(Integer.parseInt(
                                        str.replaceFirst("[!|.|,|?]{0,1}$", ""))
                                    ))   + " "
                        );
                    } else {
                        builder.append(str + " ");
                    }
                }
                System.out.println(builder);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
