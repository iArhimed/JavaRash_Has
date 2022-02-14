package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код

        if (args.length == 0) return;
        String out = null;
        Person person = null;
        Sex sex = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bDate = null;
        switch (args[0]) {
            case "-c":
                sex = args[2].equals("ж") ? Sex.FEMALE : Sex.MALE;
                try {
                    bDate = dateFormat.parse (args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (sex == Sex.MALE) {
                    person = Person.createMale(args[1], bDate);
                } else if (sex == Sex.FEMALE) {
                    person = Person.createFemale(args[1], bDate);
                }
                allPeople.add(person);
                out = String.valueOf (allPeople.size() - 1);
                break;
            case "-r":
                person = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                out = person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + date.format(person.getBirthDate());
                break;
            case "-u":
                sex = args[3].equals("ж") ? Sex.FEMALE : Sex.MALE;
                try {
                    bDate = dateFormat.parse (args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex(sex);
                person.setBirthDate(bDate);
                break;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
        }
        if (out != null) System.out.println(out);
    }
}
