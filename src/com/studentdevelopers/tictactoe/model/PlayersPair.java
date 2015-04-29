package com.studentdevelopers.tictactoe.model;

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
