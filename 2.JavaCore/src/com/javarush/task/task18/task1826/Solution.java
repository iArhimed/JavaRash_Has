package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        //String[] args =  {"x", "-e", "B:\\aaa\\aaa.txt", "B:\\aaa\\bbb.txt"};

        String p = args[0];
        String fIn = args[1];
        String fOut = args[2];
        //Scanner scanner = new Scanner(System.in);
        //fIn = scanner.nextLine();
        //fOut = scanner.nextLine();
        //scanner.close();

        int k = 0;
        int i;
        //byte[] buffer;

        if (p.equals("-e")) {
            k = 1;
        } else if (p.equals("-d")) {
            k = -1;
        }

        try (FileInputStream in = new FileInputStream(fIn);
             FileOutputStream out = new FileOutputStream(fOut)) {

            //n = in.available();
            //buffer = new byte[n];
            while (in.available() > 0) {
                i = in.read();
                out.write(i + k);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
