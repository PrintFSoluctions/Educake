package io.github.printf.educake.view.student;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialComboBox;
import de.craften.ui.swingmaterial.MaterialTextField;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.util.Components.MaterialFormattedTextField;
import io.github.printf.educake.util.DefaultFormPanel;
import jiconfont.icons.GoogleMaterialDesignIcons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static io.github.printf.educake.util.Enums.Division.BODY;
import static io.github.printf.educake.util.Enums.Division.HEADER;
import static io.github.printf.educake.util.Enums.Flex.BOTH;
import static io.github.printf.educake.util.Enums.Flex.HORIZONTAL;
import static io.github.printf.educake.util.Enums.Flex.NONE;


/**
 * Created by Vitor on 02/10/2016.
 */
public class NewStudentView extends JFrame{
	DefaultFormPanel phonesPanel, formPanel;
	MaterialButton addButton, plusButton;
	public static MaterialTextField nameTextField, surnameTextField;
	public static MaterialFormattedTextField birthDateTextField;
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
		phoneTextField.add(phonesPanel.makeGrid(BODY,HORIZONTAL).setGridWidth(6)
				.addFormattedTextField("Telefone:","(00)000000000","(##)#########"));
		phoneTypeCombo.add(phonesPanel.makeGrid(BODY,HORIZONTAL)
				.addComboBox("Fixo", "Celular"));
		formPanel.addRow();
		plusButton = formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).addButton("Adicionar Novo Telefone");

		init(); // iniatlize all
	}

	private void init(){
		initButtons();
		setMinimumSize(new Dimension(600,400));
		setMaximumSize(new Dimension(600,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	private void initButtons(){
		addButton.addActionListener(StudentController.getAddListener());
		plusButton.addActionListener(e -> {
			System.out.println("b");
			try {
				System.out.println("a");
				phonesPanel.addRow();
				phoneTextField.add(phonesPanel.makeGrid(BODY,HORIZONTAL).setGridWidth(6)
						.addFormattedTextField("Telefone:","(00)000000000","(##)#########"));
				phoneTypeCombo.add(phonesPanel.makeGrid(BODY,HORIZONTAL)
						.addComboBox("Fixo", "Celular"));
				phonesPanel.updateUI();
				phonesPanel.getBody().updateUI();
				formPanel.updateUI();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
}

