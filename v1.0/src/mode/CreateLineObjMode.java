package mode;

import gui.Canvas;
import component.Port;
import component.shape.line.*;
import component.shape.ShapeObj;
import component.shape.basic.BasicObj;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Collections;

public class CreateLineObjMode extends Mode {
  private Canvas canvas;
  public Point startPoint;
  public Point endPoint;
  public Port startPort;
  public Port endPort;

  public CreateLineObjMode(String modeType) {
    this.modeType = modeType;
		canvas = Canvas.getInstance();
  }

  /* Init process for all flags */
  public void init() {
    startPoint = null;
    endPoint = null;
    startPort = null;
    endPort = null;
  }

  /* Check whether the point in any BasicObj and return the nearest port */
  public Port setConnectPort(Point point, Port port) {
    Collections.sort(canvas.shapeList);
    for (ShapeObj shapeObj : canvas.shapeList) {
      if (shapeObj instanceof BasicObj) {
        port = ((BasicObj) shapeObj).getNearPort(point);
        if (port != null) {
          return port;
        }
      }
    }
    return port;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    init();
    startPoint = e.getPoint();
    startPort = setConnectPort(startPoint, startPort);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (startPort != null) {
      endPoint = e.getPoint();
      endPort = setConnectPort(endPoint, endPort);

      if (endPort == null) return;
      if (startPort.parent == endPort.parent) return;

      switch (modeType) {
        case "assocLine":
          canvas.shapeList.add(new AssocLine(startPort, endPort));
          break;
        case "generalLine":
          canvas.shapeList.add(new GeneralLine(startPort, endPort));
          break;
        case "compLine":
          canvas.shapeList.add(new CompLine(startPort, endPort));
          break;
        default:
          break;
      }
      canvas.repaint();
    }
  }
}
