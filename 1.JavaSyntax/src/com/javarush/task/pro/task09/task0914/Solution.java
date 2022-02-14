package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        //напишите тут ваш код
        int start_index_jdk = path.indexOf("jdk");
        int end_index_jdk = path.indexOf("/", start_index_jdk);
        String repl_str = path.substring(start_index_jdk, end_index_jdk);
        return path.replaceFirst(repl_str,jdk);
    }
}
