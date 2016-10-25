package io.github.printf.educake.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class MainFrame extends JFrame{
  private CardsPanel cards;

  public MainFrame() throws HeadlessException {
    setTitle("Educake");

    JMenuBar bar = new JMenuBar();
    bar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    JMenu menu = new JMenu("{ @UserName }");
    JMenuItem sair = new JMenuItem("Sair");
    sair.addActionListener(e -> {this.dispose(); System.exit(0);});

    bar.add(menu);
    menu.add(sair);

    cards = new CardsPanel();
    cards.setMinimumSize(new Dimension(600,400));
    cards.setPreferredSize(new Dimension(600,700));

    LateralMenu lateralMenu = new LateralMenu(cards);

    add(bar, BorderLayout.PAGE_START);
    add(cards, BorderLayout.CENTER);
    add(lateralMenu, BorderLayout.LINE_START);

    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public CardsPanel getCards() { return cards; }
}
