package com.javarush.games.minesweeper;

import com.javarush.engine.cell.* ;

public class MinesweeperGame extends Game {

    private int[] cells;
    private final int W_SCREEN = 10;
    private final int H_SCREEN = 10;

    @Override
    public void initialize () {
        setScreenSize(W_SCREEN, H_SCREEN);
        showGrid(true);
        for (int i = 0; i < W_SCREEN; ++i) {
           for (int j = 0; j < H_SCREEN; ++j) {
               setCellValueEx(i, j, Color.BLUE, "", Color.ORANGE, 50);
           }
        }
    }
}
