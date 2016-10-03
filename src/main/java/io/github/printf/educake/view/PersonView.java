package io.github.printf.educake.view;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialTextField;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.controller.PersonController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vitor on 02/10/2016.
 */
public class PersonView extends JFrame{

	MaterialButton addButton;
	public static MaterialTextField nameTextField, surnameTextField, birthDateTextField;
	public static ToastBar errorLog;

	public PersonView() {
		// Resources on Form
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		nameTextField = new MaterialTextField();
		nameTextField.setLabel("Nome:");
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = 45;
		c.ipadx = 80;
		c.weightx = 0.3;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		add(nameTextField, c);

		surnameTextField = new MaterialTextField();
		surnameTextField.setLabel("Sobrenome:");
		c.ipadx = 150;
		c.weightx = 0.7;
		c.gridx = 1;
		add(surnameTextField,c);

		birthDateTextField = new MaterialTextField();
		birthDateTextField.setLabel("Data de Nascimento:");
		c.weightx = 0;
		c.ipadx = 150;
		c.gridx = 2;
		add(birthDateTextField,c);

		addButton = new MaterialButton();
		c.weightx = 0;
		c.gridx = 3;
		c.ipady = 60;
		c.ipadx = 30;
		c.insets = new Insets(-10,-10,-10,-10);
		addButton.setForeground(MaterialColor.WHITE);
		addButton.setBackground(MaterialColor.GREENA_200);
		addButton.setText("Adicionar");
		add(addButton,c);

		errorLog = new ToastBar();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = 45;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		add(errorLog,c);

		init();
	}

	private void init(){
		initButtons();
		pack();
		setVisible(true);
	}
	private void initButtons(){
		addButton.addActionListener(PersonController.getAddListener());
	}
}
