package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.*;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    //напишите тут ваш код
    @Override
    public void initialize() {
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.RED);
        colorList.add(Color.ORANGE);
        colorList.add(Color.YELLOW);
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        colorList.add(Color.INDIGO);
        colorList.add(Color.VIOLET);
        int wSise = 10;
        int hSise = 7;
        setScreenSize(wSise, hSise);
        for (int i = 0; i < wSise; ++i) {
                for (int j = 0; j < hSise; ++j) {
                    setCellColor(i, j, colorList.get(j));
                }
        }
    }

}
