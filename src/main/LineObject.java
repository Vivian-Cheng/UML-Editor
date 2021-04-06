import javax.swing.*;
import java.awt.*;

public class LineObject extends Shape {
  public Port P_START;
  public Port P_END;
  public Point PASS_POINT_1 = new Point();
  public Point PASS_POINT_2 = new Point();
  public int ARROR_LENGTH;
  public void draw(Graphics g){}
  public void setPassPoint(){
    PASS_POINT_1.x = (P_START.x + P_END.x)/2;
    PASS_POINT_2.x = (P_START.x + P_END.x)/2;
    PASS_POINT_1.y = P_START.y;
    PASS_POINT_2.y = P_END.y;
  }

  public void drawArrowLine(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    //g2d.drawLine(P_START.x, P_START.y, P_END.x, P_END.y);
    
    g2d.drawLine(P_START.x, P_START.y, PASS_POINT_1.x, PASS_POINT_1.y);
    g2d.drawLine(PASS_POINT_1.x, PASS_POINT_1.y, PASS_POINT_2.x, PASS_POINT_2.y);
    g2d.drawLine(PASS_POINT_2.x, PASS_POINT_2.y, P_END.x, P_END.y);
    
  }
  public void drawArrowHead(Graphics g){}

}
