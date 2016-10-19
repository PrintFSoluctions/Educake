package io.github.printf.educake.controller;

import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.view.person.student.StudentView;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentController {

    private static StudentView studentView;
    private static PersonService personService = new PersonService();

    public static ActionListener getAddListener() {
        return e -> {
//            String name = studentView.getNameTextField().getText();
//            String surname = studentView.getSurnameTextField().getText();
//            String birthDate = studentView.getBirthDateTextField().getText();

            try {
//                personService.persist(name, surname, birthDate);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
//              StudentView.errorLog.display(new TextToast(ex.getMessage()));
            }
        };
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            try {
                studentView = new StudentView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
