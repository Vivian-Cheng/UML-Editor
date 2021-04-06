import javax.swing.*;
import java.awt.*;

public class LineAssociation extends LineObject{
  public LineAssociation(Port pStart, Port pEnd){
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
    g2d.setColor(Color.BLACK);

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
    g2d.drawLine(P_END.x, P_END.y, pLeft.x, pLeft.y);
    g2d.drawLine(P_END.x, P_END.y, pRight.x, pRight.y);
  }

  @Override
  public void draw(Graphics g){
    drawArrowLine(g);
    drawArrowHead(g);
  }
}
