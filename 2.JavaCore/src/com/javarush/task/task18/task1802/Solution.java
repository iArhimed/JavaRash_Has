package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new Scanner(System.in).nextLine();
        FileInputStream inputStream = new FileInputStream(filename);
        int min = 0;
        int cur;
        boolean first = true;
        while (inputStream.available() > 0){
            if (first) {
                min = inputStream.read();
            } else {
                cur = inputStream.read();
                if (min > cur) {
                    min = cur;
                }
            }
        }
        inputStream.close();
        System.out.println(min);
    }
}
