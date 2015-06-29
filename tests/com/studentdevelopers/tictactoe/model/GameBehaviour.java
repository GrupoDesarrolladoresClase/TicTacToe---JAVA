package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.player.HumanPlayer;
import com.studentdevelopers.tictactoe.model.testhelper.CellMarker;
import org.junit.Before;
import org.junit.Test;

import static com.studentdevelopers.tictactoe.model.GameState.RUNNING;
import static com.studentdevelopers.tictactoe.model.GameState.WON;
import static com.studentdevelopers.tictactoe.model.player.Figure.CIRCLE;
import static com.studentdevelopers.tictactoe.model.player.Figure.CROSS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameBehaviour {

    private Game game;
    private CellMarker cellMarker;

    private final String EMPTY_BOARD = "- - -\n- - -\n- - -\n";

    @Before
    public void setUp(){
        Board board = new Board();
        HumanPlayer playerA = new HumanPlayer(board, CIRCLE);
        HumanPlayer playerB = new HumanPlayer(board, CROSS);
        game = new Game(new PlayersPair(playerA, playerB));
        cellMarker = new CellMarker(game);
    }

    @Test
    public void should_create_a_board_with_empty_cells() {
        assertThat(game.boardToString(), is(EMPTY_BOARD));
    }

    @Test
    public void should_mark_with_a_circle_center_Position_when_first_player_moves_there() {
        cellMarker.markCells(5);
        assertThat(game.boardToString(), is("- - -\n- O -\n- - -\n"));
    }

    @Test
    public void should_mark_the_board_with_two_different_figures_when_mark_cell_twice() {
        cellMarker.markCells(5, 1);
        assertThat(game.boardToString(), is("X - -\n- O -\n- - -\n"));
    }

    @Test
    public void should_alternate_current_player_each_time_a_cell_is_marked() {
        cellMarker.markCells(1, 2, 5, 3, 4, 9);
        assertThat(game.boardToString(), is("O X X\nO O -\n- - X\n"));
    }

    @Test
    public void should_have_finished_state_when_there_is_a_winner() {
        cellMarker.markCells(1, 2, 4, 3, 7);
        assertThat(game.boardToString(), is("O X X\nO - -\nO - -\n"));
        assertThat(game.state(), is(WON));
    }

    @Test
    public void should_have_the_values_reseated_when_the_reset_method_is_called() {
        cellMarker.markCells(1, 2, 4, 3, 7);
        game.resetGame();
        assertThat(game.boardToString(), is(EMPTY_BOARD));
        assertThat(game.state(), is(RUNNING));
    }
}
