package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        //fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                System.out.println(builder.append(reader.readLine()).reverse());
                builder = new StringBuilder();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
