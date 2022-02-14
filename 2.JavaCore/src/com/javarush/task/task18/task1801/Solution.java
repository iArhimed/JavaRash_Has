package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new Scanner(System.in).nextLine();
        FileInputStream inputStream = new FileInputStream(filename);
        int max = 0;
        int cur = 0;
        while (inputStream.available() > 0){
            cur = inputStream.read();
            if (max < cur) {
                max = cur;
            }
        }
        inputStream.close();
        System.out.println(max);
    }
}
