package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.charset.Charset;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private PrintStream printStream;


    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }


    public static void main(String[] args) {
        FileConsoleWriter test1 = null;
        try {
            test1 = new FileConsoleWriter("b:\\aaa\\aaa.txt");
            char[] cbuf = new char[]{'f', 'v', 's', 'j'};
            test1.write("55555");
            test1.write("77777", 1,3);
            test1.write(cbuf);
            test1.write(cbuf, 1, 2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                test1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        fileWriter.flush();
        System.out.print((new String(cbuf)).substring(off, off + len));
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        fileWriter.flush();
        System.out.print(Integer.toString(c));
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        fileWriter.flush();
        System.out.print(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        fileWriter.flush();
        System.out.print(str.substring(off, off + len));
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        fileWriter.flush();
        System.out.print(new String(cbuf));
    }
    public void close() throws IOException {
        this.fileWriter.close();
    }
}
