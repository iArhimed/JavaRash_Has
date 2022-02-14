package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {

        String file1 = null;
        String file2 = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2)) {

            int n = 2;
            int tmp;
            while (fileReader.ready()) {
                n++;
                tmp =  fileReader.read();
                if (n % 2 == 0) {
                    fileWriter.write(tmp);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
