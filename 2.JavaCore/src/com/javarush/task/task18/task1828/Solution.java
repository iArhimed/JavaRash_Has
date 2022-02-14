package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        //String[] args =  {"-d", "198479"};

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        if (args.length == 0) return;

        String flag = args[0];
        List<String> listLines = new ArrayList<>();

        String id = args[1];
        String productName = null;
        String price = null;
        String quantity = null;
        String newLine = "";

        if (flag.equals("-u")) {
            productName = args[2];  //productName - название товара, 30 символов.
            price = args[3];        //price - цена, 8 символов.
            quantity = args[4];     //quantity - количество, 4 символа.
            newLine = (id + "        ").substring(0, 8) +
                    (productName + "                              ").substring(0, 30) +
                    (price + "        ").substring(0, 8) +
                    (quantity + "    ").substring(0, 4);
        } //else if (flag.equals("-d")) {}

        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            Integer curId;
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                curId = Integer.parseInt(line.substring(0, 8).trim());
                if (curId == Integer.parseInt(id)) {
                    if (flag.equals("-u")) listLines.add(newLine);
                } else {
                    listLines.add(line);
                }
            }
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            String line;
            for (int i = 0; i < listLines.size(); ++i) {
                if (i != 0) {
                    line = "\n" + listLines.get(i);
                } else {
                    line = listLines.get(i);
                }
                fileWriter.write(line);
            }
        }
    }
}
