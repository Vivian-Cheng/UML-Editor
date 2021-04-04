import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeAssociation extends Mode {
  public ModeAssociation(){
    this.modeName = "Association";
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
  }
}
