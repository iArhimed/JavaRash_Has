package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate cur = LocalDate.now();
        return cur;
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate date = LocalDate.of(2020, 9, 12);
        return date;
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        return LocalDate.ofYearDay(2020,256);
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        LocalDate date = LocalDate.ofEpochDay(18517);
        return date;
    }
}
