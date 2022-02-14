package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {

        //String file111 = "b:\\aaa\\aaa.txt";
        String file111 = args[0];
        Map<Character, Integer> map = new HashMap<>();

        try (FileReader stream1 = new FileReader(file111)) {
            final Character[] ch = new Character[1];
            while (stream1.ready()) {
                ch[0] = Character.valueOf((char) stream1.read());
                if ( map.keySet().stream().filter(x -> x == ch[0]).count() == 0 ) {
                    map.put(ch[0], 1);
                } else {
                    map.put(ch[0], map.get(ch[0]) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Character> arrayList = new ArrayList<> (map.keySet());
        Collections.sort(arrayList);

        for (Character ch: arrayList) {
            System.out.println(ch + " " + map.get(ch));
        }

    }
}
