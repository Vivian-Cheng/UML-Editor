import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeGeneralization extends Mode {
  public ModeGeneralization(){
    this.modeName = "Generalization";
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
  }
}
