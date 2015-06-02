package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.decode;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        super();
        panelSetUp();
        addComponents();
    }

    private void panelSetUp() {
        setPreferredSize(new Dimension(165, 600));
        setBackground(decode("#D9E9E9"));
        setLayout(new BorderLayout());
    }

    private void addComponents() {
        add(new TurnDisplay(), CENTER);
        add(new MenuButton("Exit"), SOUTH);
    }
}
