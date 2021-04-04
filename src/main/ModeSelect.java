import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeSelect extends Mode {
  public ModeSelect(){
    this.modeName = "Select";
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
  }
}
