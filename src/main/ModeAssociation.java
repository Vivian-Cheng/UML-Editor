import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeAssociation extends Mode {
  public CanvasDemo canvasDemo;
  public boolean objSelect = false;
  public int selectObjIndex;
  public Point portStart;
  public Point portEnd;
  public ModeAssociation(CanvasDemo canvas){
    this.modeName = "Association";
    canvasDemo = canvas;
  }

  @Override
  public void mousePressed(MouseEvent e){
    Point pStart = e.getPoint();
    System.out.println(getModeName());
    System.out.println(pStart);
    objSelect = false;
    for( int i = canvasDemo.shapeList.size()-1; (i>=0) && (!objSelect); i--){
      Shape shape = canvasDemo.shapeList.get(i);
      if(shape.containPoint(pStart)){
        System.out.println("select object");
        selectObjIndex = i;
        portStart = shape.getPort(pStart);
        System.out.println(portStart);
        objSelect = true;
      }
    }
  }
  public void mouseDragged(MouseEvent e) {
    //if(objSelect){
    //  System.out.println("mouseDragged");
    //}
    System.out.println("mouseDragged");
    
  }
  public void mouseReleased(MouseEvent e) {
    if(objSelect){
      Point pEnd = e.getPoint();
      //System.out.println(pEnd);
      objSelect = false;
      for( int i = canvasDemo.shapeList.size()-1; (i>=0) && (!objSelect); i--){
        Shape shape = canvasDemo.shapeList.get(i);
        if((shape.containPoint(pEnd)) && i!=selectObjIndex){
          portEnd = shape.getPort(pEnd);
          System.out.println(portEnd);
          objSelect = true;
        }
      }
    }
    
  }
 
}
