package com.studentdevelopers.tictactoe.model.board;

import com.studentdevelopers.tictactoe.model.helpers.Observable;
import com.studentdevelopers.tictactoe.model.helpers.Observer;

import static com.studentdevelopers.tictactoe.model.board.CellState.EMPTY;

public class Board extends Observable implements Observer{

    private final Cell[] cells;
    private final int SIZE = 9;

    public Board() {
        cells = new Cell[SIZE];
        this.createCells();
    }

    private void createCells() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell();
            cells[i].addObserver(this);
        }
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

    private String separatorAt(int index) {
        return rowIsCompletedAt(index) ? "\n" : " ";
    }

    private boolean rowIsCompletedAt(int index) {
        return (index + 1) % 3 == 0;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public void update() {
        notifyObservers();
    }

    public Cell[] cells() {
        return cells;
    }
}
