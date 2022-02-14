package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        int n = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.available() > 0) {
                char ch = (char) fileInputStream.read();
                if (ch == (char) ',') n++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
}
