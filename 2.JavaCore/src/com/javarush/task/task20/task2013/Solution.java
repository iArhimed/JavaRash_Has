package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.firstName = (String) in.readObject();
            this.lastName = (String) in.readObject();
            this.age = in.readInt();
            this.setMother((Person) in.readObject());
            this.setFather((Person) in.readObject());
            this.setChildren((List) in.readObject());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Person father = new Person("Иван", "Иванов", 55);
       FileOutputStream file = new FileOutputStream("b:\\aaa\\aaa.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(file)) {
            oos.writeObject(father);
        }
        file.close();

        Person father2;
        FileInputStream fileInputStream = new FileInputStream("b:\\aaa\\aaa.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        father2 = (Person) ois.readObject();
        System.out.println(father2.firstName + " " + father2.lastName + " " + father2.age);

    }
}
