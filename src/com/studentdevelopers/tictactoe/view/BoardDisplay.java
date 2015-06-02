package com.studentdevelopers.tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class BoardDisplay extends JPanel {

    public BoardDisplay() {
        super();
        setLayout(new GridLayout(3, 3));
    }

    public void addButton(CellButton button) {
        add(button);
    }

}
