package io.github.printf.educake.view.main;

import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.view.person.responsible.ResponsibleView;
import io.github.printf.educake.view.person.student.StudentDash;
import io.github.printf.educake.view.person.student.StudentView;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class Routes extends JPanel {

  StudentDash studentDash = new StudentDash();
  StudentView newStudent = new StudentView();
  ResponsibleView newResponsible = new ResponsibleView(newStudent);

  HashMap<String, DefaultView> panels = new HashMap<>();

  public Routes() {
    setLayout(new CardLayout());

    // Routes
    add(studentDash, "studentDash");
    add(newStudent, "newStudent");
    add(newResponsible, "attachResponsible");

    // Replicate the routes to the HashMap
    panels.put("studentDash", studentDash);
    panels.put("newStudent", newStudent);
    panels.put("attachResponsible", newResponsible);
  }

  public HashMap<String, DefaultView> getPanels(){
    return panels;
  }
}
