package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.Cell;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.board.Markable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class WinnerPlaysRepository {

    private static final int FIRST_ROW = 0;
    private static final int SECOND_ROW = 1;
    private static final int COLUMNS = 3;

    private final ArrayList<Function<Board, Boolean>> plays;

    public ArrayList<Function<Board, Boolean>> plays() {
        return plays;
    }

    public WinnerPlaysRepository() {
        plays = new ArrayList<>();
        plays.add(board -> isAWonRow(FIRST_ROW, board));
        plays.add(board -> isAWonRow(SECOND_ROW, board));
    }

    private boolean isAWonRow(int row, Board board) {
        Map<String, Markable> cells = cellsMapForRow(row, board);
        return isNotEmpty(cells.get("mid")) && haveAllCellsSameState(cells);
    }

    private Map<String, Markable> cellsMapForRow(int row, Board board) {
        Map<String, Markable> cells = new HashMap<>();
        cells.put("left", board.cell(1 + row * COLUMNS));
        cells.put("mid", board.cell(2 + row * COLUMNS));
        cells.put("right", board.cell(3 + row * COLUMNS));
        return cells;
    }

    private boolean haveAllCellsSameState(Map<String, Markable> cells) {
        return stateFor(cells.get("left")) == stateFor(cells.get("mid")) &&
                stateFor(cells.get("mid")) == stateFor(cells.get("right"));
    }

    private boolean isNotEmpty(Markable cell) {
        return getCell(cell).state() != CellState.EMPTY;
    }

    private static CellState stateFor(Markable cell) {
        return getCell(cell).state();
    }

    private static Cell getCell(Markable cell) {
        return (Cell)cell;
    }
}
