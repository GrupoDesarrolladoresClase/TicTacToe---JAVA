package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.player.Player;

public class Game implements Observer {

    private final PlayersPair playersPair;
    private Player currentPlayer;

    public Game(PlayersPair playersPair) {
        this.playersPair = playersPair;
        this.currentPlayer = this.playersPair.playerA();
        this.board().addObserver(this);
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

    @Override
    public void update() {
        currentPlayer = (currentPlayer == playerA()) ? playerB() : playerA();
    }
}
