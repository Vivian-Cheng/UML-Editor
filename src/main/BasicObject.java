import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;


public class BasicObject extends Shape {
  public void draw(Graphics g){}
  public Point P_START;
  public int HEIGHT;
  public int WIDTH;
  public int NUM_OF_LINE;
  public Point PORT_TOP = new Point();
  public Point PORT_BOTTOM = new Point();
  public Point PORT_LEFT = new Point();
  public Point PORT_RIGHT = new Point();
  public Path2D PORT_TOP_AREA = new Path2D.Double();
  public Path2D PORT_BOTTOM_AREA = new Path2D.Double();
  public Path2D PORT_LEFT_AREA = new Path2D.Double();
  public Path2D PORT_RIGHT_AREA = new Path2D.Double();

  public void setPort(){
    PORT_TOP.x = P_START.x + (WIDTH/2);
    PORT_TOP.y = P_START.y;
    PORT_BOTTOM.x = P_START.x + (WIDTH/2);
    PORT_BOTTOM.y = P_START.y + HEIGHT;
    PORT_RIGHT.x = P_START.x + WIDTH;
    PORT_RIGHT.y = P_START.y + (HEIGHT/2);
    PORT_LEFT.x = P_START.x;
    PORT_LEFT.y = P_START.y + (HEIGHT/2);
  }

  public void setPortArea(){
    PORT_TOP_AREA.moveTo(P_START.x, P_START.y);
    PORT_TOP_AREA.lineTo((P_START.x + WIDTH), P_START.y);
    PORT_TOP_AREA.lineTo((P_START.x + WIDTH/2), (P_START.y + HEIGHT/2));
    PORT_TOP_AREA.closePath();

    PORT_BOTTOM_AREA.moveTo(P_START.x, (P_START.y + HEIGHT));
    PORT_BOTTOM_AREA.lineTo((P_START.x + WIDTH/2), (P_START.y + HEIGHT/2));
    PORT_BOTTOM_AREA.lineTo((P_START.x + WIDTH), (P_START.y + HEIGHT));
    PORT_BOTTOM_AREA.closePath();

    PORT_LEFT_AREA.moveTo(P_START.x, P_START.y);
    PORT_LEFT_AREA.lineTo((P_START.x + WIDTH/2), (P_START.y + HEIGHT/2));
    PORT_LEFT_AREA.lineTo(P_START.x , (P_START.y + HEIGHT));
    PORT_LEFT_AREA.closePath();

    PORT_RIGHT_AREA.moveTo((P_START.x + WIDTH), P_START.y);
    PORT_RIGHT_AREA.lineTo((P_START.x + WIDTH/2), (P_START.y + HEIGHT/2));
    PORT_RIGHT_AREA.lineTo((P_START.x + WIDTH), (P_START.y + HEIGHT));;
    PORT_RIGHT_AREA.closePath();
  }

  public boolean containPoint(Point p){
    return false;
  }
  public Point getPort(Point p){
    Point port;
    if(PORT_TOP_AREA.contains(p)){
      port = PORT_TOP;
    }else if(PORT_BOTTOM_AREA.contains(p)){
      port = PORT_BOTTOM;
    }else if(PORT_LEFT_AREA.contains(p)){
      port = PORT_LEFT;
    }else{
      port = PORT_RIGHT;
    }
    return port;
  }



  

}