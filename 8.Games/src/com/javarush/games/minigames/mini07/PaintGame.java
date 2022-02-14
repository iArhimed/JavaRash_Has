package com.javarush.games.minigames.mini07;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Работа с мышью
*/

public class PaintGame extends Game {

    @Override
    public void initialize() {
        //напишите тут ваш код
        int w = 5;
        int h = 5;
        setScreenSize(w, h);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    //напишите тут ваш код
    @Override
    public void onMouseLeftClick(int x, int y) {
        setCellColor(x, y, Color.GREEN);
    };

    @Override
    public void onMouseRightClick(int x, int y) {
        setCellColor(x, y, Color.ORANGE);
    };
}
