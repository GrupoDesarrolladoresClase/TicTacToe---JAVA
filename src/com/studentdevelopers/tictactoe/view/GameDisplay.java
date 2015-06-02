package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;
import static java.awt.Color.*;

public class GameDisplay extends JFrame {

    public GameDisplay()  {
        super("Tic-Tac-Toe");
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setComponents();
        setVisible(true);
    }

    private void setComponents() {
        add(new BoardDisplay(), CENTER);
        add(new MenuPanel(), EAST);
    }

}
