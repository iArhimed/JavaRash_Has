package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);) {
            boolean is_path = true;
            while (is_path) {
                Path path = Path.of(scanner.nextLine());
                if (Files.isRegularFile(path)) {
                    System.out.println(path.toString() + THIS_IS_FILE);
                } else if (Files.isDirectory(path)) {
                    System.out.println(path.toString() + THIS_IS_DIR);
                } else {
                    is_path = false;
                }
            }
        }
    }
}

