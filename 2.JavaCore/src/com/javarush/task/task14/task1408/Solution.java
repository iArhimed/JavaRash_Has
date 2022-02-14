package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            String txt_country = country.toString();
            if (txt_country.equals("Moldova")) {
                hen = new MoldovanHen();
            } else if (txt_country.equals("Belarus")) {
                hen = new BelarusianHen();
            } else if (txt_country.equals("Ukraine")) {
                hen = new UkrainianHen();
            } else if (txt_country.equals("Russia")) {
                hen = new RussianHen();
            }
            return hen;
        }
    }


}
