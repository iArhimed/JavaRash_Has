package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();
        byte[] buffer1;
        int count1;

        try (FileInputStream stream1 = new FileInputStream(file1)) {
            buffer1 = new byte[stream1.available()];
            count1 = stream1.read(buffer1);

            byte[] buffer2;
            int count2;
            try (FileOutputStream stream11 = new FileOutputStream(file1);
                 FileInputStream stream2 = new FileInputStream(file2)) {

                buffer2 = new byte[stream2.available()];
                count2 = stream2.read(buffer2);

                stream11.write(buffer2, 0, count2);
                stream11.write(buffer1, 0, count1);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
