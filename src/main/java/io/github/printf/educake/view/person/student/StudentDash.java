package io.github.printf.educake.view.person.student;

import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.util.Components.ComponentFactory;
import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.util.Components.ThumbPanel;
import io.github.printf.educake.view.main.MainFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class StudentDash extends DefaultView {
  private StudentController studentController = new StudentController();
  private final ComponentFactory component = new ComponentFactory();
  ArrayList<ThumbPanel>  students = new ArrayList<ThumbPanel>();

  public StudentDash() {
    super("Alunos", "Novo Aluno");
    layout = new MigLayout("insets 4 4 4 4, flowy, w 100%", "grow");
    setBackground(MaterialColor.GREEN_200);
    studentController.setDash(this);

    titlePanel.getButton("Novo Aluno").addActionListener(e -> MainFrame.goTo("newStudent"));
  }


  public void showAll(List<Student> allStudents) {
    if (allStudents.isEmpty()){
      body.add(new ThumbPanel("Não há resultados!"));
    }
    allStudents.forEach(student -> body.add(new ThumbPanel(
        student.getRm(),
        student.getPerson().getName()+" "+student.getPerson().getSurname(),
        String.valueOf(student.getPerson().getBirthdate())
    )));
  }

  @Override
  public JPanel[] getPanels() {
    return null;
  }
}
