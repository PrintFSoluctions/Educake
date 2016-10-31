package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.*;
import jiconfont.icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.Map;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ComponentFactory {

  private final Color BUTTON_COLOR = MaterialColor.TEAL_500;
  private final Color TITLE_BUTTON_COLOR = MaterialColor.TEAL_300;

  public ComponentFactory() {
    IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont()); // Registra a fonte de icones
  }

  public JLabel addIcon(GoogleMaterialDesignIcons iconName) {
    Icon iconFont = IconFontSwing.buildIcon(iconName, 32, MaterialColor.TEAL_400);
    JLabel icon = new JLabel();
    icon.setIcon(iconFont);
    icon.setHorizontalAlignment(SwingConstants.CENTER);

    return icon;
  }

  public JLabel addIcon(String image){
    JLabel icon = new JLabel();

    icon.setHorizontalAlignment(JLabel.CENTER);
    icon.setVerticalAlignment(JLabel.CENTER);
    icon.setIcon(new ImageIcon("src/main/resources/Images/"+image));

    return icon;
  }

  public JLabel addIconButton(GoogleMaterialDesignIcons iconName){
    Icon iconFont = IconFontSwing.buildIcon(iconName, 32, MaterialColor.TEAL_200);
    JLabel icon = new JLabel();
    icon.setIcon(iconFont);
    icon.setHorizontalAlignment(SwingConstants.CENTER);
    icon.setBackground(BUTTON_COLOR);
    icon.setBorder(BorderFactory.createLineBorder(MaterialColor.TEAL_700));
    icon.setOpaque(true);

    return icon;
  }

  public JLabel addLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(Roboto.REGULAR.deriveFont(14.0F));

    return label;
  }

  public JLabel addTitleLabel(String text) {
    JLabel label = new JLabel("   " + text);
    label.setFont(Roboto.BOLD.deriveFont(26.0F));
    label.setForeground(MaterialColor.WHITE);

    return label;
  }

  public MaterialTextField addTextField(String label) {
    MaterialTextField textField = new MaterialTextField();
    textField.setLabel(label);

    return textField;
  }

  public MaterialTextField addTextField(String label, String hint) {
    MaterialTextField textField = addTextField(label);
    textField.setHint(hint);
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

    return textField;
  }

  public MaterialComboBox addComboBox(String... items) {
    MaterialComboBox combo = new MaterialComboBox();
    for (String item : items) combo.addItem(item);

    return combo;
  }

  public MaterialComboBox addComboBox(Map<String, String> items, int preselected) {
    MaterialComboBox combo = new MaterialComboBox();

    items.forEach((key, value) -> combo.addItem(new ComboItem(key, value)));
    combo.setSelectedIndex(preselected);

    return combo;
  }

  public MaterialComboBox addComboBox(Map<String, String> items) {
    return addComboBox(items, 0);
  }

  public MaterialButton addTitleButton(String label) {
    MaterialButton button = new MaterialButton();
    button.setText(label);
    button.setForeground(MaterialColor.WHITE);
    button.setBackground(TITLE_BUTTON_COLOR);

    return button;
  }

  public MaterialButton addButton(String label) {
    MaterialButton button = new MaterialButton();
    button.setText(label);
    button.setForeground(MaterialColor.WHITE);
    button.setBackground(BUTTON_COLOR);

    return button;
  }

  public JCheckBox addCheckBox(String label) {
    JCheckBox check = new JCheckBox();
    check.setText(label);

    return check;
  }

  public JPanel header(String title, String... actions){
    JPanel header = new JPanel();
    header.setBackground(MaterialColor.TEAL_500);
    header.setBorder(BorderFactory.createMatteBorder(0,0,1,0,MaterialColor.TEAL_700));
    header.setLayout(new MigLayout("inset 6 0 -1 0", "grow", ""));

    header.add(addTitleLabel(title), "west, h 80px!, ay baseline");

    for (int i = 0; i < actions.length; i++) {
      String action = actions[i];
      String constraint = "width 150px!, h 80px!, x2 100%-"+(i*130)+"px, ay baseline";
      header.add(addTitleButton(action), constraint);
    }

    return header;
  }

}

