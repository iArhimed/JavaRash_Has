package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance = null;

    private Sun() {
        instance = this;
    }

    public static Sun getInstance() {
        if (instance == null) return new Sun();
        return instance;
    }
}
