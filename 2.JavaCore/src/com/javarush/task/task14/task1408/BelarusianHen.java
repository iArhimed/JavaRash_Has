package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public final String myCountry = Country.BELARUS;
    public final int countOfEggsPerMonth = 115;

    public int getCountOfEggsPerMonth() {
        return this.countOfEggsPerMonth;
    };

    @Override
    public String getDescription () {
        String resp = super.getDescription() + " Моя страна - " + this.myCountry + ". Я несу " + this.countOfEggsPerMonth + " яиц в месяц.";
        return resp;
    };
}
