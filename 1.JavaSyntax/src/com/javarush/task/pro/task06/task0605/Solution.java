package com.javarush.task.pro.task06.task0605;

/*
Правильный порядок
*/

public class Solution {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }

    public static void reverseArray(int[] array) {
        //напишите тут ваш код
        int n = array.length;
        int tmp;
        for (int i = 0; i < (n / 2); ++i) {
            tmp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1 ] = tmp;
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
