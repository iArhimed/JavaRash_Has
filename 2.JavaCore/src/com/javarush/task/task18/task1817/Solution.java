package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        String file = args[0];
        //String file = "b:\\aaa\\aaa.txt";

        int n = 0;
        int s = 0;
        try (FileReader fileReader = new FileReader(file)) {
            char smb;
            while (fileReader.ready()) {
                smb = (char) fileReader.read();
                if (smb == ' ') ++s;
                ++n;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double d = Math.round(((double) s / (double) n) * 10000) / 100.0;
        System.out.println(d);
    }
}
