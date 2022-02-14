package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();
        //String file1 = "b:\\aaa\\aaa.txt";
        //String file2 = "b:\\aaa\\bbb.txt";


        List<String[]> slist = new ArrayList<>();
        List<Long[]> dlist = new ArrayList<>();

        try (FileReader stream1 = new FileReader(file1);
             BufferedReader reader = new BufferedReader(stream1);
             FileWriter stream2 = new FileWriter(file2);
             BufferedWriter writer = new BufferedWriter(stream2)) {

            while (reader.ready()) {
                slist.add(reader.readLine().split(" "));
            }

            for (int i = 0; i < slist.size(); ++i) {
                Long[] dTmp = new Long[slist.get(i).length];
                for (int j = 0; j < slist.get(i).length; ++j) {
                    dTmp[j] = Math.round(Double.parseDouble(slist.get(i)[j]));
                }
                dlist.add(dTmp);
            }

            for (int i = 0; i < dlist.size(); ++i) {
                String sTmp = "";
                for (int j = 0; j < dlist.get(i).length; ++j) {
                    if (j == 0) {
                        sTmp = String.valueOf(dlist.get(i)[j]);
                    } else {
                        sTmp = sTmp + " " + String.valueOf(dlist.get(i)[j]);
                    }
                }
                if (i != 0) {
                    writer.newLine();
                }
                writer.write(sTmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
