package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.equals("")) return "";
        for (int i = 0; i < binaryNumber.length(); ++i) {
            if (binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1') {
                return "";
            }
        }
        final String[] b = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111",};
        final String[] h = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f",};
        String hex = "";
        String bnum = binaryNumber;
        int len = binaryNumber.length();
        if (len % 4 == 3) {
            bnum = "0" + bnum;
        } else if (len % 4 == 2) {
            bnum = "00" + bnum;
        } else if (len % 4 == 1) {
            bnum = "000" + bnum;
        }
        len = bnum.length();
        String[] simb_code = new String[(len / 4)];
        for (int i = 0; i < len; i += 4){
            int idx = i / 4;
            simb_code[idx] = (bnum.substring(i, i + 4));
            for (int j = 0; j < 16; ++j) {
                if (simb_code[idx].equals(b[j])) {
                    hex += h[j];
                }
            }
        }
        return hex;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.equals("")) return "";
        final String[] b = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111",};
        final char[] h = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f',};
        String hex = hexNumber;
        String bnum = "";
        for (int i = 0; i < hex.length(); ++i){
            char simb = hex.charAt(i);
            boolean chk = false;
            for (int j = 0; j < 16; ++j) {
                if (simb ==  h[j]) {
                    bnum += b[j];
                    chk = true;
                    break;
                }
            }
            if (!chk) return "";
        }
        return bnum;
    }
}
