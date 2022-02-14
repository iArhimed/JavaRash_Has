package com.javarush.task.pro.task15.task1504;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        //String src = "c:\\aaa.txt";
        //String dest = "c:\\bbb.txt";
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String dest = scanner.nextLine();
        scanner.close();
        //System.out.println(src);
        //System.out.println(dest);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = Files.newInputStream(Paths.get(src));
            output = Files.newOutputStream(Paths.get(dest));
            byte[] buffer = input.readAllBytes();
            //byte[] buffer = input.readAllBytes();
            for (int i = 0; i < buffer.length; i += 2) {
                if (i + 1 == buffer.length) {
                    output.write(buffer, i, 1);
                } else {
                    output.write(buffer, i+1, 1);
                    output.write(buffer, i, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) input.close();
            if (output != null) output.close();
        }
    }
}

