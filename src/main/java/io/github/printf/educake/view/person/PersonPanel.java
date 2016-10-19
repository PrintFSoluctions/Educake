package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.MaterialFormattedTextField;
import de.craften.ui.swingmaterial.MaterialTextField;
import io.github.printf.educake.util.Components.DefaultFormPanel;
import jiconfont.icons.GoogleMaterialDesignIcons;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Flex.HORIZONTAL;
import static io.github.printf.educake.util.Enums.Flex.NONE;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class PersonPanel extends DefaultFormPanel{
	private MaterialTextField nameTextField;
	private MaterialTextField surnameTextField;
	private MaterialFormattedTextField birthDateTextField;

	@Override
	public void init() throws Exception {
		makeGrid(BODY, NONE).addIcon(GoogleMaterialDesignIcons.ACCOUNT_BOX);
		nameTextField =
				makeGrid(BODY, HORIZONTAL).addTextField("Nome:");
		surnameTextField =
				makeGrid(BODY, HORIZONTAL).setWidth(2).addTextField("Sobrenome:");
		addRow();
		makeGrid(BODY, NONE).addIcon(GoogleMaterialDesignIcons.TODAY);
		birthDateTextField =
				makeGrid(BODY, HORIZONTAL).addFormattedTextField("Data de Nascimento:", "##/##/####");
		makeGrid(BODY, NONE).addIcon(GoogleMaterialDesignIcons.ASSIGNMENT);
		makeGrid(BODY, HORIZONTAL).addFormattedTextField("CPF:","###.###.###-##");
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
