package io.github.printf.educake.view.person.student;

import io.github.printf.educake.util.Components.NewDefaultFormPanel;
import io.github.printf.educake.view.ThumbPanel;

import java.util.ArrayList;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class StudentDash extends NewDefaultFormPanel {

  ArrayList<ThumbPanel>  students = new ArrayList<ThumbPanel>();

  public StudentDash() {

    top();
    addCell(new ThumbPanel("a321556", "Albino Freitas", "29/09/1995", "Caraguatatuba"));
    row();
    addCell(new ThumbPanel("a321556", "Jhones Henrique", "29/09/1995", "Caraguatatuba"));
    row();
    addCell(new ThumbPanel("a321556", "Thaila Golçalves", "29/09/1995", "Caraguatatuba"));
    row();
    addCell(new ThumbPanel("a32155x", "Vitor Silvério", "29/09/1995", "Caraguatatuba"));
  }

}
