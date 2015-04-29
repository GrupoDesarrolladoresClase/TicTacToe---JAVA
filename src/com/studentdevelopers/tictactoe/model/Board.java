package com.studentdevelopers.tictactoe.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Cell[] cells;
    private final int SIZE = 9;

    public Board() {
        cells = new Cell[SIZE];
        this.createCells();
    }

    private void createCells() {
        for (int i = 0; i < cells.length; i++) cells[i] = new Cell();
    }

    public Markable cell(int cellID) {
        return cells[cellID-1];
    }

    @Override
    public String toString() {
        String board = "";
        for (int i = 0; i < cells.length; i++)
            board += cells[i].toString() + separatorAt(i);
        return board;
    }

    private String separatorAt(int i) {
        return rowIsCompletedAt(i) ? "\n" : " ";
    }

    private boolean rowIsCompletedAt(int index) {
        return (index + 1) % 3 == 0;
    }
}
