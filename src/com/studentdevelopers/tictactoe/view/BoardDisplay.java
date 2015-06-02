package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class BoardDisplay extends JPanel {

    public BoardDisplay() {
        super();
        setLayout(new GridLayout(3, 3));
        createCells();
    }

    private void createCells() {
        for (int i = 0; i < 9; i++)
            add(new JButton());
    }
}
