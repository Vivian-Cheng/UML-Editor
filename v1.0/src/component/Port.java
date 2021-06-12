package component;

import component.shape.basic.BasicObj;
import component.shape.line.LineObj;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Port {
  protected static final int PORT_SIZE = 6;
  public int x;
  public int y;
  public String position; // North, East, South, West
  public Path2D portArea;
  public BasicObj parent;
  public ArrayList<LineObj> lineList = new ArrayList<>();

  public Port(BasicObj parent, int x, int y, String position) {
    this.parent = parent;
    this.x = x;
    this.y = y;
    this.position = position;
    setPortArea();
  }

  public void setPortArea(){
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = new Point();

    switch (position) {
      case "North":
        p1 = parent.origin;
        p2 = parent.center;
        p3 = parent.nePoint;
        break;
      case "East":
        p1 = parent.nePoint;
        p2 = parent.center;
        p3 = parent.destination;
        break;
      case "South":
        p1 = parent.destination;
        p2 = parent.center;
        p3 = parent.swPoint;
        break;
      case "West":
        p1 = parent.swPoint;
        p2 = parent.center;
        p3 = parent.origin;
        break;
      default:
        break;
    }
    Path2D sectorArea = new Path2D.Double();
		sectorArea.moveTo(p1.x, p1.y);
		sectorArea.lineTo(p2.x, p2.y);
		sectorArea.lineTo(p3.x, p3.y);
		sectorArea.closePath();
		portArea = sectorArea;
  }

  public void reset(Point pressPoint, Point releasePoint) {
    x = x + (releasePoint.x - pressPoint.x);
    y = y + (releasePoint.y - pressPoint.y);
    setPortArea();
  }

  public void showPort(Graphics2D g2d) {
    g2d.setColor(Color.BLACK);
    switch (position) {
      case "North":
        g2d.fillRect((x - PORT_SIZE / 2), (y - PORT_SIZE), PORT_SIZE, PORT_SIZE);
        break;
      case "East":
        g2d.fillRect(x, (y - PORT_SIZE / 2), PORT_SIZE, PORT_SIZE);
        break;
      case "South":
        g2d.fillRect((x - PORT_SIZE / 2), y, PORT_SIZE, PORT_SIZE);
        break;
      case "West":
        g2d.fillRect((x - PORT_SIZE), (y - PORT_SIZE / 2), PORT_SIZE, PORT_SIZE);
      default:
        break;
    }
  }
}
