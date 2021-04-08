import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;

public class Shape {
  public boolean inSelectMode = false;
  public boolean isComposite = false;
  public Point P_START = new Point();
  public Port PORT_TOP = new Port();
  public Port PORT_BOTTOM = new Port();
  public Port PORT_LEFT = new Port();
  public Port PORT_RIGHT = new Port();
  public Rectangle2D.Double REGION = new Rectangle2D.Double();
  public List<Shape> objList = new ArrayList<Shape>();
  public void draw(Graphics g){}
  public String objectName = "";

  public void reset(Point p){}

  public void setObjName(String objectName){
    this.objectName = objectName;
  }

  public void setSelectMode(boolean inSelectMode){
    this.inSelectMode = inSelectMode;
  }

  public boolean getSelectMode(){
    return inSelectMode;
  }

  public boolean containPoint(Point p){
    return false;
  }

  public Port getPort(Point p){
    Port port = new Port();
    return port;
  }

  public boolean isContained(Rectangle2D.Double selectRegion){
    return false;
  }
}
