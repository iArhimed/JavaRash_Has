package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        String str0 = url.substring(url.indexOf("?") + 1);
        String[] str1 = str0.split("&");
        List<String> params = new ArrayList<>();
        List<String> objs = new ArrayList<>();
        for (String s: str1) {
            String key = s.substring(0, (s.indexOf("=") > -1) ? s.indexOf("=") : s.length());
            params.add(key);
            if (key.equals("obj")) {
                String val = s.substring(s.indexOf("=")+1);
                objs.add(val);
            }
        }
        for (int i=0; i < params.size(); ++i) {
            if (i == 0) {
                System.out.print(params.get(i));
            } else if (i == params.size() - 1) {
                System.out.print(" " + params.get(i) + "\n");
            } else {
                System.out.print(" " + params.get(i));
            }
        }
        if (objs.size() > 0) {
            for (String o: objs) {
                if (isNumeric(o)) {
                    alert(Double.parseDouble(o));
                } else {
                    alert(o);
                }
            }
        }
        //objs.stream().forEach(System.out::println);
    }

    public static boolean isNumeric (String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
