package com.studentdevelopers.tictactoe.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameBuilderBehaviour {

    @Test
    public void should_create_a_game_with_two_human_players_when_buildPersonVSPersonGame_method_is_called() throws Exception {
        Game game = GameBuilder.buildAPersonVSPersonGame();
        assertTrue(game.playerA() instanceof HumanPlayer);
        assertTrue(game.playerB() instanceof HumanPlayer);
    }
}
