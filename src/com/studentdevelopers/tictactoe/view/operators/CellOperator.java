package com.studentdevelopers.tictactoe.view.operators;

import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.helpers.Observer;

public interface CellOperator {

    CellState getStateForCell(int id);

    void addObserverToCell(int id, Observer observer);

    void markCell(int id);

}
