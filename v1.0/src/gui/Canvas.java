package gui;

import mode.Mode;
import component.shape.ShapeObj;
import component.shape.line.LineObj;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Canvas extends JPanel {
  private static Canvas uniqueCanvas;
  public static int objDepthCounter = 99;
  protected Mode currentMode = new Mode();
  public static List<ShapeObj> shapeList = new ArrayList<>();

  /* Singleton Design Pattern */
  private Canvas() {}

  public static Canvas getInstance() {
    if (uniqueCanvas == null) {
      uniqueCanvas = new Canvas();
      uniqueCanvas.setBackground(new Color(255, 250, 250)); // Color: Snow
    }
    return uniqueCanvas;
  }

  public void setCurrentMode(Mode mode) {
    removeMouseListener(currentMode);
    currentMode = mode;
    addMouseListener(currentMode);
  }

  public Mode getCurrentMode() {
    return currentMode;
  }

  @Override
	public void paintComponent(Graphics g) {
    super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
    // sort the List by depth before drawing shape objects
		Collections.sort(shapeList,Collections.reverseOrder());
		for (ShapeObj shape : shapeList) {
			shape.draw(g2d);
		}
	}
}
