package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Alex", 3.5);
        grades.put("Ben", 4.5);
        grades.put("Sofia", 3.7);
        grades.put("Jon", 5.0);
        grades.put("Maria", 3.1);
    }
}
