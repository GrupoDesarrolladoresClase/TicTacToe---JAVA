package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.player.Figure;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AWinChecker {

    @Test
    public void should_return_true_when_all_figures_in_first_row_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        markFirstRowInBoardWith(boardWithO, Figure.CIRCLE);
        markFirstRowInBoardWith(boardWithX, Figure.CROSS);
        assertThat(WinChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(WinChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_false_when_board_is_empty() throws Exception {
        assertThat(WinChecker.isThereWinnerInBoard(new Board()), is(false));
    }

    @Test
    public void should_return_true_when_all_figures_in_second_row_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        markSecondRowInBoardWith(boardWithO, Figure.CIRCLE);
        markSecondRowInBoardWith(boardWithX, Figure.CROSS);
        assertThat(WinChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(WinChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    private void markSecondRowInBoardWith(Board board, Figure figure) {
        board.cell(4).markWith(figure);
        board.cell(5).markWith(figure);
        board.cell(6).markWith(figure);
    }

    private void markFirstRowInBoardWith(Board board, Figure figure) {
        board.cell(1).markWith(figure);
        board.cell(2).markWith(figure);
        board.cell(3).markWith(figure);
    }
}
