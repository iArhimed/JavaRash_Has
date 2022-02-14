package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
//        String file1 = "b:\\aaa\\aaa.txt";   //для локального тестирования
//        String file2 = "b:\\aaa\\bbb.txt";   //для локального тестирования
        String file1 = args[0] ;
        String file2 = args[1] ;

        try (FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2);
             BufferedReader reader = new BufferedReader(fileReader);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String s: line) {
                    if (s.length() > 6) {
                        builder.append(s + ",");
                        //writer.write(s + " ");
                    }
                }
            }
            builder.replace(builder.length()-1, builder.length(), "");
            writer.write(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
