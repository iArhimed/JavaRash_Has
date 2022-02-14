package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public final String myCountry = Country.UKRAINE;
    public final int countOfEggsPerMonth = 105;

    public int getCountOfEggsPerMonth() {
        return this.countOfEggsPerMonth;
    };

    @Override
    public String getDescription () {
        String resp = super.getDescription() + " Моя страна - " + this.myCountry + ". Я несу " + this.countOfEggsPerMonth + " яиц в месяц.";
        return resp;
    };
}
