package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.view.operators.ButtonOperator;
import com.studentdevelopers.tictactoe.view.operators.CellOperator;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;

public class GameDisplay extends JFrame {

    private BoardDisplay boardDisplay;
    private final CellOperator cellOperator;
    private final ButtonOperator buttonOperator;

    public GameDisplay(CellOperator cellOperator, ButtonOperator buttonOperator)  {
        super("Tic-Tac-Toe");
        this.cellOperator = cellOperator;
        this.buttonOperator = buttonOperator;
        setUpGame();
        addComponents();
        setVisible(true);
    }

    private void setUpGame() {
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addComponents() {
        boardDisplay = new BoardDisplay(cellOperator);
        add(boardDisplay, CENTER);
        add(new MenuPanel(buttonOperator), EAST);
    }

    public void restart() {
        boardDisplay.resetBoard();
        refreshView();
    }

    private void refreshView() {
        revalidate();
        repaint();
    }
}
