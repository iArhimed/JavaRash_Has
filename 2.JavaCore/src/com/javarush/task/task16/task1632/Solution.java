package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {   //R.A.M.
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(() -> {
            while (true) {}
        }));
        threads.add(new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }));
        threads.add(new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        }));
        threads.add(new FourThread());
        threads.add(new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine();
            int sum = 0;
            while (!num.equals("N")) {
                sum += Integer.parseInt(num);
                num = scanner.nextLine();
            }
            System.out.println(sum);
        }));
    }

    public static void main(String[] args) {

//        threads.forEach(thread -> thread.start());
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threads.get(1).interrupt();
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(threads.get(3).isAlive());

    }

    public static class FourThread extends Thread implements Message {

        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (!this.isInterrupted()) {
            }
        }
    }
}