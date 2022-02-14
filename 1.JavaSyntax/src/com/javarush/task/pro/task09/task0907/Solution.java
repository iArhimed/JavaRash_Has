package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 15; // 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        //напишите тут ваш код
        int num_10 = decimalNumber;
        String hex = "";
        if (decimalNumber <= 0) return "";
        while(num_10 != 0) {
            int ost = num_10 % 16;
            hex = HEX.charAt(ost) + hex;
            num_10 = num_10 / 16;
        }
        return hex;
    }

    public static int toDecimal(String hexNumber) {
        //напишите тут ваш код
        if (hexNumber == null || hexNumber.equals("")) return 0;
        int num_10 = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            int inx = 0;
            for (int j = 0; j < 16; ++j) {
                if (hexNumber.charAt(i) == HEX.charAt(j)) {
                    inx = j;
                    break;
                }
            }
            num_10 = 16 * num_10 + inx;
        }
        return num_10;
    }
}
