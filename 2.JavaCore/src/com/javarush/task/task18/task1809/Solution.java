package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();
        int n = 0;
        int i = 0;
        byte[] buffer;

        try (FileInputStream in = new FileInputStream(file1);
             FileOutputStream out = new FileOutputStream(file2)) {
            n = in.available();
            buffer = new byte[n];
            while (in.available() > 0) {
                buffer[n - i -1] = (byte) in.read();
                ++i;
            }
            out.write(buffer, 0, n);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
