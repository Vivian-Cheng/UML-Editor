package component.shape;

import gui.Canvas;

import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public abstract class ShapeObj implements Comparable<ShapeObj> {
  protected static final int THICKNESS = 2;
  public int depth;
  public Point origin = new Point();
  public Point destination = new Point();
  public Rectangle2D.Double objRegion;
  protected boolean isSelected;
  protected boolean isMoved;

  public void setSelect(boolean isSelected) {
    this.isSelected = isSelected;
  }

  public boolean getSelect() {
    return isSelected;
  }

  public boolean containPoint(Point p) {
    if (objRegion == null) {
      return false;
    } else {
      return objRegion.contains(p);
    }
  }

  public boolean isInside(Path2D selectArea) {
    if (objRegion == null) {
      return false;
    } else {
      return selectArea.contains(objRegion);
    }
  }

  public void reset(Point pressPoint, Point releasePoint){}

  public abstract void draw(Graphics2D g2d);
  
  @Override
  public int compareTo(ShapeObj shape) {
    return this.depth -  shape.depth; // sort from small to big
  }
}
