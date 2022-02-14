package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String filename1 = null;
        String filename2 = null;
        try (Scanner scanner = new Scanner(System.in)) {
            filename1 = scanner.nextLine();
            filename2 = scanner.nextLine();
        }
        readToArray(filename1, allLines);
        readToArray(filename2, forRemoveLines);

        List<String> copyArr = new ArrayList<String>(allLines);
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            //e.printStackTrace();
            allLines = copyArr;
        }
    }

    private static void readToArray(String filename, List<String> list) {
        try (InputStream inputStream = new FileInputStream(filename);
             InputStreamReader streamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(streamReader))
        {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        List<String> newList = null;
        if (forRemoveLines.stream().allMatch(line-> allLines.stream().anyMatch(l2-> l2.equals(line)))) {
            forRemoveLines.stream().forEach(s-> {
                allLines.remove(s);
            });
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
