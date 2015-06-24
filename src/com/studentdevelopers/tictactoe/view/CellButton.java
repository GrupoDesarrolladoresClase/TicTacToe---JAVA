package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.model.board.CellState;
import com.studentdevelopers.tictactoe.model.helpers.Observer;
import com.studentdevelopers.tictactoe.view.operators.CellOperator;

import javax.swing.*;

public class CellButton extends JButton implements Observer {

    private final int ID;
    private final CellOperator operator;

    public CellButton(int id, CellOperator operator) {
        super();
        ID = id;
        this.operator = operator;
        buttonSetUp(operator);
    }

    private void buttonSetUp(CellOperator operator) {
        setFocusPainted(false);
        operator.addObserverToCell(ID, this);
        addActionListener(event -> operator.markCell(ID));
    }

    @Override
    public void update() {
        CellState stateForCell = operator.getStateForCell(ID);
        if (isCircle(stateForCell)) markCell("circle");
        else markCell("cross");
    }

    private boolean isCircle(CellState stateForCell) {
        return stateForCell == CellState.CIRCLE;
    }

    private void markCell(String shape) {
        setIcon(new ImageIcon("res/" + shape + ".png"));
    }

}
