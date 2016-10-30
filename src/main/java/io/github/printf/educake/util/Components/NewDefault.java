package io.github.printf.educake.util.Components;

import com.esotericsoftware.tablelayout.swing.Table;
import de.craften.ui.swingmaterial.MaterialTextField;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class NewDefault extends Table {

  public NewDefault() {
    JLabel nameLabel = new JLabel("Name:");
    MaterialTextField nameText = new MaterialTextField();
    JLabel addressLabel = new JLabel("Address:");
    MaterialTextField addressText = new MaterialTextField();

    addCell(nameLabel);              // Row 0, column 0.
    addCell(nameText).width(100).height(42);    // Row 0, column 1.
    row();                       // Move to next row.
    addCell(addressLabel);           // Row 1, column 0.
    addCell(addressText).width(100); // Row 1, column 1.
  }
}
