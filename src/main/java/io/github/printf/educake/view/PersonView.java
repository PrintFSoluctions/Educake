package io.github.printf.educake.view;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialTextField;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.controller.PersonController;
import io.github.printf.educake.util.EasyIcon;
import jiconfont.icons.GoogleMaterialDesignIcons;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Vitor on 02/10/2016.
 */
public class PersonView extends JFrame{

	MaterialButton addButton;

	JLabel label;
	public static MaterialTextField nameTextField, surnameTextField, birthDateTextField;
	public static ToastBar errorLog;

	public PersonView() {
		getContentPane().setBackground(MaterialColor.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		Container pane = new Container();
		pane.setLayout(new GridBagLayout());
		add(pane, BorderLayout.NORTH);
		// Resources on Form

		// Icone de Usuário
		label = EasyIcon.makeIcon(GoogleMaterialDesignIcons.ACCOUNT_BOX);
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,10,0,10);
		pane.add(label, c);

		// Campo nome
		nameTextField = new MaterialTextField();
		nameTextField.setLabel("Nome:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.ipady = 54;
		pane.add(nameTextField, c);

		// Campo Sobrenome
		surnameTextField = new MaterialTextField();
		surnameTextField.setLabel("Sobrenome:");
		c.gridx = 2;
		pane.add(surnameTextField,c);

		// Icone Data de Nascimento
		label = EasyIcon.makeIcon(GoogleMaterialDesignIcons.TODAY);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(label, c);

		// Campo data de Nascimento
		birthDateTextField = new MaterialTextField();
		birthDateTextField.setLabel("Data de Nascimento:");
		birthDateTextField.setHint("dd/mm/aaaa");
		c.weightx = 1;
		c.gridx = 1;
		c.gridwidth = 2;
		pane.add(birthDateTextField,c);

		// Botão de Enviar
		addButton = new MaterialButton();
		addButton.setForeground(MaterialColor.WHITE);
		addButton.setBackground(MaterialColor.TEAL_400);
		addButton.setText("Adicionar");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		pane.add(addButton,c);

		// Log de Erros
		errorLog = new ToastBar();
		c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = 45;
		c.gridy = 3;
		c.gridwidth = 3;
		pane.add(errorLog,c);

		init();
	}

	private void init(){
		initButtons();
		setPreferredSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	private void initButtons(){
		addButton.addActionListener(PersonController.getAddListener());
	}
}
