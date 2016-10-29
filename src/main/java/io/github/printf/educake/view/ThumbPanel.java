package io.github.printf.educake.view;

import de.craften.ui.swingmaterial.MaterialColor;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ThumbPanel extends JPanel{

  GridBagConstraints gc = new GridBagConstraints();

  public ThumbPanel(String...fields) throws Exception {
    setBorder(BorderFactory.createLineBorder(MaterialColor.TEAL_200, 2, true));
    setLayout(new GridBagLayout());
    init(fields);
  }

  private void init(String[] fields) throws Exception {
    gc.weightx = 1;
    gc.anchor = GridBagConstraints.LINE_START;
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.insets = new Insets(0,0,0,0);

    for(String field : fields){
      gc.gridx++;
      JLabel label = new JLabel(field);
      add(label, gc);
    }
  }
}
