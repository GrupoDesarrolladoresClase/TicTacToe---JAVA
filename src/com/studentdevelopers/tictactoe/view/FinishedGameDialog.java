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
        MenuButton restartButton = new MenuButton("Restart");
        restartButton.addActionListener(e -> {
            finishedGameDialogOperators.restartGame();
            setVisible(false);
        });
        toolBarPanel.add(restartButton);
        toolBarPanel.add(new MenuButton("Exit"));
        return toolBarPanel;
    }
}
