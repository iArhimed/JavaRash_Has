package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    //напишите тут ваш код
    public static int min(int x1, int x2) {
        return Math.min(x1,x2);
    };
    public static int min(int x1, int x2, int x3) {
        return Math.min(min(x1,x2) ,x3);
    };
    public static int min(int x1, int x2, int x3, int x4) {
        return Math.min(min(x1,x2, x3) ,x4);
    };
    public static int min(int x1, int x2, int x3, int x4, int x5) {
        return Math.min(min(x1,x2,x3,x4) ,x5);
    };
    public static int max(int x1, int x2 ) {
        return Math.max(x1,x2);
    };
    public static int max(int x1, int x2, int x3) {
        return Math.max(max(x1,x2) ,x3);
    };
    public static int max(int x1, int x2, int x3, int x4) {
        return Math.max(max(x1,x2, x3) ,x4);
    };
    public static int max(int x1, int x2, int x3, int x4, int x5) {
        return Math.max(max(x1,x2,x3,x4) ,x5);
    };
}
