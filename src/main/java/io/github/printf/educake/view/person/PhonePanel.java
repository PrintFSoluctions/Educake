package io.github.printf.educake.view.person;

import de.craften.ui.swingmaterial.*;
import io.github.printf.educake.util.Components.ComponentFactory;
import jiconfont.icons.GoogleMaterialDesignIcons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Vitor Silvério de Souza On out, 2016
 */
public class PhonePanel extends JPanel {

    private MaterialButton addButton;
    private ArrayList<MaterialFormattedTextField> phoneTextField = new ArrayList<>();
    private ArrayList<MaterialComboBox> phoneTypeCombo = new ArrayList<>();
    private final ComponentFactory component = new ComponentFactory();
    private String textFieldHeight = "w 100%, h 52px, pad -18 0 0 0";

    public PhonePanel() {
        setBackground(MaterialColor.WHITE);
        setLayout(new MigLayout("gapy 15, gapx 10, fill"));

        addTelephone();
        addTelephone();
    }

    public ArrayList<String> getPhones() {
        ArrayList<String> phones = new ArrayList<>();
        phoneTextField.forEach((phone) -> phones.add(phone.getText()));
        return phones;
    }

    public ArrayList<String> getPhoneTypes() {
        ArrayList<String> phoneTypes = new ArrayList<>();

        phoneTypeCombo.forEach((phone) -> phoneTypes
            .add((String) phone.getSelectedItem()));

        return phoneTypes;
    }

    public void setPhone(ArrayList<String> phones, ArrayList<String> types){
        for (int i = 0; i < phones.size(); i++) {
            String phone = phones.get(i);
            String type = types.get(i);

            addTelephone();
            phoneTextField.get(i).setText(phone);
            phoneTypeCombo.get(i).setSelectedItem(type);
        }
    }

    public void addTelephone() {
        MaterialFormattedTextField phone = component.addFormattedTextField("Telefone:", "(##)####-####");
        MaterialComboBox type = component.addComboBox("Fixo", "Celular");
        JLabel icon = component.addIcon(GoogleMaterialDesignIcons.PHONE);

        add(icon, "w 48");
        phoneTextField.add(phone);
        phoneTypeCombo.add(type);

        add(phone, textFieldHeight);
        add(type, textFieldHeight+", wrap");
        revalidate();
    }
}
