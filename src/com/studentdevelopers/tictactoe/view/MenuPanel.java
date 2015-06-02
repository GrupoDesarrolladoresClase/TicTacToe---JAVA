package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.GRAY;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        super();
        setPreferredSize(new Dimension(150, 600));
        setBackground(GRAY);
        add(new JLabel("Player1"));
    }
}
