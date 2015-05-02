package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.CellState;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnAcceptedGame {

    private String firstTestBoard = "O O O\n- X X\n- - -";

    @Test
    public void should_finish_when_a_player_wins() {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        game.markCell(1);
        game.markCell(5);
        game.markCell(2);
        game.markCell(6);
        game.markCell(3);
        assertThat(game.cellStateForPosition(2, 2), is(CellState.EMPTY));
        assertThat(game.cellStateForPosition(0, 0), is(CellState.CIRCLE));
        assertThat(game.cellStateForPosition(1, 1), is(CellState.CROSS));
        assertThat(game.boardToString(), is(firstTestBoard));
        assertThat(game.gameState(), is(GameState.FINISHED));
    }
}
