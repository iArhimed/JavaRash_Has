package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        scanner.close();

        try (FileOutputStream stream1 = new FileOutputStream(file1, true);
             FileInputStream stream2 = new FileInputStream(file2);
             FileInputStream stream3 = new FileInputStream(file3)) {

            while (stream2.available() > 0) {
                byte[] buffer = new byte[1024];
                int count = stream2.read(buffer);
                stream1.write(buffer, 0, count);
            }

            while (stream3.available() > 0) {
                byte[] buffer = new byte[1024];
                int count = stream3.read(buffer);
                stream1.write(buffer, 0, count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
