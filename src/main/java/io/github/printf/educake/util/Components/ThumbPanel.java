package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.MaterialColor;
import jiconfont.icons.GoogleMaterialDesignIcons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ThumbPanel extends JPanel{

  private final ComponentFactory component = new ComponentFactory();

  public ThumbPanel(String...fields) {
    setLayout(new MigLayout("inset 5 15 5 5", "[grow]", "")); // Row constraints with default align
    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, MaterialColor.TEAL_400));
    String width = "width  :"+(100/fields.length)+"%:";

    for(String field : fields){
      add(component.addLabel(field), width);
    }

    String IconsConstraints = "w 32px!, h 32px!, right";
    add(component.addIconButton(GoogleMaterialDesignIcons.EDIT), IconsConstraints);
    add(component.addIconButton(GoogleMaterialDesignIcons.DELETE), IconsConstraints);
  }

  public ThumbPanel(String text){
    setLayout(new MigLayout("inset 5 15 5 5", "[grow]", "")); // Row constraints with default align
    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, MaterialColor.TEAL_400));

    JLabel label = component.addLabel(text);
    label.setHorizontalAlignment(SwingConstants.CENTER);
      add(label, "w 100%");
  }

}
