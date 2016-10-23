package io.github.printf.educake.view.main;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import io.github.printf.educake.util.Components.DefaultFormPanel;
import io.github.printf.educake.util.Enums.Division;
import io.github.printf.educake.util.Enums.Flex;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class LateralMenu extends DefaultFormPanel {
  private final String[][] panelNames = new String[][]{
      {"Student", "Aluno"},
      {"Teacher", "Professor"},
      {"Reports", "Relatórios"}
  };

  CardLayout cardLayout;
  private List<MaterialButton> buttons = new ArrayList<MaterialButton>();


  public LateralMenu(CardsPanel cards) {
    cardLayout = (CardLayout) cards.getLayout();

    try {
      ImageIcon icon = new ImageIcon("src/main/resources/Images/logo.png");

      JLabel educakeLogo = makeGrid(Division.HEADER, Flex.HORIZONTAL)
          .setHeight(16).addLabel("");
      educakeLogo.setHorizontalAlignment(JLabel.CENTER);
      educakeLogo.setVerticalAlignment(JLabel.CENTER);

      educakeLogo.setIcon(icon);
      addRow();

      setBackground(MaterialColor.TEAL_600);
      getHeader().setBackground(MaterialColor.TEAL_600);

      for (int i = 0; i < panelNames.length; i++) {
        String[] panelName = panelNames[i];
        buttons.add(makeGrid(Division.HEADER, Flex.HORIZONTAL)
            .setInset(-10,-0,-10,-20)
            .addTitleButton(panelName[1]));
        buttons.get(i).addActionListener(e -> cardLayout.show(cards, panelName[0]));
        addRow();
      }

      setPreferredSize(new Dimension(150, 200));
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
