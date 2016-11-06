package io.github.printf.educake.view.main;

import io.github.printf.educake.util.Components.DefaultView;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class MainFrame extends JFrame{
  private static Routes routes = new Routes();
  private JMenuBar bar = new JMenuBar();
  private LateralMenu lateralMenu = new LateralMenu(routes);
  private JMenu menu = new JMenu("{ @UserName }");
  private JMenuItem sair = new JMenuItem("Sair");

  public MainFrame() throws HeadlessException {
    // Initialize
    setTitle("Educake");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);
    setResizable(false);

    // Menu
    bar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    bar.add(menu);
    menu.add(sair);

    // Components
    add(bar, BorderLayout.PAGE_START);
    add(routes, BorderLayout.CENTER);
    add(lateralMenu, BorderLayout.LINE_START);

    // ActionListeners
    sair.addActionListener(e -> System.exit(0));

    // Show
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void goTo(String route) {
    DefaultView defaultView = routes.getPanels().get(route);
    defaultView.reset();
    ((CardLayout) routes.getLayout()).show(routes, route);
  }
}
