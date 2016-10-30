package io.github.printf.educake.util.Components;

import com.esotericsoftware.tablelayout.Cell;
import com.esotericsoftware.tablelayout.swing.Table;
import de.craften.ui.swingmaterial.*;
import jiconfont.icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.Map;

/**
 * @author Vitor
 *     on 06/10/2016.
 */
public class NewDefaultFormPanel extends Table {

	public Cell cell;

	public NewDefaultFormPanel() {
		initPanel();
	}

	private void initPanel() {
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont()); // Registra a fonte de icones
		setBackground(Color.MAGENTA);
		defaults().expandX().height(54).top().fillX();
		setOpaque(true);
	}


	public JLabel addIcon(GoogleMaterialDesignIcons iconName) {
		Icon iconFont = IconFontSwing.buildIcon(iconName, 32, MaterialColor.TEAL_400);

		JLabel icon = new JLabel();
		icon.setIcon(iconFont);

		cell = addCell(icon);
		return icon;
	}

	public JLabel addLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(Roboto.REGULAR.deriveFont(14.0F));
		cell = addCell(label);
		return label;
	}

	public JLabel addTitleLabel(String text) {
		JLabel label = new JLabel("   " + text);
		label.setFont(Roboto.BOLD.deriveFont(26.0F));
		label.setForeground(MaterialColor.WHITE);
		cell = addCell(label);
		return label;
	}

	public MaterialTextField addTextField(String label) {
		MaterialTextField textField = new MaterialTextField();
		textField.setLabel(label);
		cell = addCell(textField);
		return textField;
	}

	public MaterialTextField addTextField(String label, String hint) {
		MaterialTextField textField = addTextField(label);
		textField.setHint(hint);
		cell = addCell(textField);
		return textField;
	}

	public MaterialFormattedTextField addFormattedTextField(String label, String mask) {
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter(mask);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MaterialFormattedTextField textField = new MaterialFormattedTextField(maskFormatter);
		textField.setLabel(label);
		cell = addCell(textField);
		return textField;
	}

	public MaterialComboBox addComboBox(String... items) {
		MaterialComboBox combo = new MaterialComboBox();
		for (String item : items) combo.addItem(item);
		cell = addCell(combo).height(39);
		return combo;
	}

	public MaterialComboBox addComboBox(Map<String, String> items, int preselected) {
		MaterialComboBox combo = new MaterialComboBox();

		items.forEach((key, value) -> combo.addItem(new ComboItem(key, value)));
		combo.setSelectedIndex(preselected);

		cell = addCell(combo).height(39);
		return combo;
	}

	public MaterialComboBox addComboBox(Map<String, String> items) {
		return addComboBox(items, 0);
	}

	public MaterialButton addTitleButton(String label) {
		MaterialButton button = new MaterialButton();
		button.setText(label);
		button.setForeground(MaterialColor.WHITE);
		button.setBackground(MaterialColor.TEAL_300);
		cell = addCell(button);
		return button;
	}

	public MaterialButton addButton(String label) {
		MaterialButton button = new MaterialButton();
		button.setText(label);
		button.setForeground(MaterialColor.WHITE);
		button.setBackground(MaterialColor.TEAL_500);
		cell = addCell(button);
		return button;
	}

	public JCheckBox addCheckBox(String label) {
		JCheckBox check = new JCheckBox();
		check.setText(label);
		cell = addCell(check);
		return check;
	}
}
