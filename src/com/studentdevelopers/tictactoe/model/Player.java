package com.studentdevelopers.tictactoe.model;

public class Player {

    private final Board board;
    private final Figure figure;

    public Player(Board board, Figure figure) {
        this.board = board;
        this.figure = figure;
    }

    public void markCell(int cellID) {
        cellFromBoard(cellID).markWith(figure);
    }

    private Markable cellFromBoard(int cellID) {
        return board.cell(cellID);
    }

    public Board board() {
        return this.board;
    }
}
