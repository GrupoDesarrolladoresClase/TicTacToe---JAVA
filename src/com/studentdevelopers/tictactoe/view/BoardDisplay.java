package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.decode;

public class BoardDisplay extends JPanel {

    public BoardDisplay() {
        super();
        setBackground(decode("#D9E9E9"));
        setLayout(new GridLayout(3, 3));
    }

    public void addButton(CellButton button) {
        add(button);
    }

}
