package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        //String[] args =  {"x", "-e", "B:\\aaa\\aaa.txt", "B:\\aaa\\bbb.txt"};

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        if (args.length == 0) return;

        String flag = args[0];
        if (flag.equals("-c")) {  //-c - флаг, который означает добавления товара.
            String productName = args[1];  //productName - название товара, 30 символов.
            String price = args[2];        //price - цена, 8 символов.
            String quantity = args[3];     //quantity - количество, 4 символа.
            Integer newId = 0;
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader reader = new BufferedReader(fileReader)) {
                Integer curId;
                String line;
                while (reader.ready()) {
                    line = reader.readLine();
                    curId = Integer.parseInt(line.substring(0, 8).trim());
                    if (curId > newId) newId = curId;
                }
            }
            ++newId;
            String newLine = "\n" + (String.valueOf(newId) + "        ").substring(0, 8) +
                             (productName + "                              ").substring(0, 30) +
                             (price + "        ").substring(0, 8) +
                             (quantity + "    ").substring(0, 4);

            try (FileWriter fileWriter = new FileWriter(file, true)) {
                fileWriter.write(newLine);
            }
        }
    }
}
