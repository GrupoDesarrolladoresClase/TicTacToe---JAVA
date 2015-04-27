package com.studentdevelopers.tictactoe.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnAcceptedGame {

    private String firstTestBoard = "O O O\n- X X\n- - -";

    @Test
    public void should_finish_when_a_player_wins() {
        GameBuilder builder = new GameBuilder();
        Game game = builder.buildAPersonVSPersonGame();
        game.markCell(0, 0);
        game.markCell(1, 1);
        game.markCell(0, 1);
        game.markCell(1, 2);
        game.markCell(0, 2);
        assertThat(game.gameState(), is(GameState.FINISHED));
        assertThat(game.boardToString(), is(firstTestBoard));
        assertThat(game.cellStateForPosition(2, 2), is(CellState.EMPTY));
        assertThat(game.cellStateForPosition(0, 0), is(CellState.CIRCLE));
        assertThat(game.cellStateForPosition(1, 1), is(CellState.CROSS));
    }
}
