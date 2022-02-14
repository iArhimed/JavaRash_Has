package com.javarush.task.pro.task16.task1619;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/* 
Простой шаблон
*/

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String[] args) {
        //напишите тут ваш код
        //localDateTime = LocalDateTime.of(2020, Month.MARCH, 19, 5, 4);
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин");
        String locDate = frm.format( localDateTime );
        System.out.println(locDate);
    }
}
//19.03.2020г. 5ч.4мин
//19.03.2020г. 5ч.4мин