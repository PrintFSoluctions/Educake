package io.github.printf.educake.view.person.student;

import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.TitlePanel;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentView extends JPanel {

//	private MaterialButton addButton;
	private PhonePanel phonePanel;
	private PersonPanel personPanel;
	private AddressPanel addressPanel;
	private TitlePanel titlePanel;
//
//	private MaterialButton saveButton;
//	private StudentController studentController = new StudentController();


	public StudentView() {
		setBackground(MaterialColor.WHITE);
		setLayout(new MigLayout("","grow","grow"));

		titlePanel = new TitlePanel("Cadastro Aluno", "Salvar");
		personPanel = new PersonPanel();
		phonePanel = new PhonePanel();

		add(titlePanel, "north, wrap");
		add(personPanel, "grow, wrap");
		add(phonePanel, "grow, wrap");

		titlePanel.getButton("Salvar").addActionListener(e -> System.out.println(personPanel.getName()));

//		try{
//			formPanel = new DefaultFormPanel();
//			setLayout(new GridLayout()); // Frame Layout
//			add(formPanel); // Add the Panel to the Frame
//
//			// Components grid
//			formPanel.makeGrid(HEADER, HORIZONTAL).addTitleLabel("Cadastro de Aluno");
//			saveButton = formPanel.makeGrid(HEADER, HORIZONTAL).addTitleButton("Salvar");
//
//			personPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new PersonPanel(), "Dados Pessoais");
//			formPanel.addRow();
//
//			phonesPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new PhonePanel(), "Contato");
//			formPanel.addRow();
//			addButton = formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).addButton("Adicionar Novo Telefone");
//			formPanel.addRow();
//
//			addressPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new AddressPanel(), "Endereço");
//
//			addButton.addActionListener(e -> addButtonListener());
//			saveButton.addActionListener(studentController.persist());
//			studentController.setView(this);
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}


	}
//
//	private void addButtonListener() {
//		try {
//			getPhonesPanel().addTelephone();
//		} catch (Exception ignored) {}
//	}
//
//	public PhonePanel getPhonesPanel() {
//		return (PhonePanel)phonesPanel;
//	}
//
////	public PersonPanel getPersonPanel() {
////		return (PersonPanel)personPanel;
////	}
//
//	public AddressPanel getAddressPanel() {
//		return (AddressPanel)addressPanel;
//	}
//
//	public MaterialButton getSaveButton() {
//		return saveButton;
//	}
}
