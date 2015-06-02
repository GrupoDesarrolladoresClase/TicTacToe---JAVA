package com.studentdevelopers.tictactoe.view;

import javax.swing.*;

import static java.awt.Color.RED;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        super();
        setBackground(RED);
        add(new JLabel("Player1"));
    }
}
