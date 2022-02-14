package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
Самые редкие байты
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

        int[] rated = new int[intArr.size()];
        for (int i = 0; i < rated.length; ++i) {
            int tmp = intArr.get(i);
            rated[i] = Collections.frequency(intArr, tmp);
        }

        boolean fist = true;
        int minRated = Arrays.stream(rated).min().getAsInt();
        for (int i = 0; i < intArr.size(); ++i) {
            if (rated[i] == minRated) {
                if (fist) {
                    System.out.print(intArr.get(i));
                    fist = false;
                } else {
                    System.out.print(" " + intArr.get(i));
                }
            }
        }
    }
}
