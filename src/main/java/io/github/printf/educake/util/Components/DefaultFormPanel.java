package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.*;
import io.github.printf.educake.util.Enums.Division;
import io.github.printf.educake.util.Enums.Flex;
import jiconfont.icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.util.Map;

/**
 * @author Vitor
 *         on 06/10/2016.
 */
public class DefaultFormPanel extends JPanel {
	private JPanel footer, body;
	private JPanel header;
	private JScrollPane scroll = new JScrollPane(body); // Container com scrollbar
	private JPanel selectedPanel;
	private GridBagConstraints constraint;
	private boolean isGridMade = false;
	private int y = 0, x = 0;

	public DefaultFormPanel() {
		initPanel();
	}

	private void initPanel() {
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont()); // Registra a fonte de icones
		this.setLayout(new BorderLayout());
		this.setBackground(MaterialColor.WHITE);
	}

	/**
	 * Create a new space to a possibly component that will come into it.
	 *
	 * @param division What division the possibly component will go
	 * @param flex     What kind of full resize it will get, or None
	 * @return DefaultFormPanel The own panel, to give the possibility of cascade methods
	 */
	public DefaultFormPanel makeGrid(Division division, Flex flex) throws Exception {
		constraint = new GridBagConstraints();
		selectedPanel = selectPanelByDivision(division);

		if (selectedPanel == null) {
			x = y = 0;
			if (division == Division.HEADER) {
				addHeader();
				selectedPanel = header;
			} else if (division == Division.BODY) {
				addBody();
				selectedPanel = body;
			} else {
				addFooter();
				selectedPanel = footer;
			}
		}

		constraint.ipady = 54; // Altura padrão dos components

		constraint.insets = new Insets(0, 5, 0, 0); // Borda Padrão
		constraint.fill = flex.getFlex();
		constraint.gridx = x++; // coloca na posição e já adiciona +1 para o próximo componente da linha
		constraint.gridy = y;

		switch (flex) {
			case HORIZONTAL:
				constraint.weightx = 1;
				break;
			case VERTICAL:
				constraint.weighty = 1;
				break;
			case BOTH:
				constraint.weightx = constraint.weighty = 1;
				break;
			case NONE:
				constraint.weighty = constraint.weightx = 0;
				break;
		}

		isGridMade = true;
		return this;
	}


	/**
	 * Adds one to the grid Y and resets X, to make a new row
	 */
	public void addRow() {
		y++;
		x = 0;
	}

	private void addHeader() throws Exception {
		if (header == null) {
			header = new JPanel();

			header.setLayout(new GridBagLayout());
			header.setBackground(MaterialColor.TEAL_500);

			this.add(header, BorderLayout.NORTH);
		} else {
			throw new Exception("Já existe um CABEÇALHO!");
		}
	}

	private void addBody() throws Exception {
		if (body == null) {
			body = new JPanel();

			scroll = new JScrollPane(body);

			body.setLayout(new GridBagLayout());
			body.setBackground(MaterialColor.WHITE);
			body.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

			scroll.setBorder(null);

			this.add(scroll);
		} else {
			throw new Exception("Já existe um CORPO!");
		}
	}

	protected void addBodyWithoutScroll(String title) throws Exception {
		if (body == null) {
			body = new JPanel();

			body.setLayout(new GridBagLayout());
			body.setBackground(MaterialColor.WHITE);

			body.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(1,0,0,0,MaterialColor.TEAL_200),
					title,
					TitledBorder.CENTER,
					TitledBorder.CENTER,
					Roboto.REGULAR.deriveFont(16.0F),
					MaterialColor.TEAL_600)
			);

			this.add(body);
		} else {
			throw new Exception("Já existe um CORPO!");
		}
	}

	private void addFooter() throws Exception {
		if (footer == null) {
			footer = new JPanel();

			footer.setLayout(new GridBagLayout());
			footer.setBackground(MaterialColor.WHITE);

			this.add(footer, BorderLayout.SOUTH);
		} else {
			throw new Exception("Já existe um RODAPÉ!");
		}
	}

	public DefaultFormPanel addIcon(GoogleMaterialDesignIcons iconName) throws Exception {
		Icon iconFont = IconFontSwing.buildIcon(iconName, 32, MaterialColor.TEAL_400);

		JLabel icon = new JLabel();
		icon.setIcon(iconFont);

		addComponent(icon);
		return this;
	}

	public void addLabel(String text) throws Exception {
		JLabel label = new JLabel(text);
		label.setFont(Roboto.REGULAR.deriveFont(14.0F));
		this.addComponent(label);
	}

	public void addTitleLabel(String text) throws Exception {
		JLabel label = new JLabel("     " + text);
		label.setFont(Roboto.BOLD.deriveFont(26.0F));
		label.setForeground(MaterialColor.WHITE);
		this.addComponent(label);
	}

	public MaterialTextField addTextField(String label) throws Exception {
		MaterialTextField textField = new MaterialTextField();
		textField.setLabel(label);
		this.addComponent(textField);
		return textField;
	}

	public MaterialTextField addTextField(String label, String hint) throws Exception {
		MaterialTextField textField = addTextField(label);
		textField.setHint(hint);
		return textField;
	}

	public MaterialFormattedTextField addFormattedTextField(String label, String mask) throws Exception {
		MaskFormatter maskFormatter = new MaskFormatter(mask);

		MaterialFormattedTextField textField = new MaterialFormattedTextField(maskFormatter);
		textField.setLabel(label);
		addComponent(textField);
		return textField;
	}

	public MaterialComboBox addComboBox(String... items) throws Exception {
		MaterialComboBox combo = new MaterialComboBox();
		constraint.ipady = 39; // o Combo tem tamanho diferente
		for (String item : items) combo.addItem(item);
		addComponent(combo);
		return combo;
	}

	public MaterialComboBox addComboBox(Map<String, String> items, int preselected) throws Exception {
		MaterialComboBox combo = new MaterialComboBox();
		constraint.ipady = 39; // o Combo tem tamanho diferente

		items.forEach((key, value) -> combo.addItem(new ComboItem(key, value)));
		combo.setSelectedIndex(preselected);

		addComponent(combo);
		return combo;
	}

	public MaterialComboBox addComboBox(Map<String, String> items) throws Exception {
		return addComboBox(items, 0);
	}

	public MaterialButton addTitleButton(String label) throws Exception {
		MaterialButton button = new MaterialButton();
		button.setText(label);
		button.setForeground(MaterialColor.WHITE);
		button.setBackground(MaterialColor.TEAL_300);
		addComponent(button);
		return button;
	}

	public MaterialButton addButton(String label) throws Exception {
		MaterialButton button = new MaterialButton();
		button.setText(label);
		button.setForeground(MaterialColor.WHITE);
		button.setBackground(MaterialColor.TEAL_500);
		addComponent(button);
		return button;
	}

	public JCheckBox addCheckBox(String label) throws Exception {
		JCheckBox check = new JCheckBox();
		check.setText(label);
		addComponent(check);
		return check;
	}

	private void addComponent(JComponent component) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");
		selectedPanel.add(component, constraint);

		System.out.println("Added Component: "
				+ component.getClass().getSimpleName()
				+ "\n - posX...: " + x
				+ "\n - posY...: " + y);

		isGridMade = false;
	}

	public DefaultFormPanel setWidth(int width) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");
		constraint.gridwidth = width;
		x += width - 1; // Se aumenta a largura não deve aumentar o x para não gerar problenmas na diagramação;
		return this;
	}

	public DefaultFormPanel setHeight(int width) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");
		constraint.ipady = width;
		return this;
	}

	public DefaultFormPanel setGridWidth(int gridWidth) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");

		constraint.ipadx = (getSize().width / 100) * gridWidth;
		constraint.weightx = gridWidth;
		return this;
	}

	private JPanel selectPanelByDivision(Division division) {
		switch (division) {
			case HEADER:
				return header;
			case BODY:
				return body;
			case FOOTER:
				return footer;
		}
		return null;
	}

	public JPanel getHeader() {
		return header;
	}

	public JPanel getBody() {
		return body;
	}

	public JPanel getFooter() {
		return footer;
	}

	public void toggleVisibility(Division division) {
		selectedPanel = selectPanelByDivision(division);
		selectedPanel.setVisible(!selectedPanel.isVisible());
	}

	public DefaultFormPanel addInnerPanel(String title) throws Exception {
		DefaultFormPanel panel = new DefaultFormPanel();
		addInnerPanel(panel, title);
		return panel;
	}

	public DefaultFormPanel addInnerPanel(DefaultFormPanel panel, String title) throws Exception {
		panel.setOpaque(true);
		panel.addBodyWithoutScroll(title);
		addComponent(panel);
		panel.init();
		return panel;
	}

	public DefaultFormPanel addInnerPanel(DefaultFormPanel panel) throws Exception {
		addInnerPanel(panel, "");
		return panel;
	}

	public void removeComponent(JComponent component){
		remove(component);
		x--;
	}

	public void removeRow(){
		y--;
	}


	protected void init() throws Exception{
		// Proposirally empty
	}

}
