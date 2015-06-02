package com.studentdevelopers.tictactoe.controller;

import com.studentdevelopers.tictactoe.model.Game;
import com.studentdevelopers.tictactoe.model.GameBuilder;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.helpers.Observer;
import com.studentdevelopers.tictactoe.view.CellButton;
import com.studentdevelopers.tictactoe.view.CellButtonOperator;
import com.studentdevelopers.tictactoe.view.GameDisplay;

public class GameController {

    private final Game game;
    private final GameDisplay gameDisplay;

    public GameController() {
        game = GameBuilder.buildAPersonVSPersonGame();
        gameDisplay = new GameDisplay();
        addButtons();
        updateBoardView();
    }

    private void addButtons() {
        for (int i = 1; i <= 9; i++)
            gameDisplay.board().addButton(createCellButton(i));
    }

    private void updateBoardView() {
        gameDisplay.board().revalidate();
        gameDisplay.board().repaint();
    }

    private CellButton createCellButton(int index) {
        return new CellButton(index, new CellButtonOperator() {
            @Override
            public CellState getStateForCell(int id) {
                return game.board().cells()[id - 1].state();
            }

            @Override
            public void addObserverToCell(int id, Observer observer) {
                game.board().cells()[id - 1].addObserver(observer);
            }

            @Override
            public void markCell(int id) {
                game.markCell(id);
            }
        });
    }
}
