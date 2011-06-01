package com.pakenned.util.swing.SimpleSwingAboutMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class SimpleAboutMenu {


    // allow for git clean/smudge help.
    private static final String REGEX_DATE = "\\$DATE:([0-9]{4}-[0-9]{2}-[0-9]{2})\\$";
    private static final String REGEX_DESC = "\\$DESC: (.*)\\$";
    private static final String VALUE_DESC = "$DESC$";
    private static final String VALUE_DATE = "$DATE$";

    protected static String getDesc() {
        return getStringFromRegex(REGEX_DESC, VALUE_DESC);
    }

    protected static String getDate() {
        return getStringFromRegex(REGEX_DATE, VALUE_DATE);
    }

    private static String getStringFromRegex(String regex, String value) {
        String descString = "(invalid value)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            descString= matcher.group(1);
        }
        return descString;
    }

    public static JMenuBar getJMenuBar(final JFrame frame, final String appName, final String versionNum){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menu = makeAboutMenu();
        jMenuBar.add(menu);
        setupMenuItem(frame, appName, versionNum, menu);
        return jMenuBar;
    }

    public static JMenu getJMenu(final JFrame frame, final String appName, final String versionNum){
        JMenu menu = makeAboutMenu();
        setupMenuItem(frame,appName,versionNum,menu);
        return menu;
    }


    private static JMenu makeAboutMenu() {
        JMenu menu = new JMenu("About");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("About");
        return menu;
    }

    private static void setupMenuItem(final JFrame frame, final String appName,
            final String versionNum, JMenu menu) {
        JMenuItem aboutItem = new JMenuItem("About "+appName);
        aboutItem.setName("about");
        menu.add(aboutItem);
        aboutItem.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(frame, appName + "\nVersion "
                        + versionNum + "\nCopyright Paul A. Kennedy" + "\n"+getDate() + "\n"+getDesc(), "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }






}
