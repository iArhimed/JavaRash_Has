package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    public synchronized int compareTo(Beach o) {
        Beach beach2 = (Beach) o;
        int q = 0;
        if (this.quality - beach2.getQuality() > 0) q = 1;
        if (this.quality - beach2.getQuality() < 0) q = -1;
        int d = 0;
        if (this.distance - beach2.getDistance() > 0) d = -1;
        if (this.distance - beach2.getDistance() < 0) d = 1;
        return q + d;
    }
}
