package component.shape.line;

import component.Port;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class GeneralLine extends LineObj {
  public GeneralLine(Port startPort, Port endPort) {
    super(startPort, endPort);
  }

  @Override
  public void drawArrow(Graphics2D g2d) {
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(THICKNESS));
    g2d.drawPolygon(new int[] {endPort.x, arrowPoint1.x, arrowPoint2.x}, new int[] {endPort.y, arrowPoint1.y, arrowPoint2.y}, 3);
    g2d.setColor(Color.white);
    g2d.fillPolygon(new int[] {endPort.x, arrowPoint1.x, arrowPoint2.x}, new int[] {endPort.y, arrowPoint1.y, arrowPoint2.y}, 3);
  }
}
