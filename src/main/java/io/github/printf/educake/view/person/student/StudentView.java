package io.github.printf.educake.view.person.student;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.util.Components.DefaultFormPanel;
import io.github.printf.educake.view.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;

import javax.swing.*;
import java.awt.*;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Division.HEADER;
import static io.github.printf.educake.util.Enums.Flex.HORIZONTAL;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentView extends JFrame {

	private final MaterialButton addButton;
	private DefaultFormPanel phonesPanel;
	private DefaultFormPanel personPanel;
	private DefaultFormPanel addressPanel;
	private DefaultFormPanel formPanel;

	private MaterialButton saveButton;

	public static ToastBar errorLog;

	public StudentView() throws Exception {
		formPanel = new DefaultFormPanel();
		setLayout(new GridLayout()); // Frame Layout
		add(formPanel); // Add the Panel to the Frame

		// Components grid
		formPanel.makeGrid(HEADER, HORIZONTAL).addTitleLabel("Cadastro de Aluno");
		saveButton = formPanel.makeGrid(HEADER, HORIZONTAL).addTitleButton("Salvar");

		personPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new PersonPanel(), "Dados Pessoais");
		formPanel.addRow();

		phonesPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new PhonePanel(), "Contato");
		formPanel.addRow();
		addButton = formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).addButton("Adicionar Novo Telefone");
		formPanel.addRow();
		addButton.addActionListener(e -> { addButtonListener();});

		addressPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new AddressPanel(), "Endereço");
		init();
	}

	private void addButtonListener() {
		try {
			getPhonesPanel().addTelephone();
		} catch (Exception ignored) {}
	}

	private void init() {
		setMinimumSize(new Dimension(600, 400));
		setMaximumSize(new Dimension(600, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
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
