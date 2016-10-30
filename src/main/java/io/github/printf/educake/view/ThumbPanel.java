package io.github.printf.educake.view;

import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.NewDefaultFormPanel;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ThumbPanel extends NewDefaultFormPanel{

  public ThumbPanel(String...fields) {
    setBorder(BorderFactory.createLineBorder(MaterialColor.TEAL_200, 2, true));
    for(String field : fields){
      addLabel(field);
    }
  }

}
