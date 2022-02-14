package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/

public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("b:\\aaa\\aaa.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        Person person = new Person("Ivan", "Ivanov", "Russian", Sex.MALE);

        outputStream.writeObject(person);
        fileOutput.close();
        outputStream.close();

        FileInputStream fiStream = new FileInputStream("b:\\aaa\\aaa.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Person person2  = (Person) objectStream.readObject();
        fiStream.close();
        objectStream.close();



    }
}
