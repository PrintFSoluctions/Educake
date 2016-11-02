package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.*;
import io.github.printf.educake.util.Components.ComboItem;
import io.github.printf.educake.util.Components.ComponentFactory;
import io.github.printf.educake.util.Enums.State;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class AddressPanel extends JPanel{

	private MaterialFormattedTextField CEPTextField;
	private MaterialTextField cityTextField;
	private MaterialTextField streetTextField;
	private MaterialTextField houseNumberTextField;
	private MaterialTextField complementTextField;
	private final ComponentFactory component = new ComponentFactory();
	private MaterialButton findCEPButton;

	private MaterialComboBox stateCombo;
	private MaterialTextField districtTextField;

	public AddressPanel()	{
		setBackground(MaterialColor.WHITE);
		setLayout(new MigLayout("gapy 15, gapx 10, fill"));

		CEPTextField = component.addFormattedTextField("CEP:", "#####-###");
		findCEPButton = component.addButton("Buscar");
		cityTextField = component.addTextField("Cidade:");
		stateCombo = component.addComboBox(State.getAllStates(), 25);
		streetTextField = component.addTextField("Rua:");
		districtTextField = component.addTextField("Bairro:");
		houseNumberTextField = component.addTextField("Número:");
		complementTextField = component.addTextField("Complemento:");

		String textFieldHeight = "w 100%, h 52px, pad -18 0 0 0, push";

		add(CEPTextField, textFieldHeight);
		add(findCEPButton, textFieldHeight+", wrap");
		add(cityTextField, textFieldHeight);
		add(stateCombo, textFieldHeight+", wrap");
		add(streetTextField, textFieldHeight);
		add(districtTextField, textFieldHeight+", wrap");
		add(houseNumberTextField, textFieldHeight);
		add(complementTextField, textFieldHeight);
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
