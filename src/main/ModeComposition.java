import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeComposition extends Mode {
  public ModeComposition(){
    this.modeName = "Composition";
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
  }
}
