package com.studentdevelopers.tictactoe.controller;

import com.studentdevelopers.tictactoe.model.Game;
import com.studentdevelopers.tictactoe.model.GameBuilder;
import com.studentdevelopers.tictactoe.model.GameState;
import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.helpers.Observer;
import com.studentdevelopers.tictactoe.view.CellButton;
import com.studentdevelopers.tictactoe.view.CellButtonOperator;
import com.studentdevelopers.tictactoe.view.FinishedGameDialog;
import com.studentdevelopers.tictactoe.view.GameDisplay;

import static com.studentdevelopers.tictactoe.model.GameState.TIE;
import static com.studentdevelopers.tictactoe.model.GameState.WON;

public class GameController {

    private final Game game;
    private final GameDisplay gameDisplay;
    private final Map<String, CellButtonOperator> operationsMap = new HashMap<>();

    public GameController() {
        game = GameBuilder.buildAPersonVSPersonGame();
        fillOperationsMap();
        gameDisplay = new GameDisplay(operationsMap);
        updateBoardView();
    }

    private void fillOperationsMap() {
        for (int i = 1; i <= 9; i++)
            operationsMap.put("Cell " + i, operationForCellButton(i));
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
                if (isFinished()) new FinishedGameDialog();
            }
        });
    }

    private boolean isFinished() {
        GameState state = game.gameState();
        return state == WON || state == TIE;
    }
}
