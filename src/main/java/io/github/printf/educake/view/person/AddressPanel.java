package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.*;
import io.github.printf.educake.util.Components.ComboItem;
import io.github.printf.educake.util.Components.ComponentFactory;
import io.github.printf.educake.util.Components.Resetable;
import io.github.printf.educake.util.Enums.State;
import jiconfont.icons.GoogleMaterialDesignIcons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class AddressPanel extends JPanel implements Cloneable, Resetable {
	private MaterialFormattedTextField CEPTextField;
	private MaterialTextField cityTextField;
	private MaterialTextField streetTextField;
	private MaterialTextField houseNumberTextField;
	private MaterialTextField complementTextField;
	private MaterialTextField districtTextField;
	private final ComponentFactory component = new ComponentFactory();
	//	private MaterialButton findCEPButton;
	private MaterialComboBox stateCombo;

	private String textFieldHeight = "h 52px, pad -18 0 0 0";

	public AddressPanel()	{
		setBackground(MaterialColor.WHITE);
		setLayout(new MigLayout("gapy 15, gapx 10, w 100%"));


		JLabel CEPIcon = component.addIcon(GoogleMaterialDesignIcons.PAGEVIEW);
		JLabel cityIcon = component.addIcon(GoogleMaterialDesignIcons.BUSINESS);
		JLabel streetIcon = component.addIcon(GoogleMaterialDesignIcons.CALL_SPLIT);
		JLabel houseIcon = component.addIcon(GoogleMaterialDesignIcons.MY_LOCATION);

		CEPTextField         = component.addFormattedTextField("CEP:", "#####-###");
//	  findCEPButton        = component.addButton("Buscar");
		cityTextField        = component.addTextField("Cidade:");
		stateCombo           = component.addComboBox(State.getAllStates(), 25);
		streetTextField      = component.addTextField("Rua:");
		districtTextField    = component.addTextField("Bairro:");
		houseNumberTextField = component.addTextField("Número:");
		complementTextField  = component.addTextField("Complemento:");

		add(CEPIcon, "w 48");
		add(CEPTextField, textFieldHeight         + ", w 100%-48px, span, wrap");
//		add(findCEPButton, textFieldHeight        + ", w 20%, growx, span, wrap");
		add(cityIcon, "w 48");
		add(cityTextField, textFieldHeight        + ", w 80%-48px");
		add(stateCombo, textFieldHeight           + ", w 20%, growx, wrap");
		add(streetIcon, "w 48");
		add(streetTextField, textFieldHeight      + ", w 50%-48px, growx ");
		add(districtTextField, textFieldHeight    + ", w 50%, wrap");
		add(houseIcon, "w 48");
		add(houseNumberTextField, textFieldHeight + ", w 50%-48px, growx");
		add(complementTextField, textFieldHeight  + ", w 50%");
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

	public String getDistrict(){
		return districtTextField.getText();
	}

	public void setDistrict(String district) {
		this.districtTextField.setText(district);
	}


	@Override
	public AddressPanel clone() throws CloneNotSupportedException {
		return (AddressPanel) super.clone();
	}

	@Override
	public void reset() {
		CEPTextField        .setText("");
		cityTextField       .setText("");
		stateCombo          .setSelectedIndex(25);
		streetTextField     .setText("");
		districtTextField   .setText("");
		houseNumberTextField.setText("");
		complementTextField .setText("");
	}
}
