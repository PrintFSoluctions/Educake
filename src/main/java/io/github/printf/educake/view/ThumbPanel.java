package io.github.printf.educake.view;

import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.NewDefaultFormPanel;
import jiconfont.icons.GoogleMaterialDesignIcons;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ThumbPanel extends NewDefaultFormPanel{

  public ThumbPanel(String...fields) {
    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, MaterialColor.TEAL_400));
    for(String field : fields){
      addLabel(field);
    }
    addIcon(GoogleMaterialDesignIcons.EDIT);
    cell.width(50).expand(false,false);
    addIcon(GoogleMaterialDesignIcons.DELETE);
    cell.width(50).expand(false,false);
  }

}
