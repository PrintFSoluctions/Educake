package io.github.printf.educake.view.main;

import io.github.printf.educake.view.person.student.StudentView;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class CardsPanel extends JPanel {

  public CardsPanel() {
    CardLayout cl = new CardLayout();
    setLayout(cl);

    add(new StudentView(), "Student");
    add(new JButton("Essa é a tela dos Professores"), "Teacher");
    add(new JButton("Essa é a tela dos Relatórios"), "Reports");
  }
}
