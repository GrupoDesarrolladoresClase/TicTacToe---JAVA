package com.studentdevelopers.tictactoe.model.winchecker;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.player.Figure;
import com.studentdevelopers.tictactoe.model.testhelper.LineMarker;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AWinChecker {

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    private LineMarker marker;

    @Before
    public void setUp() throws Exception {
        marker = new LineMarker();
    }

    @Test
    public void should_return_false_when_board_is_empty() throws Exception {
        assertThat(StateChecker.isThereWinnerInBoard(new Board()), is(false));
    }

    @Test
    public void should_return_true_when_all_figures_in_first_row_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markRowWithCircle(FIRST, boardWithO);
        marker.markRowWithCross(FIRST, boardWithX);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_second_row_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markRowWithCircle(SECOND, boardWithO);
        marker.markRowWithCross(SECOND, boardWithX);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_third_row_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markRowWithCircle(THIRD, boardWithO);
        marker.markRowWithCross(THIRD, boardWithX);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_first_column_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markColumnWithCircle(FIRST, boardWithO);
        marker.markColumnWithCross(FIRST, boardWithX);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_second_column_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markColumnWithCircle(SECOND, boardWithO);
        marker.markColumnWithCross(SECOND, boardWithX);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_third_column_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markColumnWithCircle(THIRD, boardWithO);
        marker.markColumnWithCross(THIRD, boardWithX);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_top_bottom_diagonal_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markTopBottomDiagonalInBoardWith(boardWithO, Figure.CIRCLE);
        marker.markTopBottomDiagonalInBoardWith(boardWithX, Figure.CROSS);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }

    @Test
    public void should_return_true_when_all_figures_in_bottom_top_diagonal_are_equals() throws Exception {
        Board boardWithO = new Board();
        Board boardWithX = new Board();
        marker.markBottomTopDiagonalInBoardWith(boardWithO, Figure.CIRCLE);
        marker.markBottomTopDiagonalInBoardWith(boardWithX, Figure.CROSS);
        assertThat(StateChecker.isThereWinnerInBoard(boardWithO), is(true));
        assertThat(StateChecker.isThereWinnerInBoard(boardWithX), is(true));
    }
}
