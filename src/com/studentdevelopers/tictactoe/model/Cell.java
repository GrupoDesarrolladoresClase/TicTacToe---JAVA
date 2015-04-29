package com.studentdevelopers.tictactoe.model;

public class Cell implements Markable {

    private CellState state;

    public Cell() {
        this.state = CellState.EMPTY;
    }

    @Override
    public void markWith(Figure figure) {
        this.state = figure.equals(Figure.CIRCLE) ? CellState.CIRCLE : CellState.CROSS;
    }

    @Override
    public String toString() {
        return state.toString();
    }

    public CellState state() {
        return this.state;
    }
}
