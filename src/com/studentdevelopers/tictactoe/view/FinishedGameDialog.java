package com.studentdevelopers.tictactoe.view;

import com.studentdevelopers.tictactoe.view.operators.ButtonOperator;

import javax.swing.*;
import java.awt.*;

public class FinishedGameDialog extends JDialog {

    private ButtonOperator buttonOperator;
    private final String MESSAGE;

    public FinishedGameDialog(String message, ButtonOperator buttonOperator) {
        super();
        this.MESSAGE = message;
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
        add(createMessagePanel(), BorderLayout.CENTER);
        add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel createMessagePanel() {
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(new JLabel(MESSAGE));
        return messagePanel;
    }

    private JPanel createToolBar() {
        JPanel toolBarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toolBarPanel.add(createRestartButton());
        toolBarPanel.add(createExitButton());
        return toolBarPanel;
    }

    private JButton createRestartButton() {
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {
            buttonOperator.resetGame();
            setVisible(false);
        });
        return restartButton;
    }

    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> buttonOperator.exitGame());
        return exitButton;
    }
}
