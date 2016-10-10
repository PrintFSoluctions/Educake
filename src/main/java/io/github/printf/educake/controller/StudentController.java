package io.github.printf.educake.controller;

import de.craften.ui.swingmaterial.toast.TextToast;
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
			String name = NewStudentView.nameTextField.getText();
			String surname = NewStudentView.surnameTextField.getText();
			String birthDate = NewStudentView.birthDateTextField.getText();

			try {
				personService.persist(name, surname,birthDate);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				NewStudentView.errorLog.display(new TextToast(ex.getMessage()));
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
