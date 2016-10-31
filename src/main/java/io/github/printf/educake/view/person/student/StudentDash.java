package io.github.printf.educake.view.person.student;

import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.ComponentFactory;
import io.github.printf.educake.util.Components.ThumbPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class StudentDash extends JPanel{
  private final ComponentFactory component = new ComponentFactory();

//  ArrayList<ThumbPanel>  students = new ArrayList<ThumbPanel>();

  public StudentDash() {
    setLayout(new MigLayout("insets 4 4 4 4","", ""));
    setBackground(MaterialColor.GREEN_200);

    add(component.header("Alunos", "Novo Aluno"), "north");

    String constraints = "w 100%, wrap";
    add(new ThumbPanel("a321654x", "Albino Freitas", "29/09/1995"), constraints);
    add(new ThumbPanel("a321654x", "Jhones Henrique", "29/09/1995"), constraints);
    add(new ThumbPanel("a321654x", "Vitor Silvério", "29/09/1995"), constraints);
    add(new ThumbPanel("a321654x", "Thaila Gonçalves", "29/09/1995"), constraints);

  }

}
