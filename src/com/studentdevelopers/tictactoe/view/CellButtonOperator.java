package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.helpers.Observer;

public interface CellButtonOperator {

    CellState getStateForCell(int id);

    void addObserverToCell(int id, Observer observer);

    void markCell(int id);

}
