package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean flag = true;
            String filename = null;
            while (flag) {
                filename = scanner.nextLine();
                try (FileInputStream stream = new FileInputStream(filename)) {
                    if (stream.available() < 1000) {
                        flag = false;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
