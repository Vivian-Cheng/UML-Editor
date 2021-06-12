package component.shape.line;

import component.Port;

import java.awt.Graphics2D;

public class AssocLine extends LineObj {
  public AssocLine(Port startPort, Port endPort) {
    super(startPort, endPort);
  }

  @Override
  public void drawArrow(Graphics2D g2d) {
    g2d.drawLine(endPort.x, endPort.y, arrowPoint1.x, arrowPoint1.y);
    g2d.drawLine(endPort.x, endPort.y, arrowPoint2.x, arrowPoint2.y);
  }
}
