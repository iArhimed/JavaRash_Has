package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        FileInputStream fileInputStream = new FileInputStream("b:\\aaa\\aaa.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("b:\\aaa\\aaa.txt");

        Solution solution = new Solution(33);
        solution.string = "Test!!!";
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();
        fileOutputStream.close();

        Solution solution2;
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        fileInputStream.close();
        System.out.println(solution2.string);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution() {
    }

    @Override
    public String toString() {
        return this.string;
    }
}
