package mode;

import gui.Canvas;
import component.shape.ShapeObj;

import java.awt.Point;
import java.awt.geom.Path2D;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Collections;

public class SelectMode extends Mode {
  private Canvas canvas;
  private Point pressPoint;
  private Point releasePoint;
  private ShapeObj pressedObj;

  public SelectMode(String modeType){
    this.modeType = modeType;
    canvas = Canvas.getInstance();
  }

  public void init() {
    pressPoint = null;
    releasePoint = null;
    pressedObj = null;
  }

  public void setAllSelect(List<ShapeObj> shapeList, boolean isSelected) {
    for (ShapeObj shape : shapeList) {
      shape.setSelect(isSelected);
    }
  }

  public Path2D setSelectArea() {
    Path2D selectArea = new Path2D.Double();
    selectArea.moveTo(pressPoint.x, pressPoint.y);
    selectArea.lineTo(releasePoint.x, pressPoint.y);
    selectArea.lineTo(releasePoint.x, releasePoint.y);
    selectArea.lineTo(pressPoint.x, releasePoint.y);
    selectArea.closePath();
    return selectArea;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    init();
    pressPoint = e.getPoint();
    setAllSelect(canvas.shapeList, false);
    // Sort object from small to big, because we only want to select one
    // that has smallest depth
    Collections.sort(canvas.shapeList);
    for (ShapeObj shapeObj : canvas.shapeList) {
      if (shapeObj.containPoint(pressPoint)) {
        shapeObj.setSelect(true);
        pressedObj = shapeObj;
        break;
      }
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    releasePoint = e.getPoint();
    if (pressedObj != null) {
      // Move objects
      pressedObj.reset(pressPoint, releasePoint);
    } else {
      // Select objects
      Path2D selectArea = setSelectArea();
      Collections.sort(canvas.shapeList);
      for (ShapeObj shapeObj : canvas.shapeList) {
        shapeObj.setSelect(shapeObj.isInside(selectArea));
      }
    }
    canvas.repaint();
  }
}
