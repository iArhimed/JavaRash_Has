package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        String next = null;

        try (OutputStream outputStream = new FileOutputStream(file);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

            do {
                next = scanner.nextLine();
                bufferedWriter.write(next);
                if (!next.equals("exit")) {
                    bufferedWriter.newLine();
                }
            } while (!next.equals("exit"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
