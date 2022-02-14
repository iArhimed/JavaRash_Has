package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String filename = scanner.nextLine();
            while (!filename.equals("exit")) {
                new ReadThread(filename).start();
                filename = scanner.nextLine();
            }
        }
        //resultMap.forEach((s, i) -> System.out.println(s + " = " + i));
    }

    public static class ReadThread extends Thread {
        private String filename;
        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            Integer[] range = new Integer[256];
            Arrays.fill(range, 0);

            try (FileInputStream inputStream = new FileInputStream(filename)) {
                int tmp = 0;
                while (inputStream.available() > 0) {
                    tmp = inputStream.read();
                    range[tmp] = range[tmp] + 1;
                }
                Integer countMax = Arrays.stream(range).max(Integer::compareTo).get();
                Integer numByte = 0;
                for (int i=0; i < range.length; ++i) {
                    if (range[i] == countMax) {
                        numByte = i;
                        break;
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(filename, numByte);
                }
                //System.out.println(filename + " " + numByte);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
