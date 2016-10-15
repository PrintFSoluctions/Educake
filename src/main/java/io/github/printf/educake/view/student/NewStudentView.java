package io.github.printf.educake.view.student;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialComboBox;
import de.craften.ui.swingmaterial.MaterialFormattedTextField;
import de.craften.ui.swingmaterial.MaterialTextField;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.util.DefaultFormPanel;
import jiconfont.icons.GoogleMaterialDesignIcons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Division.HEADER;
import static io.github.printf.educake.util.Enums.Flex.*;

/**
 * Created by Vitor on 02/10/2016.
 */
public class NewStudentView extends JFrame {

    private DefaultFormPanel addressPanel;
    private DefaultFormPanel phonesPanel;
    private DefaultFormPanel formPanel;

    private MaterialTextField CEPTextField;
    private MaterialTextField cityTextField;
    private MaterialTextField streetTextField;
    private MaterialTextField houseNumberTextField;
    private MaterialTextField complementTextField;
    private MaterialTextField nameTextField;
    private MaterialTextField surnameTextField;
    private MaterialFormattedTextField birthDateTextField;

    private MaterialButton findCEPBUtton;
    private MaterialButton addButton;
    private MaterialButton plusButton;

    private MaterialComboBox stateCombo;

    public static ArrayList<MaterialFormattedTextField> phoneTextField = new ArrayList<>();
    public static ArrayList<MaterialComboBox> phoneTypeCombo = new ArrayList<>();
    public static ToastBar errorLog;

    public NewStudentView() throws Exception {
        formPanel = new DefaultFormPanel();
        setLayout(new GridLayout()); // Frame Layout
        add(formPanel); // Add the Panel to the Frame

        // Components grid
        formPanel.makeGrid(HEADER, HORIZONTAL).addTitleLabel("Cadastro de Aluno");
        addButton = formPanel.makeGrid(HEADER, HORIZONTAL).addTitleButton("Salvar");

        formPanel.makeGrid(BODY, NONE).addIcon(GoogleMaterialDesignIcons.ACCOUNT_BOX);
        nameTextField = formPanel.makeGrid(BODY, HORIZONTAL).addTextField("Nome:");
        surnameTextField = formPanel.makeGrid(BODY, HORIZONTAL).addTextField("Sobrenome:");
        formPanel.addRow();
        formPanel.makeGrid(BODY, NONE).addIcon(GoogleMaterialDesignIcons.TODAY);
        birthDateTextField = formPanel.makeGrid(BODY, HORIZONTAL).setWidth(2)
                .addFormattedTextField("Data de Nascimento", "00/00/0000", "##/##/####");
        formPanel.addRow();

        phonesPanel = formPanel.makeGrid(BODY, BOTH).setWidth(3).addInnerPanel();
        phoneTextField.add(phonesPanel.makeGrid(BODY, HORIZONTAL).setGridWidth(6)
                .addFormattedTextField("Telefone:", "(00)000000000", "(##)#########"));
        phoneTypeCombo.add(phonesPanel.makeGrid(BODY, HORIZONTAL)
                .addComboBox("Tipo", "Fixo", "Celular"));
        formPanel.addRow();

        plusButton = formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).addButton("Adicionar Novo Telefone");
        formPanel.addRow();

        addressPanel = formPanel.makeGrid(BODY, BOTH).setWidth(3).addInnerPanel();
        CEPTextField = addressPanel.makeGrid(BODY, HORIZONTAL).setGridWidth(8).addTextField("CEP:");
        findCEPBUtton = addressPanel.makeGrid(BODY, HORIZONTAL).setGridWidth(2).addButton("Buscar");
        addressPanel.addRow();
        cityTextField = addressPanel.makeGrid(BODY, HORIZONTAL).addTextField("Cidade:");
        stateCombo = addressPanel.makeGrid(BODY, HORIZONTAL).addComboBox("SP", "RJ", "MG", "BA");
        addressPanel.addRow();
        streetTextField = addressPanel.makeGrid(BODY, HORIZONTAL).addTextField("Rua, Bairro:");
        houseNumberTextField = addressPanel.makeGrid(BODY, HORIZONTAL).addTextField("Number:");
        addressPanel.addRow();
        complementTextField = addressPanel.makeGrid(BODY, HORIZONTAL).setWidth(2).addTextField("Complemento");

