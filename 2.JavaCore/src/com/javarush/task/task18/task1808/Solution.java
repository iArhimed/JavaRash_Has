package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        scanner.close();
        int n = 0;
        int n1 = 0;
        int n2 = 0;

        try (FileInputStream stream1 = new FileInputStream(file1);
             FileOutputStream stream2 = new FileOutputStream(file2);
             FileOutputStream stream3 = new FileOutputStream(file3)) {
            n = stream1.available();
            if (n % 2 != 0) {
                n1 = n / 2 + 1;
            } else {
                n1 = n / 2;
            }
            n2 = n - n1;

            if (stream1.available() > 0) {
                byte[] buffer = new byte[n1];
                int count = stream1.read(buffer);
                stream2.write(buffer, 0, count);
                buffer = null;

                buffer = new byte[n2];
                count = stream1.read(buffer);
                stream3.write(buffer, 0, count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
