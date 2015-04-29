package com.studentdevelopers.tictactoe.model;

import static com.studentdevelopers.tictactoe.model.Figure.*;

public class GameBuilder {

    public static Game buildAPersonVSPersonGame() {
        Board board = new Board();
        return new Game(new PlayersPair(new HumanPlayer(board, CIRCLE), new HumanPlayer(board, CROSS)));
    }

}
