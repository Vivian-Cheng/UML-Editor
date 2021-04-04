import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeClass extends Mode {
  public ModeClass(){
    this.modeName = "Class";
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
  }
}
