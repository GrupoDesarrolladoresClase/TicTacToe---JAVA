package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;

import java.util.function.Function;

public class WinChecker {

    private static WinnerPlaysRepository wonPlays = new WinnerPlaysRepository();

    public static boolean isThereWinnerInBoard(Board board) {
        for (Function<Board, Boolean> play : wonPlays.plays()) if (play.apply(board)) return true;
        return false;
    }


}
