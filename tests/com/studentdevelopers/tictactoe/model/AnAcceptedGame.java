package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.testhelper.CellMarker;
import org.junit.Before;
import org.junit.Test;

import static com.studentdevelopers.tictactoe.model.GameState.*;
import static com.studentdevelopers.tictactoe.model.player.Figure.CIRCLE;
import static com.studentdevelopers.tictactoe.model.player.Figure.CROSS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnAcceptedGame {

    private final String firstTestBoard = "O O O\n- X X\n- - -\n";
    private final String secondTestBoard = "O X O\nX X O\nO O X\n";
    private final String thirdTestBoard = "O X -\nO X -\nO - -\n";
    private Game game;
    private CellMarker cellMarker;

    @Before
    public void setUp() throws Exception {
        game = GameBuilder.buildAPersonVSPersonGame();
        cellMarker = new CellMarker(game);
    }

    @Test
    public void should_have_a_won_state_when_circles_wins() {
        cellMarker.markCells(1, 5, 2, 6, 3);
        assertThat(game.boardToString(), is(firstTestBoard));
        assertThat(game.state(), is(WON));
        assertThat(game.winner(), is(CIRCLE));
    }

    @Test
    public void should_have_a_tie_state_when_all_cells_are_marked_without_a_winner() {
        cellMarker.markCells(1, 2, 3, 4, 6, 5, 8, 9);
        assertThat(game.state(), is(RUNNING));
        cellMarker.markCells(7);
        assertThat(game.state(), is(TIE));
        assertThat(game.boardToString(), is(secondTestBoard));
    }

    @Test
    public void should_return_crosses_like_winner_when_crosses_wins() {
        cellMarker.markCells(1, 4, 8, 5, 9);
        assertThat(game.state(), is(RUNNING));
        cellMarker.markCells(6);
        assertThat(game.state(), is(WON));
        assertThat(game.winner(), is(CROSS));
    }

    @Test
    public void should_not_allow_player_mark_a_cell_when_this_cell_is_already_marked() {
        cellMarker.markCells(1, 1, 2, 4, 5, 7);
        assertThat(game.boardToString(), is(thirdTestBoard));
        assertThat(game.state(), is(WON));
        assertThat(game.winner(), is(CIRCLE));
    }

}
