package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        String id = args[0];
        //String id = "195";
        //String file = "b:\\aaa\\aaa.txt";
        String line = null;
        List<String[]> slist = new ArrayList<>();

        try (FileReader stream = new FileReader(file);
             BufferedReader reader = new BufferedReader(stream)) {

            int n = 0;
            while (reader.ready()) {
                line = reader.readLine();
                slist.add(line.split(" "));
                if (slist.get(n)[0].equals(id)) break;
                ++n;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(line);
    }
}
