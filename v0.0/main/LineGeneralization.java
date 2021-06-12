import javax.swing.*;
import java.awt.*;

public class LineGeneralization extends LineObject{
  public LineGeneralization(Port pStart, Port pEnd){
    this.P_START = pStart;
    this.P_END = pEnd;
    setPassPoint();
    this.ARROR_LENGTH = 5;
  }

  @Override
  public void drawArrowHead(Graphics g){
    Point pLeft = new Point();
    Point pRight = new Point();
    Graphics2D g2d = (Graphics2D) g;

    switch (P_END.getPosition()) {
      case "top":
        pLeft.x = P_END.x - ARROR_LENGTH;
        pLeft.y = P_END.y - ARROR_LENGTH;
        pRight.x = P_END.x + ARROR_LENGTH;
        pRight.y = P_END.y - ARROR_LENGTH;        
        break;
      case "bottom":
        pLeft.x = P_END.x - ARROR_LENGTH;
        pLeft.y = P_END.y + ARROR_LENGTH;
        pRight.x = P_END.x + ARROR_LENGTH;
        pRight.y = P_END.y + ARROR_LENGTH;        
        break;
      case "left":
        pLeft.x = P_END.x - ARROR_LENGTH;
        pLeft.y = P_END.y + ARROR_LENGTH;
        pRight.x = P_END.x - ARROR_LENGTH;
        pRight.y = P_END.y - ARROR_LENGTH;        
        break;
      case "right":
        pLeft.x = P_END.x + ARROR_LENGTH;
        pLeft.y = P_END.y + ARROR_LENGTH;
        pRight.x = P_END.x + ARROR_LENGTH;
        pRight.y = P_END.y - ARROR_LENGTH;        
        break;
    }
    g2d.setColor(Color.BLACK);
    g2d.drawPolygon(new int[] {P_END.x, pLeft.x, pRight.x}, new int[] {P_END.y, pLeft.y, pRight.y}, 3);
    g2d.setColor(Color.white);
    g2d.fillPolygon(new int[] {P_END.x, pLeft.x, pRight.x}, new int[] {P_END.y, pLeft.y, pRight.y}, 3);
  }

  @Override
  public void draw(Graphics g){
    drawArrowLine(g);
    drawArrowHead(g);
  }
}
