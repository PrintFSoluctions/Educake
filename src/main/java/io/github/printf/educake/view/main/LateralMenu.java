package io.github.printf.educake.view.main;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.ComponentFactory;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class LateralMenu extends JPanel {
  private final String[][] panelNames = new String[][]{
      {"Student", "Aluno"},
      {"Teacher", "Professor"},
      {"Reports", "Relatórios"}
  };

  CardLayout cardLayout;
  private List<MaterialButton> buttons = new ArrayList<>();
  private final ComponentFactory component = new ComponentFactory();


  public LateralMenu(CardsPanel cards) {
    cardLayout = (CardLayout) cards.getLayout();
    JLabel educakeLogo = component.addIcon("logo.png");

    setLayout(new MigLayout("flowy, novisualpadding","",""));
    setBackground(MaterialColor.TEAL_600);
    setPreferredSize(new Dimension(150, 200));

    add(educakeLogo, "h 70px!, x visual.width/2-20px");

      for (int i = 0; i < panelNames.length; i++) {
        String[] panelName = panelNames[i];

        MaterialButton button = component.addTitleButton(panelName[1]);

        buttons.add(button);
        String constraints = "h 70px!, w 180px!, x -10px, y 76+"+(i*50);
        add(button, constraints);

        button.addActionListener(e -> cardLayout.show(cards, panelName[0]));
      }

  }
}
