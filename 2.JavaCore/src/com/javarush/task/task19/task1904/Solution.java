package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
//        String line = "Иванов Иван Иванович 31 12 1950";
//        String[] pers = line.split(" ");
//        //Date date = new Date(Integer.parseInt(pers[5]), Integer.parseInt(pers[4]), Integer.parseInt(pers[3]));
//        Date date = null;
//        try {
//            date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( pers[3] + "." + pers[4] + "." + pers[5] );
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
//        Person person =  new Person(pers[1], pers[2], pers[0], date);
//        System.out.println(person.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            //Иванов Иван Иванович 31 12 1950
            String line = fileScanner.nextLine();
            String[] pers = line.split(" ");
            Date date = null;
            try {
                date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( pers[3] + "." + pers[4] + "." + pers[5] );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = new Person(pers[1], pers[2], pers[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
