package io.github.printf.educake.view.main;

import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.view.person.responsible.ResponsibleView;
import io.github.printf.educake.view.person.student.EditStudent;
import io.github.printf.educake.view.person.student.StudentDash;
import io.github.printf.educake.view.person.student.NewStudent;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class Routes extends JPanel {

  StudentDash studentDash = new StudentDash();
  NewStudent newStudent = new NewStudent();
  EditStudent editStudent = new EditStudent();
  ResponsibleView newResponsible = new ResponsibleView(newStudent);

  HashMap<String, DefaultView> panels = new HashMap<>();

  public Routes() {
    setLayout(new CardLayout());
    // Routes
    add(studentDash, "studentDash");
    add(newStudent, "newStudent");
    add(editStudent, "editStudent");
    add(newResponsible, "attachResponsible");

    // Replicate the routes to the HashMap
    panels.put("studentDash", studentDash);
    panels.put("newStudent", newStudent);
    panels.put("editStudent", editStudent);
    panels.put("attachResponsible", newResponsible);
  }

  public HashMap<String, DefaultView> getPanels(){
    return panels;
  }
}
