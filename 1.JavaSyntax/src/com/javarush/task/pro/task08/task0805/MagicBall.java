package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        //напишите тут ваш код
        Random rnd = new Random();
        int one_rnd = rnd.nextInt(8);
        String answer = null;
        if (one_rnd == 0) answer = CERTAIN;
        else if (one_rnd == 1) answer = DEFINITELY;
        else if (one_rnd == 2) answer = MOST_LIKELY;
        else if (one_rnd == 3) answer = OUTLOOK_GOOD;
        else if (one_rnd == 4) answer = ASK_AGAIN_LATER;
        else if (one_rnd == 5) answer = TRY_AGAIN;
        else if (one_rnd == 6) answer = NO;
        else if (one_rnd == 7) answer = VERY_DOUBTFUL;
        return answer;
    }
}
