package component.shape.basic;

import gui.Canvas;
import component.Port;
import component.shape.ShapeObj;

import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public abstract class BasicObj extends ShapeObj {
  protected static final int FONTSIZE = 12;
  private int width;
	private int height;
  public String objName;

  /* The other vertex of the object, origin and destination have been set in super class */
  public Point nePoint = new Point();
  public Point swPoint = new Point();
  public Point center = new Point();

  /* The port of the object */
  public ArrayList<Port> portList = new ArrayList<>(4);

  public BasicObj(Point origin, int width, int height) {
    this.width = width;
    this.height = height;
    this.origin = origin;
    depth = Canvas.getInstance().objDepthCounter;
    Canvas.getInstance().objDepthCounter --;
    setRegion(origin, width, height);
    setVertex();
    setPort();
  }

  public void setVertex() {
    nePoint.x = origin.x + width;
    nePoint.y = origin.y;
    swPoint.x = origin.x;
    swPoint.y = origin.y + height;
    destination.x = origin.x + width;
    destination.y = origin.y + height;
    center.x = origin.x + width / 2;
    center.y = origin.y + height / 2;
  }

  public void setPort() {
    portList.clear();
    portList.add(new Port(this, (origin.x + width / 2), origin.y, "North"));
    portList.add(new Port(this, (origin.x + width), (origin.y + height / 2), "East"));
    portList.add(new Port(this, (origin.x + width / 2), (origin.y + height), "South"));
    portList.add(new Port(this, origin.x, (origin.y + height / 2), "West"));
  }

  public Port getNearPort(Point p) {
    if (objRegion.contains(p)) {
      for (Port port : portList) {
        if (port.portArea.contains(p)) {
          return port;
        }
      }
    } else {
      return null;
    }
    return null;
  }

  public void setRegion(Point origin, int width, int height) {
    objRegion = new Rectangle2D.Double(origin.x,origin.y,width,height);
  }

  @Override
  public void reset(Point pressPoint, Point releasePoint) {
    origin.x = origin.x + (releasePoint.x - pressPoint.x);
    origin.y = origin.y + (releasePoint.y - pressPoint.y);
    setRegion(origin, width, height);
    setVertex();
    for (Port port : portList) {
      port.reset(pressPoint, releasePoint);
    }
  }

  @Override
	public void draw(Graphics2D g2d) {}

  public abstract void showObjName(Graphics2D g2d);
  
}
