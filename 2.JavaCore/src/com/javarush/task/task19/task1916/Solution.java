package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {

        String file1 = null;
        String file2 = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            String str11 = null;
            String str21 = null;
            String str12 = null;
            String str22 = null;
            while (true) {
                if (reader1.ready() && str11 == null) str11 = reader1.readLine();
                if (reader2.ready()) str21 = reader2.readLine();
                if (lines.size() > 0 ) {
                    Type type = lines.get(lines.size()-1).type;
                    if (type == Type.ADDED || type == Type.REMOVED) {
                        lines.add(new LineItem(Type.SAME, str11));
                        str11 = null;
                        str21 = null;
                        continue;
                    }
                }
                if (str11 == null) {
                    lines.add(new LineItem(Type.ADDED, str21));
                } else if (str21 == null) {
                    lines.add(new LineItem(Type.REMOVED, str11));
                } else if (str11.equals(str21)) {
                    lines.add(new LineItem(Type.SAME, str11));
                } else {
                    if (reader1.ready()) str12 = reader1.readLine();
                    if (str12.equals(str21)) {
                        lines.add(new LineItem(Type.REMOVED, str11));
                        lines.add(new LineItem(Type.SAME, str12));
                    } else {
                        lines.add(new LineItem(Type.ADDED, str21));
                        if (reader2.ready()) str22 = reader2.readLine();
                        lines.add(new LineItem(Type.SAME, str22));
                        str11 = str12;
                        str21 = null;
                        str12 = null;
                        str22 = null;
                        continue;
                    }
                }

                if ( !(reader1.ready() || reader2.ready()) ) {
                    break;
                }
                str11 = null;
                str21 = null;
                str12 = null;
                str22 = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (LineItem el: lines) {
//            System.out.println(el.type + " " + el.line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
