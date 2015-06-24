package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.view.operators.CellOperator;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.decode;

public class BoardDisplay extends JPanel {

    public BoardDisplay(CellOperator cellOperator) {
        super();
        setUpBoard();
        addCells(cellOperator);
    }

    private void setUpBoard() {
        setBackground(decode("#D9E9E9"));
        setLayout(new GridLayout(3, 3));
    }

    private void addCells(CellOperator cellOperator) {
        for (int i = 1; i <= 9; i++)
            addButton(new CellButton(i, cellOperator));
    }

    public void addButton(CellButton button) {
        add(button);
    }

}
