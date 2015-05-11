package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.Cell;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.board.Markable;

import java.util.function.Function;

public class WinChecker {

    private static WinnerPlaysRepository wonPlays = new WinnerPlaysRepository();

    public static boolean isThereWinnerInBoard(Board board) {
        for (Function<Board, Boolean> play : wonPlays.plays()) if (play.apply(board)) return true;
        return false;
    }


}
