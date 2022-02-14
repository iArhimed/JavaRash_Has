package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return  model + color + price;
    }

    //напишите тут ваш код
    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//
//        if (obj == null)
//            return false;
//
//        if (!(obj instanceof Iphone))
//            return false;
        //Iphone iphone = (Iphone) obj;

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
       Iphone iphone = (Iphone) obj;
//        return price == iphone.price &&
//                Objects.equals(model, iphone.model) &&
//                Objects.equals(color, iphone.color);

        return Objects.equals(this.toString(), iphone.toString());

//        return this.price != iphone.price ? false :
//            this.color == null && iphone.color != null ? false :
//                this.model == null && iphone.model != null ? false :
//                    this.color != iphone.color ? false : this.model == iphone.model;


//        if (this.price != iphone.price)
//            return false;

//        if (this.color == null && iphone.color != null)
//            return false;

//        if (this.model == null && iphone.model != null)
//            return false;

//        if (this.color != iphone.color)
//            return false;

        //return this.model == iphone.model;
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);
        System.out.println(iphone1.toString());
        System.out.println(iphone2.toString());
        System.out.println(iphone1.equals(iphone2));
    }

}
