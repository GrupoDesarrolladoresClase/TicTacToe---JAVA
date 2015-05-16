package com.studentdevelopers.tictactoe.model.winchecker;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.Cell;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.board.Markable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class WinnerPlaysRepository {

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int COLUMNS = 3;

    private final ArrayList<Function<Board, Boolean>> plays;

    public ArrayList<Function<Board, Boolean>> plays() {
        return plays;
    }

    public WinnerPlaysRepository() {
        plays = new ArrayList<>();
        plays.add(board -> isAWonRow(FIRST, board));
        plays.add(board -> isAWonRow(SECOND, board));
        plays.add(board -> isAWonRow(THIRD, board));
        plays.add(board -> isAWonColumn(FIRST, board));
        plays.add(board -> isAWonColumn(SECOND, board));
        plays.add(board -> isAWonColumn(THIRD, board));
        plays.add(this::isAWonTopBottomDiagonal);
        plays.add(this::isAWonBottomTopDiagonal);
    }

    private boolean isAWonBottomTopDiagonal(Board board) {
        return isNotEmpty(board.cell(5)) && stateFor(board.cell(3)) == stateFor(board.cell(5))
                && stateFor(board.cell(5)) == stateFor(board.cell(7));
    }

    private boolean isAWonTopBottomDiagonal(Board board) {
        return isNotEmpty(board.cell(5)) && stateFor(board.cell(1)) == stateFor(board.cell(5))
                && stateFor(board.cell(5)) == stateFor(board.cell(9));
    }

    private boolean isAWonColumn(int column, Board board) {
        Map<String, Markable> cells = cellsMapForColumn(column, board);
        return isNotEmpty(cells.get("second")) && haveAllCellsSameState(cells);
    }

    private Map<String, Markable> cellsMapForColumn(int column, Board board) {
        Map<String, Markable> cells = new HashMap<>();
        cells.put("first", board.cell(1 + column));
        cells.put("second", board.cell(4 + column));
        cells.put("third", board.cell(7 + column));
        return cells;
    }

    private boolean isAWonRow(int row, Board board) {
        Map<String, Markable> cells = cellsMapForRow(row, board);
        return isNotEmpty(cells.get("second")) && haveAllCellsSameState(cells);
    }

    private Map<String, Markable> cellsMapForRow(int row, Board board) {
        Map<String, Markable> cells = new HashMap<>();
        cells.put("first", board.cell(1 + row * COLUMNS));
        cells.put("second", board.cell(2 + row * COLUMNS));
        cells.put("third", board.cell(3 + row * COLUMNS));
        return cells;
    }

    private boolean haveAllCellsSameState(Map<String, Markable> cells) {
        return stateFor(cells.get("first")) == stateFor(cells.get("second")) &&
                stateFor(cells.get("second")) == stateFor(cells.get("third"));
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
