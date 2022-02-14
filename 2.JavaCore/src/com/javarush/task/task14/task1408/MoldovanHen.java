package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    public final String myCountry = Country.MOLDOVA;
    public final int countOfEggsPerMonth = 100;

    public int getCountOfEggsPerMonth() {
        return this.countOfEggsPerMonth;
    };

    @Override
    public String getDescription () {
        String resp = super.getDescription() + " Моя страна - " + this.myCountry + ". Я несу " + this.countOfEggsPerMonth + " яиц в месяц.";
        return resp;
    };

}

//<getDescription() родительского класса> + < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц
