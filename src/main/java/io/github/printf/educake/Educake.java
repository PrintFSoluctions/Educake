package io.github.printf.educake;

import io.github.printf.educake.view.main.MainFrame;

import javax.swing.*;

public class Educake {

    public static void main(String... args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MainFrame mainFrame = new MainFrame();
    }

}
