package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.HashMap;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class TitlePanel extends JPanel {

  private final ComponentFactory component = new ComponentFactory();
  private final HashMap<String, MaterialButton> buttons  = new HashMap<>();
  private final String[] actions;

  public TitlePanel(String title, String... actions) {
    this.actions = actions;
    setBackground(MaterialColor.TEAL_500);
    setBorder(BorderFactory.createMatteBorder(0,0,1,0,MaterialColor.TEAL_700));
    setLayout(new MigLayout("inset 6 0 -1 0", "grow", ""));

    add(component.addTitleLabel(title), "west, h 80px!, ay baseline");

    for (int i = 0; i < actions.length; i++) {
      String action = actions[i];
      String constraint = "wmin button*2 , h 80px!, x2 100%-"+i+"*(button*1.7), ay baseline, id "+action;
      MaterialButton button = component.addTitleButton(action);

      buttons.put(action, button);
      add(button, constraint);
    }
  }

  public MaterialButton getButton(int i){
    return buttons.get(actions[i]);
  }

  public MaterialButton getButton(String key){
    return buttons.get(key);
  }
}
