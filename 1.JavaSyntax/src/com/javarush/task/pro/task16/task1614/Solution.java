package com.javarush.task.pro.task16.task1614;

import java.time.Instant;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        //напишите тут ваш код
        Instant n = Instant.ofEpochMilli(Long.MAX_VALUE);
        return n;
    }

    static Instant getMaxFromSeconds() {
        //напишите тут ваш код
        Instant n = Instant.ofEpochSecond(31556889864403199L);
        return n;
    }

    static Instant getMaxFromSecondsAndNanos() {
        //напишите тут ваш код
        Instant n = Instant.MAX;
        return n;
    }
}
