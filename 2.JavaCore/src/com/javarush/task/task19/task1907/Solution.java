package com.javarush.task.task19.task1907;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        int n = 0;
        String file1 = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder str = new StringBuilder("");
        try (FileReader fileReader = new FileReader(file1)) {

            int count;
            char[] buf = new char[1024];
            while (fileReader.ready()) {
                count = fileReader.read(buf, 0, 1024);
                for (int i = 0; i < count; ++i) {
                    str.append(buf[i]);
                }
            }

            String[] full = str.toString().split("\\W");
            for (String w: full) {
                if (w.equals("world")) ++n;
                //System.out.println(w);
            }

//            int ofset = 0;
//            int len = str.length() - 4;
//            while (true) {
//                ofset = str.indexOf("world", ofset);
//                if (ofset > len || ofset <= 0 ) break;
//                ofset += 5;
//                ++n;
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(n);
    }
}
