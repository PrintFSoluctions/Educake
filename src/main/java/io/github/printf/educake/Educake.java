package io.github.printf.educake;

import io.github.printf.educake.view.main.LoginView;

import javax.swing.*;

public class Educake {

    public static void main(String... args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        LoginView login = new LoginView();
        login.start();
    }

}
