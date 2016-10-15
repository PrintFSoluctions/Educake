package io.github.printf.educake.controller;

import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.view.student.NewStudentView;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentController {

    private static NewStudentView newStudentView;
    private static PersonService personService = new PersonService();

    public static ActionListener getAddListener() {
        return e -> {
            String name = newStudentView.getNameTextField().getText();
            String surname = newStudentView.getSurnameTextField().getText();
            String birthDate = newStudentView.getBirthDateTextField().getText();

            try {
                personService.persist(name, surname, birthDate);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
//              NewStudentView.errorLog.display(new TextToast(ex.getMessage()));
            }
        };
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            try {
                newStudentView = new NewStudentView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
