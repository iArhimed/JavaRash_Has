package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

//    static {
//        words.add("А");
//        words.add("Б");
//        words.add("В");
//    }

    public static void main(String[] args) {
        String fileName = null;
        //String fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String sFull = bufferedReader.readLine();
                String[] line = sFull.split(" ");
                int n = 0;
                for (String str: line) {
                    final String sfin = str;
                    n += words.stream().filter(s -> s.equals(sfin)).count();
                    if (n > 2) break;
                }
                if (n == 2) list.add(sFull);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }
}
