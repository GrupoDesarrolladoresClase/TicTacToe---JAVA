package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;

public class GameDisplay extends JFrame {

    private BoardDisplay board;
    private MenuPanel menu;
    private Map<String, CellButtonOperator> operationsMap;

    public GameDisplay(Map<String, CellButtonOperator> operationsMap)  {
        super("Tic-Tac-Toe");
        this.operationsMap = operationsMap;
        gameSetUp();
        initializeComponents();
        addComponents();
        setVisible(true);
    }

    private void gameSetUp() {
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public BoardDisplay board() {
        return board;
    }

    private void initializeComponents() {
        board = new BoardDisplay(operationsMap);
        menu = new MenuPanel();
    }

    private void addComponents() {
        add(board, CENTER);
        add(menu, EAST);
    }

}
