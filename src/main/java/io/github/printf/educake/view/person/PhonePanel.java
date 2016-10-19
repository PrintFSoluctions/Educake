package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialComboBox;
import de.craften.ui.swingmaterial.MaterialFormattedTextField;
import io.github.printf.educake.util.Components.DefaultFormPanel;

import java.util.ArrayList;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Flex.HORIZONTAL;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class PhonePanel extends DefaultFormPanel{

	private MaterialButton addButton = new MaterialButton();
	private ArrayList<MaterialFormattedTextField> phoneTextField = new ArrayList<>();
	private ArrayList<MaterialComboBox> phoneTypeCombo = new ArrayList<>();

	@Override
	public void init() throws Exception {
		addTelephone();
	}

	public ArrayList<String> getPhones() {
		ArrayList<String> phones = new ArrayList<>();
		phoneTextField.forEach((phone) -> phones.add(phone.getText()));
		return phones;
	}

	public void setPhoneTextField(ArrayList<MaterialFormattedTextField> phoneTextField) {
		this.phoneTextField = phoneTextField;
	}

	public ArrayList<MaterialComboBox> getPhoneTypeCombo() {
		return phoneTypeCombo;
	}

	// TODO: F#deu
	public void setPhoneTypeCombo(ArrayList<MaterialComboBox> phoneTypeCombo) {
		this.phoneTypeCombo = phoneTypeCombo;
	}

	public void addTelephone() throws Exception {
		phoneTextField.add(makeGrid(BODY, HORIZONTAL).setGridWidth(6)
				.addFormattedTextField("Telefone:", "(##)####-####"));
		phoneTypeCombo.add(makeGrid(BODY, HORIZONTAL).addComboBox("Fixo", "Celular"));
		remove(addButton);
		addRow();
		revalidate();
	}
}
