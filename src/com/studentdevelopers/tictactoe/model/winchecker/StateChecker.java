package com.studentdevelopers.tictactoe.model.winchecker;

import com.studentdevelopers.tictactoe.model.GameState;
import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.Cell;

import java.util.function.Function;

import static com.studentdevelopers.tictactoe.model.board.CellState.EMPTY;

public class StateChecker {

    private static WinnerPlaysRepository wonPlays = new WinnerPlaysRepository();

    public static boolean isThereWinnerInBoard(Board board) {
        for (Function<Board, Boolean> play : wonPlays.plays()) if (play.apply(board)) return true;
        return false;
    }


    public static GameState getUpdatedGameStateFor(Board board) {
        if (StateChecker.isThereWinnerInBoard(board)) return GameState.WON;
        if (StateChecker.isThereATieIn(board)) return GameState.TIE;
        return GameState.RUNNING;
    }

    private static boolean isThereATieIn(Board board) {
        for (Cell cell : board.cells())
            if (cell.state() == EMPTY) return false;
        return true;
    }
}
