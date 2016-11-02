package io.github.printf.educake.view.person.student;

import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentView extends DefaultView {

	private PhonePanel phonesPanel = new PhonePanel();
	private PersonPanel personPanel = new PersonPanel();
	private AddressPanel addressPanel = new AddressPanel();

	private StudentController studentController = new StudentController();

	public StudentView() {
		super("Cadastro Aluno", "Salvar");

		body.add(personPanel);
		body.add(phonesPanel);
		body.add(addressPanel);

		titlePanel.getButton("Salvar").addActionListener(e -> studentController.persist(null));
	}

	public PhonePanel getPhonesPanel() {
		return (PhonePanel)phonesPanel;
	}

	public PersonPanel getPersonPanel() {
		return (PersonPanel)personPanel;
	}

	public AddressPanel getAddressPanel() {
		return (AddressPanel)addressPanel;
	}
}
