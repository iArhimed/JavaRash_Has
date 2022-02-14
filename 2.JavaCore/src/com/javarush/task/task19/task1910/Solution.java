package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2))) {

            String out;
            StringBuilder str = new StringBuilder("");
            int count;
            char[] buf = new char[1024];


            while (bufferedReader.ready()) {
                count = bufferedReader.read(buf, 0, 1024);
                for (int i = 0; i < count; ++i) {
                    str.append(buf[i]);
                }
            }
            out =  str.toString().replaceAll("[^a-zA-ZА-Яа-я0-9\\s]", "");

            bufferedWriter.write(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
