package component.shape.basic;

import component.Port;

import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;

public class UseCaseObj extends BasicObj {
  private static int width = 100;
	private static int height = 60;

  public UseCaseObj(Point origin) {
		super(origin, width, height);
	}

  @Override
	public void draw(Graphics2D g2d) {
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(THICKNESS));
    g2d.drawOval(origin.x, origin.y, width, height);
    /* Show ports when the object is selected */
    if (getSelect()){
      for (Port port : portList) {
        port.showPort(g2d);
      }
    }
    /* Show object name */
    showObjName(g2d);
  }

  @Override
  public void showObjName(Graphics2D g2d) {
    if (objName != null){
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font( "SansSerif", Font.BOLD, FONTSIZE));
			g2d.drawString(objName, origin.x + width/5, origin.y + height/3);
		}
  }
}
