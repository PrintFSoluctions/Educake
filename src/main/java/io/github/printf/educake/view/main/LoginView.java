/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.view.main;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialPasswordField;
import de.craften.ui.swingmaterial.MaterialTextField;
import io.github.printf.educake.model.Login;
import io.github.printf.educake.model.dao.LoginDAO;
import io.github.printf.educake.util.Components.ComponentFactory;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author a150276x
 */
public class LoginView extends JPanel {

    private final ComponentFactory component = new ComponentFactory();
    MaterialTextField login;
    MaterialPasswordField pass;
    MaterialButton enter, exit;
    JLabel title, subtitle, error;
    static JFrame loginFrame;

    public LoginView() throws HeadlessException {
        setLayout(new MigLayout("gapx 10, w 300, inset 10"));

        String c = "w 100%, h 64px, center";

        title = component.addTitleLabel("EDUCAKE");
        title.setText(title.getText().trim());
        title.setForeground(MaterialColor.TEAL_500);

        JLabel educakeLogo = component.addIcon("logoWhite.png");

        subtitle = component.addLabel("Gestão de Escolas");


        error = component.addLabel("");
        error.setForeground(Color.red);
        error.setHorizontalAlignment(CENTER);
        login = component.addTextField("Nome de Usuário:");
        pass = component.addPasswordField("Senha:");
        enter = component.addButton("Entrar");
        exit = component.addButton("Sair");

        setBorder(BorderFactory.createLineBorder(MaterialColor.TEAL_500, 3));

        add(title,"span, center, wrap");
        add(educakeLogo, "span, center, h 70px!, wrap");
        add(subtitle,"span, center, wrap");
        add(error, "center, span, hmin 40, wrap");
        add(login, c+", span, wrap");
        add(pass, c+", span, wrap");
        add(enter, c +", h 62px, pad 0 0 0 0");
        add(exit, c + ", h 62px, pad 0 0 0 0, wrap");

        enter.addActionListener(e->tryLogin());
        exit.addActionListener(e->System.exit(0));

        setBackground(MaterialColor.WHITE);
    }

    public static void main(String... args) {
        loginFrame = new JFrame();
        loginFrame.setContentPane(new LoginView());
        loginFrame.setUndecorated(true);
        loginFrame.pack();
        loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }

    private void tryLogin() {
        System.out.println(String.valueOf(this.pass.getPassword()));
        LoginDAO login = new LoginDAO();
        login.persist(new Login(this.login.getText(), String.valueOf(this.pass.getPassword())));

        if(login.tryLogin(this.login.getText(), String.valueOf(this.pass.getPassword()))){
            MainFrame mainFrame = new MainFrame();
            loginFrame.dispose();
        }else{
            String[] errors = new String[]{
                "Errou! ~ Faustão",
                "You Shall not Pass!! ~ Gandalf",
                "<html>Veja se alguém do seu lado sabe a senha...<br> Fica a dica.</html>",
                "Iih, acho que não deu não hein...",
                "<html>Tá pensando que aqui é o que?<br> Casa da mãe Joana?"
            };

            error.setText(errors[(int) (Math.random() * errors.length)]);
            loginFrame.pack();
        }
    }

}
