package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class FinishedGameDialog extends JDialog {

    public FinishedGameDialog() {
        super();
        dialogSetUp();
        addComponents();
        setVisible(true);
    }

    private void dialogSetUp() {
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
        toolBarPanel.add(new MenuButton("Restart"));
        toolBarPanel.add(new MenuButton("Exit"));
        return toolBarPanel;
    }
}
