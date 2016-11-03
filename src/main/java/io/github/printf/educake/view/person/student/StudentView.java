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

		body.add(getPersonPanel());
		body.add(getPhonesPanel());
		body.add(getAddressPanel());

		titlePanel.getButton("Salvar").addActionListener(studentController.persist(null));
		studentController.setView(this);
	}

	public PhonePanel getPhonesPanel() {
		return phonesPanel;
	}

	public PersonPanel getPersonPanel() {
		return personPanel;
	}

	public AddressPanel getAddressPanel() {
		return addressPanel;
	}
}
