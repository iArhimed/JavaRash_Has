package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date("Jan 01 1986");

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        String str = (date.toString()).substring(0, 3);
        String dayOfWeek;
        switch (str) {
            case "Mon":
                dayOfWeek = "Понедельник";
                break;
            case "Tue":
                dayOfWeek = "Вторник";
                break;
            case "Wed":
                dayOfWeek = "Среда";
                break;
            case "Thu":
                dayOfWeek = "Четверг";
                break;
            case "Fri":
                dayOfWeek = "Пятница";
                break;
            case "Sat":
                dayOfWeek = "Суббота";
                break;
            case "Sun":
                dayOfWeek = "Воскресенье";
                break;
            default:
                dayOfWeek = "Error";
        }
        return dayOfWeek;
    }
}
