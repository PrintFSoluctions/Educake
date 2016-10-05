package io.github.printf.educake.view.student;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialTextField;
import de.craften.ui.swingmaterial.toast.ToastBar;
import io.github.printf.educake.controller.StudentController;
import io.github.printf.educake.util.EasyComponent;
import jiconfont.icons.GoogleMaterialDesignIcons;

import javax.swing.*;
import java.awt.*;

import static io.github.printf.educake.util.EasyComponent.Flex.*;


/**
 * Created by Vitor on 02/10/2016.
 */
public class NewStudentView extends JFrame{

	MaterialButton addButton;

	JLabel label;
	public static MaterialTextField nameTextField, surnameTextField, birthDateTextField;
	public static ToastBar errorLog;

	public NewStudentView() {
		//// RESOURCES ////
		// Deve conter em todos os forms
		int y = 0; // Cria o valor das linhas pros componentes
		JPanel fieldSet; // Panel onde ficarão um grupo de textfields, CONTÉM TÍTULO
		GridBagConstraints c = new GridBagConstraints(); // Controlador de posicionamento dos components cin Grid
		Container mainContainer = new Container(); // Container principal
		JScrollPane scrollPane = new JScrollPane(mainContainer); // Container com scrollbar

		// RESOURCE CONFIG
		getContentPane().setBackground(MaterialColor.WHITE); // Fundo Branco do Frame
		mainContainer.setLayout(new GridBagLayout()); // Modo Grid
		scrollPane.setBorder(null); // Remove a borda que o Scroll cria
		// Adiciona o campo com scroll no meio
		// (poderia ser em cima, mas to pensando em colocar algum tipo de título)
		add(scrollPane, BorderLayout.CENTER);
		//// END RESOURCES ////

		fieldSet = EasyComponent.stylizedInsidePane("Dados Pessoais");
		c = EasyComponent.componentPosition(0, 0, HORIZONTAL);
		mainContainer.add(fieldSet,c);

		// Icone de Usuário
		label = EasyComponent.makeIcon(GoogleMaterialDesignIcons.ACCOUNT_BOX);
		c = EasyComponent.componentPosition(0, y, NONE);
		fieldSet.add(label, c);

		// Campo nome
		nameTextField = new MaterialTextField();
		nameTextField.setLabel("Nome:");
		c = EasyComponent.componentPosition(1, y, HORIZONTAL);
		fieldSet.add(nameTextField, c);

		// Campo Sobrenome
		surnameTextField = new MaterialTextField();
		surnameTextField.setLabel("Sobrenome:");
		c = EasyComponent.componentPosition(2, y++, HORIZONTAL);
		fieldSet.add(surnameTextField,c);

		// Icone Data de Nascimento
		label = EasyComponent.makeIcon(GoogleMaterialDesignIcons.TODAY);
		c = EasyComponent.componentPosition(0, y, NONE);
		fieldSet.add(label, c);

		// Campo data de Nascimento
		birthDateTextField = new MaterialTextField();
		birthDateTextField.setLabel("Data de Nascimento:");
		birthDateTextField.setHint("dd/mm/aaaa");
		c = EasyComponent.componentPosition(1, y, HORIZONTAL);
		c.gridwidth = 2;
		fieldSet.add(birthDateTextField,c);



		// Botão de Enviar
		addButton = new MaterialButton();
		addButton.setForeground(MaterialColor.WHITE);
		addButton.setBackground(MaterialColor.TEAL_400);
		addButton.setText("Adicionar");
		c = EasyComponent.componentPosition(0, 1, HORIZONTAL);
		mainContainer.add(addButton,c);

		// Panel preso à borda de baixo para mostrar as notificações
		Container fullBottomPane = new Container();
		fullBottomPane.setLayout(new GridBagLayout());
		// Log de Erros
		errorLog = new ToastBar();
		c = EasyComponent.componentPosition(0, 0, HORIZONTAL);
		c.ipady = 45;
		fullBottomPane.add(errorLog,c);
		add(fullBottomPane, BorderLayout.SOUTH);

		init();
	}

	private void init(){
		initButtons();
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
