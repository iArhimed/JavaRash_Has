package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        if (args.length == 0) return;
        String out = null;
        Person person = null;
        Sex sex = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bDate = null;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        String arg1 = args[i];
                        String arg2 = args[i+1];
                        String arg3 = args[i+2];

                        sex = arg2.equals("ж") ? Sex.FEMALE : Sex.MALE;
                        try {
                            bDate = dateFormat.parse(arg3);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (sex == Sex.MALE) {
                            person = Person.createMale(arg1, bDate);
                        } else if (sex == Sex.FEMALE) {
                            person = Person.createFemale(arg1, bDate);
                        }
                        allPeople.add(person);
                        out = String.valueOf(allPeople.size() - 1);
                        System.out.println(out);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ++i) {
                        String arg1 = args[i];

                        person = allPeople.get(Integer.parseInt(arg1));
                        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        out = person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + date.format(person.getBirthDate());
                        System.out.println(out);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        String arg1 = args[i];
                        String arg2 = args[i + 1];
                        String arg3 = args[i + 2];
                        String arg4 = args[i + 3];

                        sex = arg3.equals("ж") ? Sex.FEMALE : Sex.MALE;
                        try {
                            bDate = dateFormat.parse(arg4);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        person = allPeople.get(Integer.parseInt(arg1));
                        person.setName(arg2);
                        person.setSex(sex);
                        person.setBirthDate(bDate);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ++i) {
                        String arg1 = args[i];
                        person = allPeople.get(Integer.parseInt(arg1));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;
        }
        //if (out != null) System.out.println(out);
    }
}
