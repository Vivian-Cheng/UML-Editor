package gui;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;

public class Window {
  protected JFrame frame;
  private Canvas canvas;
  private Color backgroundColor = new Color(250, 235, 215);
  public static final int WINDOW_WIDTH = 900;
	public static final int WINDOW_HEIGHT = 600;

  public void run() {
    frame = new JFrame("UML Editor");

    canvas = Canvas.getInstance();
    frame.getContentPane().add(BorderLayout.CENTER, canvas);

    ButtonPanel buttonPanel = new ButtonPanel();
    frame.getContentPane().add(BorderLayout.WEST, buttonPanel.buttonPanel);

    MenuBar menu = new MenuBar();
    frame.setJMenuBar(menu.menuBar);

    frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(backgroundColor);
  }
}
