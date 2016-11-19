package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.MaterialColor;
import jiconfont.icons.GoogleMaterialDesignIcons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.HashMap;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ThumbPanel extends JPanel{

  private final ComponentFactory component = new ComponentFactory();
//  private JLabel edit = component.addIconButton(GoogleMaterialDesignIcons.EDIT);
//  private JLabel delete = component.addIconButton(GoogleMaterialDesignIcons.DELETE);
  private HashMap<String, JLabel> buttons = new HashMap<>();
  private String iconsConstraints = "w 32px!, h 32px!, right";

  public ThumbPanel(String...fields) {
    setLayout(new MigLayout("inset 5 15 5 5", "[grow]", "")); // Row constraints with default align
    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, MaterialColor.TEAL_400));
    String width = "width  :"+(100/fields.length)+"%:";

    for(String field : fields){
      add(component.addLabel(field), width);
    }

//    add(edit, iconsConstraints);
//    add(delete, iconsConstraints);
//    buttons.put("edit", edit);
//    buttons.put("delete", delete);
  }

  public ThumbPanel(String text){
    setLayout(new MigLayout("inset 5 15 5 5", "[grow]", "")); // Row constraints with default align
    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, MaterialColor.TEAL_400));

    JLabel label = component.addLabel(text);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    add(label, "w 100%");
  }

  public JLabel getButtonbyId(String id) {
    return buttons.get(id);
  }

  public void addButton(String id, GoogleMaterialDesignIcons icon){
    JLabel button = component.addIconButton(icon);
    add(button, iconsConstraints);
    buttons.put(id, button);
  }
  
}
