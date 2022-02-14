package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишите тут ваш код
        if (decimalNumber <= 0) return "";
        int num_10 = decimalNumber;
        String num_2 = "";
        String tmp = "";
        while(num_10 != 0) {
            tmp = Integer.toString (num_10 % 2);
            num_2 = tmp + num_2;
            num_10 = num_10 / 2;
        }
        return num_2;
    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.equals("")) return 0;
        //char[] bb = binaryNumber.toCharArray();
        int num_10 = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            char a = binaryNumber.charAt(binaryNumber.length() - i -1);
            int b = (int) Math.pow(2, i);
            num_10 = num_10 + Character.getNumericValue(a) * b;
        }

        return num_10;
    }
}
