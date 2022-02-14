package com.javarush.task.pro.task16.task1602;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Подчищаем хвосты
*/

public class Solution {

    public static void main(String[] args) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(new Date(2015, 12, 25, 20, 40));
        dateList.add(new Date("July 20, 1969"));
        dateList.add(new Date(1989, 11, 9));
        dateList.add(new Date("January 1, 2000"));
        //Должно быть 25 декабря 2015 года, но на самом деле это другая дата.
        //Можно посмотреть вывод в консоль для этой даты - new Date(2015, 12, 25, 20, 40).

        System.out.println("before fixes:");
        dateList.forEach(System.out::println);

        fixDate(dateList);

        System.out.println("after fixes:");
        dateList.forEach(System.out::println);
    }

    static void fixDate(List<Date> brokenDates) {
        //напишите тут ваш код
        Date curDate = new Date();
        for (Date date: brokenDates) {
            if (curDate.before(date)){
                //System.out.println(date.toString());
                var year = date.getYear();
                //if (year > 1900) date.setYear(year - 1900);
                var month = date.getMonth();
                if (month > 11) {
                    date.setMonth(month - 1);
                    date.setYear(year - 1900);
                } else if (month == 0){
                    date.setMonth(11);
                    date.setYear(year - 1901);
                } else {
                    date.setMonth(month - 1);
                    date.setYear(year - 1900);
                }
            }
        }
    }
}
