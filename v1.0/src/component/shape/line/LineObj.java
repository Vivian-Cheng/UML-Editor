package component.shape.line;

import gui.Canvas;
import component.Port;
import component.shape.ShapeObj;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public abstract class LineObj extends ShapeObj {
  protected Port startPort;
  protected Port endPort;
  protected Point arrowPoint1 = new Point();
  protected Point arrowPoint2 = new Point();
  protected Point arrowPoint3 = new Point();
  protected static final int ARROW_SIZE = 5;

  protected LineObj(Port startPort, Port endPort) {
    this.startPort = startPort;
    this.endPort = endPort;
    this.startPort.lineList.add(this);
    this.endPort.lineList.add(this);
    setArrowPoint();
    depth = Canvas.getInstance().objDepthCounter;
    Canvas.getInstance().objDepthCounter --;
  }

  public void setArrowPoint() {
    switch (endPort.position) {
      case "North":
        arrowPoint1.x = endPort.x - ARROW_SIZE;
        arrowPoint1.y = endPort.y - ARROW_SIZE;
        arrowPoint2.x = endPort.x + ARROW_SIZE;
        arrowPoint2.y = endPort.y - ARROW_SIZE;
        arrowPoint3.x = endPort.x;
        arrowPoint3.y = endPort.y - ARROW_SIZE * 2;
        break;
      case "East":
        arrowPoint1.x = endPort.x + ARROW_SIZE;
        arrowPoint1.y = endPort.y + ARROW_SIZE;
        arrowPoint2.x = endPort.x + ARROW_SIZE;
        arrowPoint2.y = endPort.y - ARROW_SIZE;
        arrowPoint3.x = endPort.x + ARROW_SIZE * 2;
        arrowPoint3.y = endPort.y;
        break;
      case "South":
        arrowPoint1.x = endPort.x - ARROW_SIZE;
        arrowPoint1.y = endPort.y + ARROW_SIZE;
        arrowPoint2.x = endPort.x + ARROW_SIZE;
        arrowPoint2.y = endPort.y + ARROW_SIZE;
        arrowPoint3.x = endPort.x;
        arrowPoint3.y = endPort.y + ARROW_SIZE * 2;
        break;
      case "West":
        arrowPoint1.x = endPort.x - ARROW_SIZE;
        arrowPoint1.y = endPort.y - ARROW_SIZE;
        arrowPoint2.x = endPort.x - ARROW_SIZE;
        arrowPoint2.y = endPort.y + ARROW_SIZE;
        arrowPoint3.x = endPort.x - ARROW_SIZE * 2;
        arrowPoint3.y = endPort.y;
        break;
      default:
        break;
    }
  }

  @Override
	public void draw(Graphics2D g2d) {
    setArrowPoint();
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(THICKNESS));
    g2d.drawLine(startPort.x, startPort.y, endPort.x , endPort.y);
    drawArrow(g2d);
  }

  public abstract void drawArrow(Graphics2D g2d);
}
