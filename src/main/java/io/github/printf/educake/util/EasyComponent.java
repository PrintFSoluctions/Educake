package io.github.printf.educake.util;

import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.Roboto;
import jiconfont.icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
/**
 * Created by Vitor on 03/10/2016.
 */
public class EasyComponent {

	static Font font;

	public static JLabel makeIcon(GoogleMaterialDesignIcons iconName){
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

		Icon icon = IconFontSwing.buildIcon(iconName, 32, MaterialColor.TEAL_400);

		JLabel ico = new JLabel();
		ico.setIcon(icon);
		return ico;
	}

	public static JPanel stylizedInsidePane(String title){
		JPanel insidePane = new JPanel();
		insidePane.setBackground(MaterialColor.WHITE);
		insidePane.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(
						MaterialColor.TEAL_300,2, true),title));

		((javax.swing.border.TitledBorder) insidePane.getBorder()).
				setTitleFont(Roboto.REGULAR.deriveFont(16.0F));

		((javax.swing.border.TitledBorder) insidePane.getBorder()).
				setTitleColor(MaterialColor.TEAL_400);

		((javax.swing.border.TitledBorder) insidePane.getBorder())
				.setTitleJustification(TitledBorder.CENTER);

		insidePane.setLayout(new GridBagLayout());
		return insidePane;
	}

	public static GridBagConstraints componentPosition(int x,int y, Flex hFlex){
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.ipady = 54; // Altura padrão dos components
		constraint.insets = new Insets(0,5,5,5); // Borda Padrão
		constraint.fill = hFlex.getFlex();

		switch (hFlex){
			case HORIZONTAL:
				constraint.weightx = 1;
				break;
			case VERTICAL:
				constraint.weighty = 1;
				break;
			case BOTH:
				constraint.weightx = 1;
				constraint.weighty = 1;
				break;
			case NONE:
				constraint.weighty = 0;
				constraint.weightx = 0;
				break;
		}

		constraint.gridx = x;
		constraint.gridy = y;

		return constraint;
	}

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
