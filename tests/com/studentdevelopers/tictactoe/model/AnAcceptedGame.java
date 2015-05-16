package com.studentdevelopers.tictactoe.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnAcceptedGame {

    private final String firstTestBoard = "O O O\n- X X\n- - -\n";
    private final String secondTestBoard = "O X O\nX X O\nO O X\n";

    @Test
    public void should_finish_when_a_player_wins() {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        game.markCell(1);
        game.markCell(5);
        game.markCell(2);
        game.markCell(6);
        game.markCell(3);
        assertThat(game.boardToString(), is(firstTestBoard));
        assertThat(game.gameState(), is(GameState.WON));
        assertThat(game.winner(), is("PlayerA"));
    }

    @Test
    public void should_finish_when_all_cells_are_marked_without_a_winner() {
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
}
