package com.studentdevelopers.tictactoe.model;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Supplier;

import static com.studentdevelopers.tictactoe.model.Figure.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameBehaviour {

    private Board board;
    private HumanPlayer playerA;
    private HumanPlayer playerB;
    private Game game;

    @Before
    public void setUp(){
        board = new Board();
        playerA = new HumanPlayer(board, CIRCLE);
        playerB = new HumanPlayer(board, CROSS);
        game = new Game(new PlayersPair(playerA, playerB));
    }

    @Test
    public void should_create_a_board_with_empty_cells() throws Exception {
        assertThat(game.boardToString(), is("- - -\n- - -\n- - -\n"));
    }

    @Test
    public void should_mark_with_a_circle_center_Position_when_first_player_moves_there() throws Exception {
        game.markCell(5);
        assertThat(game.boardToString(), is("- - -\n- O -\n- - -\n"));
    }
}
