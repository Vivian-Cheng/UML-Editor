import javax.swing.*;
import java.awt.*;

public class UmlUseCase extends BasicObject {

  public UmlUseCase(Point p){
    this.P_START = p;
    this.HEIGHT = 80;
    this.WIDTH = 100;
  }

  @Override
  public void draw(Graphics g){
    System.out.println("Drawing...");
    g.setColor(Color.BLACK);
    g.drawOval(P_START.x, P_START.y, WIDTH, HEIGHT);
  }
}
