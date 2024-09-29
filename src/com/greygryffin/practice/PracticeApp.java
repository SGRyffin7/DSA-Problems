package com.greygryffin.practice;

import javax.swing.*;
import java.util.LinkedList;

public class PracticeApp extends JFrame{
    private JPanel mainPanel;

    public PracticeApp() {
        add(mainPanel);

        setTitle("Welcome");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        PracticeApp myFrame = new PracticeApp();
    }

}
