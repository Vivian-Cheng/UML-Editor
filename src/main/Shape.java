import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Shape {
  public boolean inSelectMode;
  public Rectangle2D.Double REGION = new Rectangle2D.Double();
  public void draw(Graphics g){}

  public boolean containPoint(Point p){
    return false;
  }

  public Port getPort(Point p){
    Port port = new Port();
    return port;
  }
}
