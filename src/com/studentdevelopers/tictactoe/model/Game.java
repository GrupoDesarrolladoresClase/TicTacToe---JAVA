package com.studentdevelopers.tictactoe.model;

public class Game {

    private final PlayersPair playersPair;
    private final Player currentPlayer;

    public Game(PlayersPair playersPair) {
        this.playersPair = playersPair;
        this.currentPlayer = this.playersPair.playerA();
    }

    public void markCell(int cellID) {
        this.currentPlayer.markCell(cellID);
    }

    public GameState gameState() {
        return null;
    }

    public String boardToString() {
        return board().toString();
    }

    private Board board() {
        return playersPair.board();
    }

    public CellState cellStateForPosition(int x, int y) {
        return null;
    }

    public Player playerA() {
        return playersPair.playerA();
    }

    public Player playerB() {
        return playersPair.playerB();
    }
}
