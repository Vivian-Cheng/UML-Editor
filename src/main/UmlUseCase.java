import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UmlUseCase extends BasicObject {
  public Ellipse2D.Double objectBorder;

  public UmlUseCase(Point p){
    this.P_START = p;
    this.HEIGHT = 80;
    this.WIDTH = 100;
    setPort();
    setPortArea();
    System.out.println(PORT_TOP);
    System.out.println(PORT_BOTTOM);
    System.out.println(PORT_LEFT);
    System.out.println(PORT_RIGHT);
    objectBorder = new Ellipse2D.Double(P_START.x,P_START.y,WIDTH,HEIGHT);
    
  }

  public boolean containPoint(Point p){
    return objectBorder.contains(p);
  }

  @Override
  public void draw(Graphics g){
    //System.out.println("Drawing...");
    g.setColor(Color.BLACK);
    g.drawOval(P_START.x, P_START.y, WIDTH, HEIGHT);
  }
}
