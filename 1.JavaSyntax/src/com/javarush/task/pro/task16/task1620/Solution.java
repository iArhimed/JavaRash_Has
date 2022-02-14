package com.javarush.task.pro.task16.task1620;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/* 
Еще один простой шаблон
*/

public class Solution {

    static ZonedDateTime zonedDateTime = ZonedDateTime.now();

    public static void main(String[] args) {
        //напишите тут ваш код
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("e d.M.yy HH:mm:ss.n VV");
        String locDate = frm.format( zonedDateTime );
        System.out.println(locDate);
    }
}
