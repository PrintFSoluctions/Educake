package io.github.printf.educake.view.Student;

/**
 * Created by Vitor on 02/10/2016.
 */

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialTextField;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void addComponentsToPane(Container pane) {

		// Resources on Form
		JLabel label;
		MaterialButton button;
		MaterialTextField textField;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		for (int i = 0; i < 9; i++) {
			textField = new MaterialTextField();
			textField.setLabel("Nome:");
			textField.setText("Fulano");
			textField.setEnabled(false);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.ipady = 45;
			c.ipadx = 80;
			c.weightx = 0.3;
			c.gridx = 0;
			c.gridy = i;
			c.insets = new Insets(0,0,0,0);
			pane.add(textField, c);

			textField = new MaterialTextField();
			textField.setLabel("Sobrenome:");
			textField.setText("da Silva");
			textField.setEnabled(false);
			c.ipadx = 150;
			c.weightx = 0.7;
			c.gridx = 1;
			pane.add(textField,c);

			textField = new MaterialTextField();
			textField.setLabel("Data de Nascimento:");
			textField.setText("02/10/2016");
			textField.setEnabled(false);
			c.weightx = 0;
			c.ipadx = 150;
			c.gridx = 2;
			pane.add(textField,c);

			button = new MaterialButton();
			c.weightx = 0;
			c.gridx = 3;
			c.ipady = 60;
			c.ipadx = 30;
			button.setText("Salvar");
			c.insets = new Insets(-10,-10,-10,-10);
			button.setBackground(MaterialColor.GREENA_400);
			button.setForeground(MaterialColor.WHITE);
			pane.add(button,c);
		}

		textField = new MaterialTextField();
		textField.setLabel("Nome:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = 45;
		c.ipadx = 80;
		c.weightx = 0.3;
		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(0,0,0,0);
		pane.add(textField, c);

		textField = new MaterialTextField();
		textField.setLabel("Sobrenome:");
		c.ipadx = 150;
		c.weightx = 0.7;
		c.gridx = 1;
		pane.add(textField,c);

		textField = new MaterialTextField();
		textField.setLabel("Data de Nascimento:");
		c.weightx = 0;
		c.ipadx = 150;
		c.gridx = 2;
		pane.add(textField,c);

		button = new MaterialButton();
		c.weightx = 0;
		c.gridx = 3;
		c.ipady = 60;
		c.ipadx = 30;
		c.insets = new Insets(-10,-10,-10,-10);
		button.setForeground(MaterialColor.WHITE);
		button.setBackground(MaterialColor.GREENA_200);
		button.setText("Adicionar");
		pane.add(button,c);

	}

	/**
	 * Create the GUI and start it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("GridBagLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}