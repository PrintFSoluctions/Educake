package io.github.printf.educake.util.Components;

import de.craften.ui.swingmaterial.MaterialColor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public abstract class DefaultView extends JPanel{
  protected MigLayout layout = new MigLayout("insets 4 4 4 4, flowy, w 100%", "grow");
  protected TitlePanel titlePanel;
  protected JPanel body  = new JPanel();
  protected int id;
  private JScrollPane scroll = new JScrollPane(body);

  public DefaultView(String title, String...buttons) {
    titlePanel = new TitlePanel(title, buttons);
    setBackground(MaterialColor.WHITE);
    setLayout(layout);
    body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
    scroll.setBorder(null);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    add(titlePanel, "north");
    add(scroll, "w 100%");
  }

  public void reset(){
    if(getPanels() != null){
      for (JPanel resetable : getPanels()) {
        ((Resetable)resetable).reset();
      }
    }
  }

  public abstract JPanel[] getPanels();

  public void setId(int id) {
    this.id = id;
    fillForm();
  }

  public int getId(){return this.id;}

  public void fillForm(){}

}
