package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;

public class GameDisplay extends JFrame {

    private BoardDisplay board;
    private MenuPanel menu;

    public GameDisplay()  {
        super("Tic-Tac-Toe");
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeComponents();
        addComponents();
        setVisible(true);
    }

    public BoardDisplay board() {
        return board;
    }

    private void initializeComponents() {
        board = new BoardDisplay();
        menu = new MenuPanel();
    }

    private void addComponents() {
        add(board, CENTER);
        add(menu, EAST);
    }

}
