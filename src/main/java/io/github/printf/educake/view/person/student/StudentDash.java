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

    addCell(new ThumbPanel("a321556", "Fulano da Silva", "29/09/1995", "Caraguatatuba"));

  }

}
