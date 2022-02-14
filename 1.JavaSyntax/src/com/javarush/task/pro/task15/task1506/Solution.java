package com.javarush.task.pro.task15.task1506;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in)) {
            var reader = Files.readAllLines(Paths.get(scanner.nextLine()));
            for (var el: reader) {
                System.out.println(((el.replace(".", "")).replace(",", "")).replace(" ", ""));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

