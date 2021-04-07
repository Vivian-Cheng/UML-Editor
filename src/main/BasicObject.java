import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class BasicObject extends Shape {
  public void draw(Graphics g){}
  public Point P_START;
  public int HEIGHT;
  public int WIDTH;
  public int NUM_OF_LINE;
  public Port PORT_TOP = new Port();
  public Port PORT_BOTTOM = new Port();
  public Port PORT_LEFT = new Port();
  public Port PORT_RIGHT = new Port();
  public Path2D PORT_TOP_AREA = new Path2D.Double();
  public Path2D PORT_BOTTOM_AREA = new Path2D.Double();
  public Path2D PORT_LEFT_AREA = new Path2D.Double();
  public Path2D PORT_RIGHT_AREA = new Path2D.Double();
  //public Rectangle2D.Double REGION = new Rectangle2D.Double();
  

  public void setPort(){
    PORT_TOP.x = P_START.x + (WIDTH/2);
    PORT_TOP.y = P_START.y;
    PORT_TOP.setPosition("top");
    PORT_BOTTOM.x = P_START.x + (WIDTH/2);
    PORT_BOTTOM.y = P_START.y + HEIGHT;
    PORT_BOTTOM.setPosition("bottom");
    PORT_RIGHT.x = P_START.x + WIDTH;
    PORT_RIGHT.y = P_START.y + (HEIGHT/2);
    PORT_RIGHT.setPosition("right");
    PORT_LEFT.x = P_START.x;
    PORT_LEFT.y = P_START.y + (HEIGHT/2);
    PORT_LEFT.setPosition("left");
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
  public Port getPort(Point p){
    Port port;
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

  public void setRegion(Point p, int width, int height){
    this.REGION = new Rectangle2D.Double(p.x, p.y, width, height);
  }

  public Rectangle2D.Double getRegion(){
    return REGION;
  }

  public void drawPort(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    g2d.fillRect((PORT_TOP.x - 2), (PORT_TOP.y - 4), 4, 4);
    g2d.fillRect((PORT_BOTTOM.x - 2), PORT_BOTTOM.y, 4, 4);
    g2d.fillRect((PORT_LEFT.x - 4), (PORT_LEFT.y - 2), 4, 4);
    g2d.fillRect((PORT_RIGHT.x), (PORT_RIGHT.y - 2), 4, 4);
  }



  

}
