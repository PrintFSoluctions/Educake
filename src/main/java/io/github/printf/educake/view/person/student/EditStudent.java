package io.github.printf.educake.view.person.student;

import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.util.EasyDate;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;

import javax.swing.*;

/**
 * Created by Vitor on 02/10/2016.
 */
public class EditStudent extends DefaultView implements StudentView{

	private PhonePanel phonesPanel = new PhonePanel();
	private PersonPanel personPanel = new PersonPanel();
	private AddressPanel addressPanel = new AddressPanel();

	private StudentController studentController = new StudentController();

	public EditStudent() {
		super("Editar Aluno", "Salvar");

		body.add(getPersonPanel());
		body.add(getPhonesPanel());
		body.add(getAddressPanel());

		titlePanel.getButton("Salvar").addActionListener(studentController.update());
		studentController.setView(this);
	}

	public void fillForm(){
		Person student = studentController.getStudentById(id).getPerson();

		// FIXME: Separate the phones on setPhone method
		getPhonesPanel().setPhone(student.getPhones());

		getPersonPanel().setName(student.getName());
		getPersonPanel().setSurname(student.getSurname());
		getPersonPanel().setBirth(EasyDate.toString(student.getBirthdate()));
		getPersonPanel().setCPF(student.getCpf().getCpf());

		Address address = student.getAddress();

		getAddressPanel().setCEP(address.getCep());
		getAddressPanel().setCity(address.getCity());
		getAddressPanel().setStreet(address.getStreet());
		getAddressPanel().setComplement(address.getComplement());
		getAddressPanel().setHouseNumber(String.valueOf(address.getHouseNumber()));
		getAddressPanel().setState(address.getState());
		getAddressPanel().setDistrict(address.getDistrict());

	}

	public int getId() { return id; }

	public PhonePanel getPhonesPanel() {
		return phonesPanel;
	}

	public PersonPanel getPersonPanel() {
		return personPanel;
	}

	public AddressPanel getAddressPanel() {
		return addressPanel;
	}

	@Override
	public JPanel[] getPanels() {
		return new JPanel[]{
				getAddressPanel(),
				getPersonPanel(),
				getPhonesPanel()
		};
	}
}
