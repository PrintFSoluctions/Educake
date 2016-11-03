package io.github.printf.educake.view.person.student;

import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.ComponentFactory;
import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.util.Components.ThumbPanel;
import io.github.printf.educake.view.main.MainFrame;

import java.util.ArrayList;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class StudentDash extends DefaultView {
  private final ComponentFactory component = new ComponentFactory();
  ArrayList<ThumbPanel>  students = new ArrayList<ThumbPanel>();

  public StudentDash() {
    super("Alunos", "Novo Aluno");
    setBackground(MaterialColor.GREEN_200);

    body.add(new ThumbPanel("a321654x", "Albino Freitas", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Jhones Henrique", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Vitor Silvério", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Thaila Gonçalves", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Albino Freitas", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Jhones Henrique", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Vitor Silvério", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Thaila Gonçalves", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Albino Freitas", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Jhones Henrique", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Vitor Silvério", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Thaila Gonçalves", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Albino Freitas", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Jhones Henrique", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Vitor Silvério", "29/09/1995"));
    body.add(new ThumbPanel("a321654x", "Thaila Gonçalves", "29/09/1995"));

    titlePanel.getButton("Novo Aluno").addActionListener(e -> MainFrame.goTo("newStudent"));
  }

}
