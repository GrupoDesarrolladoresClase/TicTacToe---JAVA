package com.studentdevelopers.tictactoe.model.testhelper;

import com.studentdevelopers.tictactoe.model.Game;

public class CellMarker {

    private final Game game;

    public CellMarker(Game game) {
        this.game = game;
    }

    public void markCells(int... cellIDs) {
        for (int id : cellIDs) game.markCell(id);
    }

}
