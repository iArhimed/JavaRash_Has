package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new Scanner(System.in).nextLine();
        FileInputStream inputStream = new FileInputStream(filename);
        ArrayList<Integer> intArr = new ArrayList<>();
        int[] rated = new int[inputStream.available()];
        int index = 0;
        int cur;
        while (inputStream.available() > 0){
            cur = inputStream.read();
            intArr.add(cur);
            int count = 0;
            for (int x : intArr) {
                if (x == cur) {
                    count++;
                }
            }
            rated[index] = count;
            ++index;
        }
        inputStream.close();
        boolean fist = true;
        int maxRated = Arrays.stream(rated).max().getAsInt();
        for (int i = 0; i < rated.length; ++i) {
            if (rated[i] == maxRated) {
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
