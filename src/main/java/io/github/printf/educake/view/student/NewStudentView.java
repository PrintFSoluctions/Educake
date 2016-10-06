package io.github.printf.educake.view.student;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialComboBox;
import de.craften.ui.swingmaterial.MaterialTextField;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.util.DefaultFormPanel;
import io.github.printf.educake.util.EasyComponent;
import jiconfont.icons.GoogleMaterialDesignIcons;

import javax.swing.*;
import java.awt.*;

import static io.github.printf.educake.util.DefaultFormPanel.Div.BODY;
import static io.github.printf.educake.util.DefaultFormPanel.Flex.HORIZONTAL;
import static io.github.printf.educake.util.DefaultFormPanel.Flex.NONE;


/**
 * Created by Vitor on 02/10/2016.
 */
public class NewStudentView extends JFrame{
	DefaultFormPanel formPanel = new DefaultFormPanel();
	MaterialButton addButton = new MaterialButton();
	JLabel accIcon, birthIcon;
	public static MaterialTextField
			nameTextField = new MaterialTextField(),
			surnameTextField = new MaterialTextField(),
			birthDateTextField = new MaterialTextField();
	MaterialComboBox<String> a= new MaterialComboBox();
	public static ToastBar errorLog;

	public NewStudentView(){
		setLayout(new GridLayout()); // Frame Layout
		add(formPanel); // Add the Panel to the Frame

		// Icons
		accIcon = EasyComponent.makeIcon(GoogleMaterialDesignIcons.ACCOUNT_BOX);
		birthIcon = EasyComponent.makeIcon(GoogleMaterialDesignIcons.TODAY);

		nameTextField.setLabel("Nome:");
		surnameTextField.setLabel("Sobrenome:");

		birthDateTextField.setLabel("Data de Nascimento:");
		birthDateTextField.setHint("dd/mm/aaaa");

		addButton.setText("Adicionar");
		addButton.setForeground(MaterialColor.WHITE);
		addButton.setBackground(MaterialColor.TEAL_400);

		// Components grid
		try {
			formPanel.makeGrid(BODY, NONE).addComponent(accIcon);
			formPanel.makeGrid(BODY, HORIZONTAL).addComponent(nameTextField);
			formPanel.makeGrid(BODY, HORIZONTAL).addComponent(surnameTextField);
			formPanel.addRow();
			formPanel.makeGrid(BODY, NONE).addComponent(birthIcon);
			formPanel.makeGrid(BODY, HORIZONTAL).setWidth(2).addComponent(birthDateTextField);
			formPanel.addRow();

			a.addItem("teste1");
			a.addItem("teste2");
			a.addItem("teste3");
			formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).setHeight(10).addComponent(a);

			formPanel.addRow();
			formPanel.makeGrid(BODY, HORIZONTAL).setWidth(3).addComponent(addButton);
		} catch (Exception e) {
			e.printStackTrace();
		}

		init(); // iniatlize all
	}

	private void init(){
//		initButtons();
		setMinimumSize(new Dimension(600,100));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	private void initButtons(){
		addButton.addActionListener(StudentController.getAddListener());
	}
}

