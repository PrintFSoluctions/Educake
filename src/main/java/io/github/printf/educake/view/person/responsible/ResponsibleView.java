/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.view.person.responsible;

import de.craften.ui.swingmaterial.MaterialButton;
import io.github.printf.educake.controller.ResponsibleController;
import io.github.printf.educake.util.Components.DefaultFormPanel;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PhonePanel;

import javax.swing.*;
import java.awt.*;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Division.HEADER;
import static io.github.printf.educake.util.Enums.Flex.HORIZONTAL;

/**
 *
 * @author a1402056
 */
public class ResponsibleView extends JPanel {

	private MaterialButton addButton;
	private DefaultFormPanel phonesPanel;
	private DefaultFormPanel personPanel;
	private DefaultFormPanel addressPanel;
	private DefaultFormPanel formPanel;

	private MaterialButton saveButton;
	private ResponsibleController responsibleController = new ResponsibleController();


	public ResponsibleView() {
		try{
			formPanel = new DefaultFormPanel();
			setLayout(new GridLayout()); // Frame Layout
			add(formPanel); // Add the Panel to the Frame

			// Components grid
			formPanel.makeGrid(HEADER, HORIZONTAL).addTitleLabel("Cadastro de Responsável");
			saveButton = formPanel.makeGrid(HEADER, HORIZONTAL).addTitleButton("Salvar");

//			personPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new PersonPanel(), "Dados Pessoais");
			formPanel.addRow();

			phonesPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new PhonePanel(), "Contato");
			formPanel.addRow();
			addButton = formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).addButton("Adicionar Novo Telefone");
			formPanel.addRow();

			addressPanel = formPanel.makeGrid(BODY, HORIZONTAL).addInnerPanel(new AddressPanel(), "Endereço");

			addButton.addActionListener(e -> addButtonListener());
			saveButton.addActionListener(responsibleController.persist());
			responsibleController.setView(this);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private void addButtonListener() {
		try {
			getPhonesPanel().addTelephone();
		} catch (Exception ignored) {}
	}

	public PhonePanel getPhonesPanel() {
		return (PhonePanel)phonesPanel;
	}

//	public PersonPanel getPersonPanel() {
//		return (PersonPanel)personPanel;
//	}

	public AddressPanel getAddressPanel() {
		return (AddressPanel)addressPanel;
	}

	public MaterialButton getSaveButton() {
		return saveButton;
	}
}

