package com.studentdevelopers.tictactoe.model.board;

public enum CellState {
    CIRCLE("O"), CROSS("X"), EMPTY("-");

    private final String representation;

    CellState(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}