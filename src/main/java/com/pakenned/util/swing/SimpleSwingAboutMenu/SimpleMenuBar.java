package com.pakenned.util.swing.SimpleSwingAboutMenu;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class SimpleMenuBar  extends JPanel {

    private JTextField textField;

    public SimpleMenuBar() {
        setLayout(new FlowLayout());
        textField = new JTextField("Test Text Field");
        setPreferredSize(new Dimension(250,30));
        add(textField);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SimpleMenuBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SimpleMenuBar());
        frame.setJMenuBar(SimpleAboutMenu.getJMenuBar(frame, "SimpleMenuBar", "0.1 Beta"));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
