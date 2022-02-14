package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        //String file1 = "b:\\aaa\\aaa.txt";   //для локального тестирования
        //String file2 = "b:\\aaa\\bbb.txt";   //для локального тестирования
        String file1 = args[0] ;
        String file2 = args[1] ;

        try (FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2);
             BufferedReader reader = new BufferedReader(fileReader);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                //boolean first = true;
                for (String s: line) {
                    if (s.matches(".*\\d.*")) {
//                        if (first) {
//                            writer.write(s);
//                            first = false;
//                        } else {
//                            writer.write(" " + s);
//                        }
                        writer.write(s + " ");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
