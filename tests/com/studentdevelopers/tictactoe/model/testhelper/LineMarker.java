package com.studentdevelopers.tictactoe.model.testhelper;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.board.Markable;
import com.studentdevelopers.tictactoe.model.player.Figure;

import static com.studentdevelopers.tictactoe.model.player.Figure.*;

public class LineMarker {

    private static final int COLUMNS = 3;

    public void markColumnWithCircle(int column, Board board) {
        markWithCircle(board.cell(1 + column));
        markWithCircle(board.cell(4 + column));
        markWithCircle(board.cell(7 + column));
    }

    public void markColumnWithCross(int column, Board board) {
        markWithCross(board.cell(1 + column));
        markWithCross(board.cell(4 + column));
        markWithCross(board.cell(7 + column));
    }

    public void markRowWithCircle(int row, Board board) {
        markWithCircle(board.cell(1 + row * COLUMNS));
        markWithCircle(board.cell(2 + row * COLUMNS));
        markWithCircle(board.cell(3 + row * COLUMNS));
    }

    public void markRowWithCross(int row, Board board) {
        markWithCross(board.cell(1 + row * COLUMNS));
        markWithCross(board.cell(2 + row * COLUMNS));
        markWithCross(board.cell(3 + row * COLUMNS));
    }

    private void markWithCross(Markable cell) {
        cell.markWith(CROSS);
    }

    private void markWithCircle(Markable cell) {
        cell.markWith(CIRCLE);
    }

    public void markTopBottomDiagonalInBoardWith(Board board, Figure figure) {
        board.cell(1).markWith(figure);
        board.cell(5).markWith(figure);
        board.cell(9).markWith(figure);
    }

    public void markBottomTopDiagonalInBoardWith(Board board, Figure figure) {
        board.cell(3).markWith(figure);
        board.cell(5).markWith(figure);
        board.cell(7).markWith(figure);
    }
}
