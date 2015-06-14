package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static java.awt.Color.decode;

public class BoardDisplay extends JPanel {

    private Map<String, CellButtonOperator> operationsMap;

    public BoardDisplay(Map<String, CellButtonOperator> operationsMap) {
        super();
        this.operationsMap = operationsMap;
        setBackground(decode("#D9E9E9"));
        setLayout(new GridLayout(3, 3));
        addButtons();
    }

    private void addButtons() {
        for (int i = 1; i <= 9; i++)
            addButton(new CellButton(i, operationsMap.get("Cell " + i)));
    }

    public void addButton(CellButton button) {
        add(button);
    }

}
