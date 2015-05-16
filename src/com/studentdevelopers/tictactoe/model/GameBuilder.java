package com.studentdevelopers.tictactoe.model;

import com.studentdevelopers.tictactoe.model.board.Board;
import com.studentdevelopers.tictactoe.model.player.HumanPlayer;

import static com.studentdevelopers.tictactoe.model.player.Figure.*;

public class GameBuilder {

    public static Game buildAPersonVSPersonGame() {
        Board board = new Board();
        return new Game(new PlayersPair(new HumanPlayer(board, CIRCLE), new HumanPlayer(board, CROSS)));
    }

}
