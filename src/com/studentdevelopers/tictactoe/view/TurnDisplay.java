package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class TurnDisplay extends JLabel {

    public TurnDisplay() {
        super("turn");
        setBackground(Color.white);
        setIcon(new ImageIcon("res/circle.png"));
    }
}
