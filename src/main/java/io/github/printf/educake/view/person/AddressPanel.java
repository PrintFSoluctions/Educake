package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialComboBox;
import de.craften.ui.swingmaterial.MaterialTextField;
import io.github.printf.educake.util.Components.ComboItem;
import io.github.printf.educake.util.Components.DefaultFormPanel;
import io.github.printf.educake.util.Enums.State;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Flex.HORIZONTAL;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class AddressPanel extends DefaultFormPanel{

	private MaterialTextField CEPTextField;
	private MaterialTextField cityTextField;
	private MaterialTextField streetTextField;
	private MaterialTextField houseNumberTextField;
	private MaterialTextField complementTextField;

	private MaterialButton findCEPBUtton;

	private MaterialComboBox stateCombo;

	@Override
	public void init() throws Exception {
		CEPTextField = makeGrid(BODY, HORIZONTAL).setGridWidth(8).addTextField("CEP:");
		findCEPBUtton = makeGrid(BODY, HORIZONTAL).setGridWidth(2).addButton("Buscar");
		addRow();
		cityTextField = makeGrid(BODY, HORIZONTAL).addTextField("Cidade:");
		stateCombo = makeGrid(BODY, HORIZONTAL).addComboBox(State.getAllStates(), 25);
		addRow();
		streetTextField = makeGrid(BODY, HORIZONTAL).addTextField("Rua, Bairro:");
		houseNumberTextField = makeGrid(BODY, HORIZONTAL).addTextField("Number:");
		addRow();
		complementTextField = makeGrid(BODY, HORIZONTAL).setWidth(2).addTextField("Complemento");
	}

	public String getCEP() {
		return CEPTextField.getText();
	}

	public void setCEP(String CEP) {
		this.CEPTextField.setText(CEP);
	}

	public String getCity() {
		return cityTextField.getText();
	}

	public void setCity(String city) {
		this.cityTextField.setText(city);
	}

	public String getStreet() {
		return streetTextField.getText();
	}

	public void setStreet(String street) {
		this.streetTextField.setText(street);
	}

	public String getHouseNumber() {
		return houseNumberTextField.getText();
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumberTextField.setText(houseNumber);
	}

	public String getComplement() {
		return complementTextField.getText();
	}

	public void setComplement(String complement) {
		this.complementTextField.setText(complement);
	}

	public String getState() {
		return ((ComboItem)stateCombo.getSelectedItem()).getValue();
	}

	public void setState(String state) {
		int selectedItem = 0;

		for (int i = 0; i < stateCombo.getItemCount(); i++) {
			ComboItem c = (ComboItem) stateCombo.getItemAt(i);
			if(c.getValue().toLowerCase() == state.toLowerCase()){
				selectedItem = i;
			}
		}

		this.stateCombo.setSelectedItem(selectedItem);
	}
}
