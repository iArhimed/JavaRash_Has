package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        //напишите тут ваш код
        if (decimalNumber <= 0) return 0;
        final int VAL_8 = 8;
        final int VAL_10 = 10;
        int i = 0;
        int num8 = 0;
        int num_10 = decimalNumber;
        while (num_10 != 0) {
            num8 = (int) (num8 + (num_10 % VAL_8) * Math.pow(VAL_10, i));
            num_10 /= VAL_8;
            ++i;
        }
        return num8;
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        if (octalNumber <= 0) return 0;
        final int VAL_8 = 8;
        final int VAL_10 = 10;
        int i = 0;
        int num8 = octalNumber;
        int num_10 = 0;
        while (num8 != 0) {
            num_10 = (int) (num_10 + (num8 % VAL_10) * Math.pow(VAL_8, i));
            num8 /= VAL_10;
            ++i;
        }
        return num_10;
    }
}
