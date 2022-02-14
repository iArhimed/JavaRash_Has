package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        try (InputStream inputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            while (bufferedReader.ready()) {

                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}