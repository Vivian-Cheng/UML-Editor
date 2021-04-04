import javax.swing.*;
import java.awt.*;

public class UmlUseCase extends UmlObject {

  public UmlUseCase(Point p){
    this.pStart = p;
  }

  @Override
  public void draw(Graphics g){
    System.out.println("Drawing...");
    g.setColor(Color.BLACK);
    g.drawOval(pStart.x, pStart.y, 100, 80);
  }
}
