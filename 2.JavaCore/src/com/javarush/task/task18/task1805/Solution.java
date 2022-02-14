package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new Scanner(System.in).nextLine();
        FileInputStream inputStream = new FileInputStream(filename);
        ArrayList<Integer> intArr = new ArrayList<>();
        while (inputStream.available() > 0){
             intArr.add(inputStream.read());
        }
        inputStream.close();
        Integer[] sortArr = intArr.stream().distinct().sorted().toArray(Integer[]::new);

        boolean fist = true;
        for (int i = 0; i < sortArr.length; ++i) {
            if (fist) {
                System.out.print(sortArr[i]);
                fist = false;
            } else {
                System.out.print(" " + sortArr[i]);
            }
        }
    }
}
