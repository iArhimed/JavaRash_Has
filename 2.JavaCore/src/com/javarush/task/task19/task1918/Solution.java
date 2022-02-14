package com.javarush.task.task19.task1918;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
//import org.jsoup.select.Elements;
import java.lang.String;


/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
//        fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
//        String teg = "span" ;            //для локального тестирования
        String teg = args[0] ; //"span"
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
             fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder str = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                char[] buf = new char[1024];
                int count = fileReader.read(buf, 0, 1024);
                str.append(buf, 0, count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Document doc = Jsoup.parse(str.toString()); // так не работает
        Document doc = Jsoup.parse(str.toString(), "", Parser.xmlParser());
        //Elements tegs = doc.getElementsByTag(teg); // так не работает
        Elements tegs = doc.select(teg);
        for (Element el: tegs) {
            System.out.println(el);
        }

        //ЭТО МОЕ РАБОЧЕЕ РЕШЕНИЕ, НО НЕ ПРИНИМАЕТ ВАЛИДАТОР
//        String fileName = null;
////        fileName = "b:\\aaa\\aaa.txt";   //для локального тестирования
////        String teg = "span" ;            //для локального тестирования
//        String teg = args[0] ; //"span"
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//             fileName = bufferedReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        StringBuilder str = new StringBuilder();
//        try (FileReader fileReader = new FileReader(fileName)) {
//            while (fileReader.ready()) {
//                char[] buf = new char[1024];
//                int count = fileReader.read(buf, 0, 1024);
//                str.append(buf, 0, count);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<Integer> begTegs = new ArrayList<>();
//        int offset = 0;
//        while (offset < str.length()) {
//            int tmp = str.indexOf("<" + teg, offset);
//            if (tmp < 0) break;
//            byte simb = (byte) str.substring(tmp + teg.length() + 1, tmp + teg.length() + 2).charAt(0);
//            if (simb == 62 || simb == 32 || simb == 13) {
//                begTegs.add(tmp);
//                offset = tmp + teg.length() + 2;
//            }
//        }
//
//        int level;
//        int n;
//        for (int i = 0; i < begTegs.size(); ++i) {
//            level = 1;
//            n = i;
//            offset = begTegs.get(i) + teg.length() + 2;
//            int endPos = 0;
//            do {
//                int tmp = str.indexOf("</" + teg + ">", offset);
//                if (tmp < 0) break;
//                offset = tmp + teg.length() + 3;
//                if (offset < endPos) {
//                    break;
//                } else {
//                    endPos = offset;
//                }
//                if (i == begTegs.size()-1) {
//                    //endPos = tmp + teg.length() + 3;
//                    break;
//                }
//                n++;
//                for (int j = n; j < begTegs.size(); j++) {
//                    if (begTegs.get(j) < tmp) {
//                        level++;
//                    } else {
//                        level--;
//                        break;
//                    }
//                }
//            } while (level > 0);
//            System.out.println(str.substring(begTegs.get(i), endPos));
 //       }

    }
}
