package com.pakenned.util.swing.SimpleSwingAboutMenu;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.FlowLayout;
import java.awt.Dimension;

public class SimpleMenu extends JPanel {

    private JTextField textField;

    public SimpleMenu() {
        setLayout(new FlowLayout());
        textField = new JTextField("Test Text Field");
        setPreferredSize(new Dimension(250,30));
        add(textField);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SimpleMenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SimpleMenu());

        JMenu ops = new JMenu("Operations");
        JMenuItem nop = new JMenuItem("No Op");
        ops.add(nop);

        JMenuBar menubar = new JMenuBar();
        menubar.add(ops);
        menubar.add(SimpleAboutMenu.getJMenu(frame, "SimpleMenu", "0.1 Beta"));

        frame.setJMenuBar(menubar);
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
