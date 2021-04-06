import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeSelect extends Mode {
  public CanvasDemo canvasDemo;
  public boolean objSelect = false;
  public Shape lastSelectObj = new Shape();
  public ModeSelect(CanvasDemo canvas){
    this.modeName = "Select";
    canvasDemo = canvas;
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point p = e.getPoint();
      System.out.println(getModeName());
      System.out.println(p);
      objSelect = false;
      for( int i = canvasDemo.shapeList.size()-1; (i>=0) && (!objSelect); i--){
        Shape shape = canvasDemo.shapeList.get(i);
        if(shape.containPoint(p)){
          System.out.println("select object");
          if(shape == lastSelectObj){
            shape.inSelectMode = true;
          }else{
            lastSelectObj.inSelectMode = false;
            shape.inSelectMode = true;
            lastSelectObj = shape;
          }
          objSelect = true;
        }else{
          lastSelectObj.inSelectMode = false;
        }
      }
  }
}
