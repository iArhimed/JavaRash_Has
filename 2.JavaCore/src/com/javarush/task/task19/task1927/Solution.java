package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();
        StringBuilder builder = new StringBuilder();
        String[] line = result.split(System.lineSeparator());
        int i = 1;
        for (String el: line) {
            if (i == 1) {
                builder.append(el);
            } else {
                builder.append(System.lineSeparator() + el);
                if (i % 2 == 0) {
                    builder.append(System.lineSeparator() + "JavaRush - курсы Java онлайн");
                }
            }
            ++i;
        }
        outputStream.reset();
        outputStream.write(builder.toString().getBytes());
        System.setOut(consoleStream);

        System.out.println(builder);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
