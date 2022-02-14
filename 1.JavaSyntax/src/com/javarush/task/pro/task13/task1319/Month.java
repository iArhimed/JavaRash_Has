package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код
    public static Month[] getWinterMonths() {
        Month[] list = new Month[]{DECEMBER, JANUARY, FEBRUARY};
        return list;
    }

    public static Month[] getSpringMonths() {
        Month[] list = new Month[]{MARCH, APRIL, MAY};
        return list;
    }

    public static Month[] getSummerMonths() {
        Month[] list = new Month[]{JUNE, JULY, AUGUST};
        return list;
    }

    public static Month[] getAutumnMonths() {
        Month[] list = new Month[]{SEPTEMBER, OCTOBER, NOVEMBER};
        return list;
    }
}
