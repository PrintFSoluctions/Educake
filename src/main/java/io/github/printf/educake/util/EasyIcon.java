package io.github.printf.educake.util;

import de.craften.ui.swingmaterial.MaterialColor;
import jiconfont.icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;
/**
 * Created by Vitor on 03/10/2016.
 */
public class EasyIcon {

	static Font font;

	public EasyIcon() {

	}

	public static JLabel makeIcon(GoogleMaterialDesignIcons iconName){
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

		Icon icon = IconFontSwing.buildIcon(iconName, 32, MaterialColor.TEAL_400);

		JLabel ico = new JLabel();
		ico.setIcon(icon);
		return ico;
	}
}
