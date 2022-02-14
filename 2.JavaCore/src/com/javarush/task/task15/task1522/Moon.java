package com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private static Moon instance = null;

    private Moon() {
        instance = this;
    }

    public static Moon getInstance() {
        if (instance == null) return new Moon();
        return instance;
    }
}
