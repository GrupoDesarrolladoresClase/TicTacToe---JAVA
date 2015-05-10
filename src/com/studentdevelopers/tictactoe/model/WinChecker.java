package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.Cell;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.board.Markable;

public class WinChecker {
    public static boolean isThereWinnerInBoard(Board board) {
        return stateFor(board.cell(2)) == stateFor(board.cell(1)) &&
                stateFor(board.cell(2)) == stateFor(board.cell(3));
    }

    private static CellState stateFor(Markable cell) {
        return getCell(cell).state();
    }

    private static Cell getCell(Markable cell) {
        return (Cell)cell;
    }
}
