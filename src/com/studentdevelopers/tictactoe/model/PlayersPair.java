package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.player.HumanPlayer;

public class PlayersPair {
    private final HumanPlayer playerA;
    private final HumanPlayer playerB;

    public PlayersPair(HumanPlayer playerA, HumanPlayer playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }


    public HumanPlayer playerA() {
        return playerA;
    }

    public HumanPlayer playerB() {
        return playerB;
    }

    public Board board() {
        return playerA.board();
    }
}
