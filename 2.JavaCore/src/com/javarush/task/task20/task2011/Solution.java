package com.javarush.task.task20.task2011;

import java.io.*;

/* 
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String) in.readObject();
            this.year = (int) in.readInt();
        }

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws Exception {
       Apartment apartment = new Apartment("Moskow", 2021);
       FileOutputStream file = new FileOutputStream("b:\\aaa\\aaa.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(file)) {
            oos.writeObject(apartment);
        }
        file.close();

        Apartment apartment1;
        FileInputStream fileInputStream = new FileInputStream("b:\\aaa\\aaa.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        apartment1 = (Apartment) ois.readObject();
        System.out.println(apartment1.address);
        System.out.println(apartment1.year);
    }
}
