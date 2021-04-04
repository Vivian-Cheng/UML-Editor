import javax.swing.*;
import java.awt.*;

public class UseCaseObject extends JPanel{
  Point pStart = new Point();
  public UseCaseObject(Point p){
    pStart = p;
    System.out.println("UseCaseObject constructor");
  }
  
  /*
  @Override
  public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(150, 150, 100, 100);

  }
  */
   @Override
  public void paintComponent(Graphics g) {
    System.out.println("draw");
    // super.paintComponents(g);  // WRONG method!  Broken paint chain
    g.drawOval(pStart.x, pStart.y, 100, 100);
    super.paintComponent(g);
    //g.setColor(Color.BLACK);
    //Graphics2D g2d = (Graphics2D) g;
    //g2d.drawOval(150, 150, 100, 100);
    
    //g.fillRect(100, 100, 100, 100);
  }
  
}
