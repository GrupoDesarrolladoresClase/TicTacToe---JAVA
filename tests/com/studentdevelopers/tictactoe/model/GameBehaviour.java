package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.player.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import static com.studentdevelopers.tictactoe.model.player.Figure.*;
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

    @Test
    public void should_mark_the_board_with_two_different_figures_when_mark_cell_twice() throws Exception {
        game.markCell(5);
        game.markCell(1);
        assertThat(game.boardToString(), is("X - -\n- O -\n- - -\n"));
    }

    @Test
    public void should_alternate_current_player_each_time_a_cell_is_marked() throws Exception {
        game.markCell(1);
        game.markCell(2);
        game.markCell(5);
        game.markCell(3);
        game.markCell(4);
        game.markCell(9);
        assertThat(game.boardToString(), is("O X X\nO O -\n- - X\n"));
    }
}
