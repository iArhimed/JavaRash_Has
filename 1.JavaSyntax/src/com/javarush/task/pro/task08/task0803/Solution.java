package com.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        //напишите тут ваш код
        int n_min = ints[0];
        for (int i = 1; i < 10; ++i) {
            n_min = Math.min(n_min, ints[i]);
        }
        return n_min;
    }

    public static int[] getArrayOfTenElements() {
        //напишите тут ваш код
        int [] arr = new int[10];
        Scanner cons = new Scanner(System.in);
        for (int i = 0; i < 10; ++i) {
            arr[i] = cons.nextInt();
        }
        return arr;
    }
}
