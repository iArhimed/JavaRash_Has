package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private static Earth instance = null;

    private Earth() {
        instance = this;
    }

    public static Earth getInstance() {
        if (instance == null) return new Earth();
        return instance;
    }
}
