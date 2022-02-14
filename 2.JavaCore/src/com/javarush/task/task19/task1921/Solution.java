package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        //String fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
        String fileName = args[0] ; //"span"

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String[] line = bufferedReader.readLine().split(" ");
                String name = "";
                for (int i = 0; i < line.length - 3; ++i) {
                    name = name + " " + line[i];
                }
                Date date = (new SimpleDateFormat("dd.MM.yyyy")).parse(line[line.length-3] + "." + line[line.length-2] + "." + line[line.length-1]);
                PEOPLE.add(new Person(name.trim(), date));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        PEOPLE.forEach(person -> {
//            System.out.println(person.getName() + " " + person.getBirthDate());
//        });

    }
}
