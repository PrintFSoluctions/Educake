package io.github.printf.educake.controller;

import de.craften.ui.swingmaterial.toast.TextToast;
import io.github.printf.educake.controller.exceptions.EmptyException;
import io.github.printf.educake.controller.exceptions.NotANameException;
import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.view.PersonView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.ParseException;

/**
 * Created by Vitor on 02/10/2016.
 */
public class PersonController {
	private static PersonView personView;
	private static PersonService personService = new PersonService();

	public static ActionListener getAddListener() {
		return e -> {
			String name = PersonView.nameTextField.getText();
			String surname = PersonView.surnameTextField.getText();
			String birthDate = PersonView.birthDateTextField.getText();

			try {
				personService.persist(name, surname,birthDate);
			} catch (NotANameException | ParseException | EmptyException ex) {
				System.out.println(ex.getMessage());
				PersonView.errorLog.display(new TextToast(ex.getMessage()));
			}
		};
	}

	public void start() {
		SwingUtilities.invokeLater(() -> {
			personView = new PersonView();
		});
	}
}
