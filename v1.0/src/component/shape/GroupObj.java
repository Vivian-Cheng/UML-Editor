package component.shape;

import gui.Canvas;
import gui.Window;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.ArrayList;

public class GroupObj extends ShapeObj {
  private int width;
  private int height;
  private int maxX = 0;
  private int minX = Window.WINDOW_WIDTH;
  private int maxY = 0;
  private int minY = Window.WINDOW_HEIGHT;
  public List<ShapeObj> container = new ArrayList<>();

  public GroupObj(List<ShapeObj> container) {
    depth = Canvas.getInstance().objDepthCounter;
    Canvas.getInstance().objDepthCounter --;
    addChild(container);
    setSize();
    setVertex();
    setRegion(origin, width, height);
  }

  public void addChild(List<ShapeObj> container) {
    for (ShapeObj shapeObj : container) {
      shapeObj.depth = depth;
      this.container.add(shapeObj);
    }
  }

  public void setSize() {
    for (ShapeObj shapeObj : container) {
      if (shapeObj.objRegion != null) {
        width = findWidth(shapeObj);
        height = findHeight(shapeObj);
      }
    }
  }

  public void setVertex() {
    origin.x = minX;
    origin.y = minY;
    destination.x = maxX;
    destination.y = maxY;
  }

  private int findWidth(ShapeObj shapeObj) {
    if (maxX < shapeObj.destination.x)
      maxX = shapeObj.destination.x;
    if (minX > shapeObj.origin.x)
      minX = shapeObj.origin.x;
    return maxX - minX;
  }

  private int findHeight(ShapeObj shapeObj) {
    if (maxY < shapeObj.destination.y)
      maxY = shapeObj.destination.y;
    if (minY > shapeObj.origin.y)
      minY = shapeObj.origin.y;
    return maxY - minY;
  }

  public void setRegion(Point origin, int width, int height) {
    objRegion = new Rectangle2D.Double(origin.x,origin.y,width,height);
  }

  @Override
  public void setSelect(boolean isSelected) {
    for (ShapeObj shapeObj : container) {
      shapeObj.setSelect(isSelected);
    }
    this.isSelected = isSelected;
  }

  @Override
  public void reset(Point pressPoint, Point releasePoint) {
    minX = minX + (releasePoint.x - pressPoint.x);
    minY = minY + (releasePoint.y - pressPoint.y);
    maxX = minX + width;
    maxY = minY + height;
    setVertex();
    setRegion(origin, width, height);
    for ( ShapeObj shapeObj : container) {
      shapeObj.reset(pressPoint, releasePoint);
    }
  }

  @Override
	public void draw(Graphics2D g2d) {
    for (ShapeObj shapeObj : container) {
      shapeObj.draw(g2d);
    }
    if (getSelect()) {
      g2d.setColor(new Color(188, 143, 143));
      g2d.drawRect(origin.x, origin.y, width, height);
    }
  }
}