        init(); // iniatlize all
    }

    private void init() {
        initButtons();
        setMinimumSize(new Dimension(600, 400));
        setMaximumSize(new Dimension(600, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void initButtons() {
        addButton.addActionListener(StudentController.getAddListener());
        plusButton.addActionListener(e -> {
            try {
                phonesPanel.addRow();
                phoneTextField.add(phonesPanel.makeGrid(BODY, HORIZONTAL).setGridWidth(6)
                        .addFormattedTextField("Telefone:", "(00)000000000", "(##)#########"));
                phoneTypeCombo.add(phonesPanel.makeGrid(BODY, HORIZONTAL)
                        .addComboBox("Fixo", "Celular"));
//				phonesPanel.updateUI();
//				phonesPanel.getBody().updateUI();
                formPanel.updateUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public DefaultFormPanel getAddressPanel() {
        return addressPanel;
    }

    public void setAddressPanel(DefaultFormPanel addressPanel) {
        this.addressPanel = addressPanel;
    }

    public DefaultFormPanel getPhonesPanel() {
        return phonesPanel;
    }

    public void setPhonesPanel(DefaultFormPanel phonesPanel) {
        this.phonesPanel = phonesPanel;
    }

    public DefaultFormPanel getFormPanel() {
        return formPanel;
    }

    public void setFormPanel(DefaultFormPanel formPanel) {
        this.formPanel = formPanel;
    }

    public MaterialTextField getCEPTextField() {
        return CEPTextField;
    }

    public void setCEPTextField(MaterialTextField CEPTextField) {
        this.CEPTextField = CEPTextField;
    }

    public MaterialTextField getCityTextField() {
        return cityTextField;
    }

    public void setCityTextField(MaterialTextField cityTextField) {
        this.cityTextField = cityTextField;
    }

    public MaterialTextField getStreetTextField() {
        return streetTextField;
    }

    public void setStreetTextField(MaterialTextField streetTextField) {
        this.streetTextField = streetTextField;
    }

    public MaterialTextField getHouseNumberTextField() {
        return houseNumberTextField;
    }

    public void setHouseNumberTextField(MaterialTextField houseNumberTextField) {
        this.houseNumberTextField = houseNumberTextField;
    }

    public MaterialTextField getComplementTextField() {
        return complementTextField;
    }

    public void setComplementTextField(MaterialTextField complementTextField) {
        this.complementTextField = complementTextField;
    }

    public MaterialTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(MaterialTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public MaterialTextField getSurnameTextField() {
        return surnameTextField;
    }

    public void setSurnameTextField(MaterialTextField surnameTextField) {
        this.surnameTextField = surnameTextField;
    }

    public MaterialFormattedTextField getBirthDateTextField() {
        return birthDateTextField;
    }

    public void setBirthDateTextField(MaterialFormattedTextField birthDateTextField) {
        this.birthDateTextField = birthDateTextField;
    }

    public MaterialButton getAddButton() {
        return addButton;
    }

    public void setAddButton(MaterialButton addButton) {
        this.addButton = addButton;
    }

    public MaterialButton getPlusButton() {
        return plusButton;
    }

    public void setPlusButton(MaterialButton plusButton) {
        this.plusButton = plusButton;
    }

    public MaterialComboBox getStateCombo() {
        return stateCombo;
    }

    public void setStateCombo(MaterialComboBox stateCombo) {
        this.stateCombo = stateCombo;
    }

    public ArrayList<MaterialFormattedTextField> getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(ArrayList<MaterialFormattedTextField> phoneTextField) {
        NewStudentView.phoneTextField = phoneTextField;
    }

    public ArrayList<MaterialComboBox> getPhoneTypeCombo() {
        return phoneTypeCombo;
    }

    public void setPhoneTypeCombo(ArrayList<MaterialComboBox> phoneTypeCombo) {
        NewStudentView.phoneTypeCombo = phoneTypeCombo;
    }

}
