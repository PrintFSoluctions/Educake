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
import io.github.printf.educake.util.Components.ComponentFactory;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author a150276x
 */
public class Login extends JFrame {

    private final ComponentFactory component = new ComponentFactory();
    MaterialTextField login;
    MaterialPasswordField pass;
    MaterialButton enter;

    public Login() throws HeadlessException {
        setLayout(new MigLayout("gapy 15, gapx 10, w 300, inset 10"));

        String c = "w 100%, h 64px, center, wrap";

        login = component.addTextField("Nome de Usuário:");
        pass = component.addPasswordField("Senha:");
        enter = component.addButton("Entrar");

        add(login, c);
        add(pass, c);
        add(enter, c + ", h 62px, pad 0 0 20 0");

        setLocationRelativeTo(null);
        setLocation(this.getX()-150, this.getY()-300);
        setUndecorated(true);
        setResizable(false);
        setBackground(MaterialColor.WHITE);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String... args) {

        Login a = new Login();
        a.setVisible(true);

    }

}
