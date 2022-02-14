package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean flag = true;
            while (flag) {
                String filename = scanner.nextLine();
                try (FileInputStream inputStream = new FileInputStream(filename)) {
                    //ничего не делаем
                } catch (FileNotFoundException e) {
                    System.out.println(filename);
                    flag = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
