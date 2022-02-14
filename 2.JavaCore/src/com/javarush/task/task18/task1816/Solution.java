package com.javarush.task.task18.task1816;

import java.io.CharArrayReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        String file = args[0];
        int n = 0;
        try (FileReader fileReader = new FileReader(file)) {
            char smb;
            while (fileReader.ready()) {
                smb = (char) fileReader.read();
                if (smb >= 'A' && smb <= 'Z' || smb >= 'a' && smb <= 'z') ++n;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
}
