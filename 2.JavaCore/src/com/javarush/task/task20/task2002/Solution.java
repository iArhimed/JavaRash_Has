package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Ivanov");
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) {
                System.out.println("Ok!");
            } else {
                System.out.println("Error!");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(String.valueOf(users.size()));
            if (users.size() > 0) {
                for (User user: users) {
                    writer.write("\n" + user.getFirstName() + " : " + user.getLastName() + " : " + user.getBirthDate().getTime() + " : " + user.isMale() + " : " + user.getCountry());
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            Integer count = Integer.parseInt(reader.readLine());
            if (count > 0) {
                for (int i = 0; i < count; ++i) {
                    String line = reader.readLine();
                    String[] user_str = line.split(" : ");
                    User user = new User();
                    user.setFirstName(user_str[0]);
                    user.setLastName(user_str[1]);
                    System.out.println(line);
                    user.setBirthDate(new Date(Long.parseUnsignedLong(user_str[2])));
                    user.setMale(user_str[3].equals("true") ? true : false);
                    user.setCountry(user_str[4].equals("RUSSIA")
                            ? User.Country.RUSSIA : user_str[4].equals("UKRAINE")
                            ? User.Country.UKRAINE : User.Country.OTHER);
                    users.add(user);
                    //System.out.println(user.getBirthDate());
                }
            }
            reader.close();
            inputStreamReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
