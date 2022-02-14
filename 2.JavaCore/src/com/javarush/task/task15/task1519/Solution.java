package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String val = scanner.nextLine();
                if (val.equals("exit")) break;
                if (val.indexOf(".") >= 0) {
                    try {
                        print(Double.parseDouble(val));
                    } catch (Exception e) {
                        print(val);
                    }
                } else if (val.chars().allMatch(Character::isDigit)) { //проверяем что все символы - числа
                    if (Integer.parseInt(val) > 0 && Integer.parseInt(val) < 128) {
                        print(Short.valueOf(val));
                    } else {
                        try {
                            print(Integer.valueOf(val));
                        } catch (Exception e) {
                            print(val);
                        }
                    }
                } else {
                    try {
                        print(Integer.valueOf(val));
                    } catch (Exception e) {
                        print(val);
                    }
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
