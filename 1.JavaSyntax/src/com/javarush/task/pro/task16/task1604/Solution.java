package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1986, Calendar.DECEMBER, 20);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        String dayOfWeek;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 2:
                dayOfWeek = "Понедельник";
                break;
            case 3:
                dayOfWeek = "Вторник";
                break;
            case 4:
                dayOfWeek = "Среда";
                break;
            case 5:
                dayOfWeek = "Четверг";
                break;
            case 6:
                dayOfWeek = "Пятница";
                break;
            case 7:
                dayOfWeek = "Суббота";
                break;
            case 1:
                dayOfWeek = "Воскресенье";
                break;
            default:
                dayOfWeek = "Error";
        }
        //System.out.println(dayOfWeek);
        return dayOfWeek;
    }
}
