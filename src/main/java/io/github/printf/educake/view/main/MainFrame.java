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

    cards = new CardsPanel();
    cards.setMinimumSize(new Dimension(600,400));
    cards.setPreferredSize(new Dimension(600,700));

    JButton c = new JButton("Vertical Menu");

    LateralMenu lateralMenu = new LateralMenu(cards);

    add(c, BorderLayout.PAGE_START);
    add(cards, BorderLayout.CENTER);
    add(lateralMenu, BorderLayout.LINE_START);

    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public CardsPanel getCards() { return cards; }
}
