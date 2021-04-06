import javax.swing.*;
import java.awt.*;

public class LineComposition extends LineObject{
  public LineComposition(Port pStart, Port pEnd){
    this.P_START = pStart;
    this.P_END = pEnd;
    setPassPoint();
    this.ARROR_LENGTH = 5;
  }

  @Override
  public void drawArrowHead(Graphics g){
    Point pLeft = new Point();
    Point pRight = new Point();
    Point pMirror = new Point();
    Graphics2D g2d = (Graphics2D) g;

    switch (P_END.getPosition()) {
      case "top":
        pLeft.x = P_END.x - ARROR_LENGTH;
        pLeft.y = P_END.y - ARROR_LENGTH;
        pRight.x = P_END.x + ARROR_LENGTH;
        pRight.y = P_END.y - ARROR_LENGTH;
        pMirror.x = P_END.x;
        pMirror.y = P_END.y - (ARROR_LENGTH)*2;        
        break;
      case "bottom":
        pLeft.x = P_END.x - ARROR_LENGTH;
        pLeft.y = P_END.y + ARROR_LENGTH;
        pRight.x = P_END.x + ARROR_LENGTH;
        pRight.y = P_END.y + ARROR_LENGTH;
        pMirror.x = P_END.x;
        pMirror.y = P_END.y + (ARROR_LENGTH)*2;
        break;
      case "left":
        pLeft.x = P_END.x - ARROR_LENGTH;
        pLeft.y = P_END.y + ARROR_LENGTH;
        pRight.x = P_END.x - ARROR_LENGTH;
        pRight.y = P_END.y - ARROR_LENGTH;
        pMirror.x = P_END.x - (ARROR_LENGTH)*2;
        pMirror.y = P_END.y;        
        break;
      case "right":
        pLeft.x = P_END.x + ARROR_LENGTH;
        pLeft.y = P_END.y + ARROR_LENGTH;
        pRight.x = P_END.x + ARROR_LENGTH;
        pRight.y = P_END.y - ARROR_LENGTH;
        pMirror.x = P_END.x + (ARROR_LENGTH)*2;
        pMirror.y = P_END.y;        
        break;
    }
    g2d.setColor(Color.BLACK);
    g2d.drawPolygon(new int[] {P_END.x, pLeft.x, pMirror.x, pRight.x}, new int[] {P_END.y, pLeft.y, pMirror.y, pRight.y}, 4);
    g2d.setColor(Color.white);
    g2d.fillPolygon(new int[] {P_END.x, pLeft.x, pMirror.x, pRight.x}, new int[] {P_END.y, pLeft.y, pMirror.y, pRight.y}, 4);
  }

  @Override
  public void draw(Graphics g){
    drawArrowLine(g);
    drawArrowHead(g);
  }
}
