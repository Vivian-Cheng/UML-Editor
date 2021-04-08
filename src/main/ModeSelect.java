import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.lang.Math.*;

public class ModeSelect extends Mode {
  public CanvasDemo canvasDemo;
  public Shape lastSelectObj = new Shape();
  public Point pStart = new Point();
  public Point pEnd = new Point();
  public boolean isPressed = false;
  public boolean isSelected = false;
  public ModeSelect(CanvasDemo canvas){
    this.modeName = "Select";
    canvasDemo = canvas;
  }

  @Override
  public void mousePressed(MouseEvent e){
    if(canvasDemo.currentMode.getModeName() == modeName){
      isPressed = true;
      pStart = e.getPoint();
      System.out.println(getModeName());
      System.out.println(pStart);
      isSelected = false;
      for( int i = canvasDemo.shapeList.size()-1; (i>=0) && !isSelected; i--){
        Shape shape = canvasDemo.shapeList.get(i);
        if(shape.containPoint(pStart)){
          if(lastSelectObj != null){
            lastSelectObj.setSelectMode(false);
          }
          System.out.println("select object");
          shape.setSelectMode(true);
          lastSelectObj = shape;
          isSelected = true;
        }else{
          shape.setSelectMode(false);
        }
      }
    }
  }

  public void mouseReleased(MouseEvent e){
    if(isPressed){
      pEnd = e.getPoint();
      if(isSelected){
        lastSelectObj.reset(pEnd);
      }
      
      //System.out.println();
      //System.out.println(pStart);
      Rectangle2D.Double selectRegion = new Rectangle2D.Double(pStart.x, pStart.y, Math.abs(pEnd.x - pStart.x), Math.abs(pEnd.y - pStart.y));
      for( int i = canvasDemo.shapeList.size()-1; i>=0; i--){
        Shape shape = canvasDemo.shapeList.get(i);
        if(selectRegion.contains(shape.REGION)){
          shape.inSelectMode = true;
        }
      }
    }
    isPressed =  false;
  }
}
