package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] result = byteArrayOutputStream.toString().split(" ");
        System.setOut(printStream);
        int ans = 0;
        switch (result[1]) {
            case "+":
                ans = Integer.parseInt(result[0]) + Integer.parseInt(result[2]);
                break;
            case "-":
                ans = Integer.parseInt(result[0]) - Integer.parseInt(result[2]);
                break;
            case "*":
                ans = Integer.parseInt(result[0]) * Integer.parseInt(result[2]);
                break;
            default:
                System.out.println("Uppss!");
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + ans);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

