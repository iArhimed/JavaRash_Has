package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        firstFileName = (new Scanner(System.in)).nextLine();
        secondFileName = (new Scanner(System.in)).nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private FileReader fileReader = null;
        private String content = "";

        @Override
        public void run() {
            String str = "";
            String space = "";
            try (BufferedReader reader = new BufferedReader(fileReader);) {
                while (reader.ready()) {
                    str = str + space + reader.readLine();
                    if (space.equals("")) space = " ";
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            content = str;
        }

        @Override
        public void setFileName(String fullFileName) {
            try {
                fileReader = new FileReader(fullFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            return content;
        }
    }
}
