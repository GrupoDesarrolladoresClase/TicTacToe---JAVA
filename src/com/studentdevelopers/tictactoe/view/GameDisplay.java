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

    private void addComponents() {
        boardDisplay = new BoardDisplay(this.operationsMap);
        add(boardDisplay, CENTER);
        add(new MenuPanel(), EAST);
    }

    public void restart() {
        //TODO refactor this shit
        remove(boardDisplay);
        boardDisplay = new BoardDisplay(this.operationsMap);
        add(boardDisplay, CENTER);
        revalidate();
        repaint();
    }
}
