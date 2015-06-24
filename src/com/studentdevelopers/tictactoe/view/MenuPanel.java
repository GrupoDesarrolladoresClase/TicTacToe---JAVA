package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.view.operators.ButtonOperator;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.decode;

public class MenuPanel extends JPanel {

    private final ButtonOperator buttonOperator;

    public MenuPanel(ButtonOperator buttonOperator) {
        super();
        this.buttonOperator = buttonOperator;
        setUpPanel();
        addComponents();
    }

    private void setUpPanel() {
        setPreferredSize(new Dimension(165, 600));
        setBackground(decode("#D9E9E9"));
        setLayout(new BorderLayout());
    }

    private void addComponents() {
        add(new TurnDisplay(), CENTER); //ToDo improve it
        add(createExitButton(), SOUTH);
    }

    private Button createExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.addActionListener(e -> buttonOperator.exitGame());
        return exitButton;
    }
}
