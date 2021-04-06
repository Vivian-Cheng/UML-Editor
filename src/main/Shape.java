import javax.swing.*;
import java.awt.*;

public class Shape {
  public void draw(Graphics g){}
  public boolean containPoint(Point p){
    return false;
  }
  public Port getPort(Point p){
    Port port = new Port();
    return port;
  }
}
