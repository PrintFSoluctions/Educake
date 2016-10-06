package io.github.printf.educake.util;

import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vitor
 * on 06/10/2016.
 */
public class DefaultFormPanel extends MaterialPanel {
	private JPanel header      = new JPanel();
	private JPanel body        = new JPanel(); // Container principal
	private JScrollPane scroll = new JScrollPane(body); // Container com scrollbar
	private JPanel footer      = new JPanel();
	private JPanel selectedPanel;
	private GridBagConstraints constraint;
	private boolean isGridMade = false;
	private int y = 0, x = 0;

	public DefaultFormPanel() {
		initPanel();
	}

	private void initPanel(){
		this.setLayout(new BorderLayout());
		this.setBackground(MaterialColor.WHITE);

		header.setLayout(new GridBagLayout());
		header.setBackground(MaterialColor.RED__50);

		body.setLayout(new GridBagLayout());
		body.setBackground(MaterialColor.WHITE);

		scroll.getViewport().setBackground(MaterialColor.WHITE);
		scroll.setBorder(null);

		footer.setLayout(new GridBagLayout());
		footer.setBackground(MaterialColor.BLUE_50);

		this.add(header, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(footer, BorderLayout.SOUTH);

	}

	/** Adds one to the grid Y and resets X, to make a new row */
	public void addRow(){y++; x = 0;}

	/**
	 * Create a new space to a possibly component that will come into it.
	 * @param where What division the possibly component will go
	 * @param flex What kind of full resize it will get, or None
	 *
	 * @return DefaultFormPanel The own panel, to give the possibility of cascade methods
	 * */
	public DefaultFormPanel makeGrid(Div where, Flex flex){
		constraint = new GridBagConstraints();

		switch (where){
			case HEADER: selectedPanel = header; break;
			case BODY:   selectedPanel = body; break;
			case FOOTER: selectedPanel = footer; break;
		}

		constraint.ipady = 54; // Altura padrão dos components
		constraint.insets = new Insets(0,5,0,0); // Borda Padrão
		constraint.fill = flex.getFlex();
		constraint.gridx = x++; // coloca na posição e já adiciona +1 para o próximo componente da linha
		constraint.gridy = y;

		switch (flex){
			case HORIZONTAL:
				constraint.weightx = 1; break;
			case VERTICAL:
				constraint.weighty = 1; break;
			case BOTH:
				constraint.weightx = constraint.weighty = 1; break;
			case NONE:
				constraint.weighty = constraint.weightx = 0; break;
		}

		isGridMade = true;
		return this;
	}

	public DefaultFormPanel setWidth(int width) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");
		constraint.gridwidth = width;
		x += width-1; // Se aumenta a largura não deve aumentar o x para não gerar problenmas na diagramação;
		return this;
	}

	public DefaultFormPanel setHeight(int width) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");

		constraint.ipady = width;
		return this;
	}


	public void addComponent(JComponent component) throws Exception {
		if (!isGridMade) throw new Exception("Crie a grid antes!");
		selectedPanel.add(component, constraint);
		isGridMade = false;
	}

	public enum Div{ HEADER, BODY, FOOTER }

	public enum Flex{
		HORIZONTAL(GridBagConstraints.HORIZONTAL),
		VERTICAL(GridBagConstraints.VERTICAL),
		BOTH(GridBagConstraints.BOTH),
		NONE(GridBagConstraints.NONE);

		private final int flex;

		Flex(int flex) {
			this.flex = flex;
		}

		public int getFlex(){
			return flex;
		}
	}
}
