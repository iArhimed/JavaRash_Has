package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {

        Map<Integer, String> files = new HashMap<>();
        String nameFullFile;

        try (Scanner scanner = new Scanner(System.in)) {
            String filename = scanner.nextLine();
            nameFullFile = filename;
            while (!filename.equals("end")) {
                int len = filename.split("\\.").length;
                files.put(Integer.parseInt(filename.split("\\.")[len - 1].substring(4)), filename);
                filename = scanner.nextLine();
            }
        }
        char[] arrFile = nameFullFile.toCharArray();
        for (int i = arrFile.length-1; i > -1; --i) {
            if (arrFile[i] == '.') {
                nameFullFile = nameFullFile.substring(0, i);
                break;
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(nameFullFile, true)) {

            List<Integer> parts = new ArrayList<Integer>(files.keySet());
            Collections.sort(parts);
            for (Integer part: parts) {
                try (FileInputStream inputStream = new FileInputStream(files.get(part))) {

                    while (inputStream.available() > 0) {
                        byte[] buffer = new byte[1024];
                        int count = inputStream.read(buffer);
                        outputStream.write(buffer, 0, count);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
