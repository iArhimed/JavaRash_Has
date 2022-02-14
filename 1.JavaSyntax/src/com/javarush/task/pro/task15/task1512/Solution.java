package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();
        //напишите тут ваш код
        outputStream.reset();
        char[] chrs = result.toCharArray();
        for (int i = result.length()-1; i >= 0; --i) {
            printSomething(String.valueOf(chrs[i]));
        }
        System.out.println(outputStream.toString());
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}