import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.geom.Rectangle2D;

public class UmlClass extends BasicObject {
  public Rectangle2D.Double objectBorder;

  public UmlClass(Point p){
    this.P_START = p;
    this.HEIGHT = 120;
    this.WIDTH =90;
    this.NUM_OF_LINE = 2;
    setPort();
    setPortArea();
    System.out.println(PORT_TOP);
    System.out.println(PORT_BOTTOM);
    System.out.println(PORT_LEFT);
    System.out.println(PORT_RIGHT);
    objectBorder = new Rectangle2D.Double(P_START.x,P_START.y,WIDTH,HEIGHT);
  }

  public Point getStartPoint(Point p, int numLine){
    Point pStart = new Point();
    pStart.x = p.x;
    pStart.y = p.y + numLine * (HEIGHT/(NUM_OF_LINE+1));
    return pStart;
  }
  
  public Point getEndPoint(Point p, int numLine){
    Point pEnd = new Point();
    pEnd.x = p.x + WIDTH;
    pEnd.y = p.y + numLine * (HEIGHT/(NUM_OF_LINE+1));
    return pEnd;
  }

  public boolean containPoint(Point p){
    return objectBorder.contains(p);
  }

  @Override
  public void draw(Graphics g){
    //System.out.println("Drawing...");
    Point pStart, pEnd;
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    g2d.drawRect(P_START.x, P_START.y, WIDTH, HEIGHT);
    
    for(int i=1; i<=NUM_OF_LINE; i++){
      //System.out.println("Drawing line...");
      pStart = getStartPoint(P_START, i);
      pEnd = getEndPoint(P_START,i);
      g2d.drawLine(pStart.x, pStart.y, pEnd.x, pEnd.y);
    }

    if(inSelectMode){
      drawPort(g2d);
    }
  }
}
