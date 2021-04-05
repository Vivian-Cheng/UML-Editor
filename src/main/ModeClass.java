import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class ModeClass extends Mode {
  public ModeClass(List<Shape> shapeList){
    this.modeName = "Class";
    this.shapeList = shapeList;
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
      shapeList.add(new UmlClass(pStart));
  }
}
