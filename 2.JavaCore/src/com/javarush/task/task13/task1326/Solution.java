package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*  //R.A.M.
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        List<String> list = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader) ) {

            while (reader.ready()){
                list.add(reader.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        list.stream().map(x-> Integer.parseInt(x)).filter(y-> y % 2 == 0).sorted().forEach(System.out::println);

    }
}
