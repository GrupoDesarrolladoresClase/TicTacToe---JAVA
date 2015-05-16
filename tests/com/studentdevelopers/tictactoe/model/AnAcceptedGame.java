package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.player.Figure;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnAcceptedGame {

    private final String firstTestBoard = "O O O\n- X X\n- - -\n";
    private final String secondTestBoard = "O X O\nX X O\nO O X\n";
    private final String thirdTestBoard = "O X -\nO X -\nO - -\n";

    @Test
    public void should_have_a_won_state_when_circles_wins() {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        game.markCell(1);
        game.markCell(5);
        game.markCell(2);
        game.markCell(6);
        game.markCell(3);
        assertThat(game.boardToString(), is(firstTestBoard));
        assertThat(game.gameState(), is(GameState.WON));
        assertThat(game.winner(), is(Figure.CIRCLE));
    }

    @Test
    public void should_have_a_tie_state_when_all_cells_are_marked_without_a_winner() {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        game.markCell(1);
        game.markCell(2);
        game.markCell(3);
        game.markCell(4);
        game.markCell(6);
        game.markCell(5);
        game.markCell(8);
        game.markCell(9);
        assertThat(game.gameState(), is(GameState.RUNNING));
        game.markCell(7);
        assertThat(game.gameState(), is(GameState.TIE));
        assertThat(game.boardToString(), is(secondTestBoard));
    }

    @Test
    public void should_return_crosses_like_winner_when_crosses_wins() {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        game.markCell(1);
        game.markCell(4);
        game.markCell(8);
        game.markCell(5);
        game.markCell(9);
        assertThat(game.gameState(), is(GameState.RUNNING));
        game.markCell(6);
        assertThat(game.gameState(), is(GameState.WON));
        assertThat(game.winner(), is(Figure.CROSS));
    }

    @Test
    public void should_not_allow_player_mark_a_cell_when_this_cell_is_already_marked() {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        game.markCell(1);
        game.markCell(1);
        game.markCell(2);
        game.markCell(4);
        game.markCell(5);
        game.markCell(7);
        assertThat(game.boardToString(), is(thirdTestBoard));
        assertThat(game.gameState(), is(GameState.WON));
        assertThat(game.winner(), is(Figure.CIRCLE));
    }
}
