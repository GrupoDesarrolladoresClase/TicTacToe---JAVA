package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.view.operators.ButtonOperator;

import javax.swing.*;
import java.awt.*;

public class FinishedGameDialog extends JDialog {

    private ButtonOperator buttonOperator;

    public FinishedGameDialog(ButtonOperator buttonOperator) {
        super();
        this.buttonOperator = buttonOperator;
        setUpDialog();
        addComponents();
        setVisible(true);
    }

    private void setUpDialog() {
        setTitle("End Of Game");
        setModal(true);
        setMinimumSize(new Dimension(210, 85));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void addComponents() {
        add(createMessagePane("The Player1 is the Winner"), BorderLayout.CENTER);
        add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel createMessagePane(String message) {
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(new JLabel(message));
        return messagePanel;
    }

    private JPanel createToolBar() {
        JPanel toolBarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toolBarPanel.add(createRestartButton());
        toolBarPanel.add(createExitButton());
        return toolBarPanel;
    }

    private Button createRestartButton() {
        Button restartButton = new Button("Restart");
        restartButton.addActionListener(e -> {
            buttonOperator.restartGame();
            setVisible(false);
        });
        return restartButton;
    }

    private Button createExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.addActionListener(e -> buttonOperator.exitGame());
        return exitButton;
    }
}
