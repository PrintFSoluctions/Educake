package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.MaterialColor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class DefaultView extends JPanel{
  protected TitlePanel titlePanel;
  protected JPanel body  = new JPanel();
  private JScrollPane scroll = new JScrollPane(body);

  public DefaultView(String title, String...buttons) {
    titlePanel = new TitlePanel(title, buttons);
    setBackground(MaterialColor.WHITE);
    setLayout(new MigLayout("insets 4 4 4 4, flowy, w 100%", "grow"));
    body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
    scroll.setBorder(null);

    add(titlePanel, "north");
    add(scroll, "w 100%");
  }
}
