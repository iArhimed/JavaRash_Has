package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String file1 = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
        } catch (IOException e) {e.printStackTrace();}

        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();

        try (FileOutputStream outputStream = new FileOutputStream(file1)) {
            outputStream.write(result.getBytes());
        } catch (IOException e) {e.printStackTrace();}

        System.setOut(printStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

