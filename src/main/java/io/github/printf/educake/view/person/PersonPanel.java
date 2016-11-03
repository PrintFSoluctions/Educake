package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialFormattedTextField;
import de.craften.ui.swingmaterial.MaterialTextField;
import io.github.printf.educake.util.Components.ComponentFactory;
import jiconfont.icons.GoogleMaterialDesignIcons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class PersonPanel extends JPanel{
	private MaterialTextField nameTextField;
	private MaterialTextField surnameTextField;
	private MaterialFormattedTextField birthDateTextField;
	private MaterialFormattedTextField CPFTextField;
	private final ComponentFactory component = new ComponentFactory();

	private String textFieldHeight = "w 50%-48px*2px, h 52px, pad -18 0 0 0";

	public PersonPanel(){
		setBackground(MaterialColor.WHITE);
		setLayout(new MigLayout("gapy 15, gapx 10, fill"));

		JLabel iconID      = component.addIcon(GoogleMaterialDesignIcons.ACCOUNT_BOX);
		nameTextField      = component.addTextField("Nome:");
		surnameTextField   = component.addTextField("Sobrenome:");
		JLabel iconDate    = component.addIcon(GoogleMaterialDesignIcons.TODAY);
		birthDateTextField = component.addFormattedTextField("Data de Nascimento:", "##/##/####");
		JLabel iconDoc     = component.addIcon(GoogleMaterialDesignIcons.ASSIGNMENT);
		CPFTextField       = component.addFormattedTextField("CPF:","###.###.###-##");

		add(iconID, "w 48");
		add(nameTextField, textFieldHeight);
		add(surnameTextField, textFieldHeight+", span, wrap");

		add(iconDate, "w 48");
		add(birthDateTextField, textFieldHeight);
		add(iconDoc, "w 48");
		add(CPFTextField, textFieldHeight+", wrap");
	}

	public String getName() {
		return nameTextField.getText();
	}

	public void setName(String name) {
		this.nameTextField.setText(name);
	}

	public String getSurname() {
		return surnameTextField.getText();
	}

	public void setSurname(String surname) {
		this.surnameTextField.setText(surname);
	}

	public String getBirth() {
		return birthDateTextField.getText();
	}

	public void setBirth(String birthDate) {
		this.birthDateTextField.setText(birthDate);
	}
}
