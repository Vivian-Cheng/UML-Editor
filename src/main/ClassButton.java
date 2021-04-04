import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassButton extends ObjectButton {

  public ClassButton(String buttonIconUrl, CanvasDemo canvasDemo){
    //super.setBackground(Color.red);
    super(buttonIconUrl, canvasDemo);
  }

  @Override
  public void draw(Point pStart, CanvasDemo canvasDemo){
    System.out.println("draw class");
    new UseCaseObject(pStart);
    //UseCaseObject useCaseObject = new UseCaseObject(pStart);
    //useCaseObject.setVisible(true);
    //canvasDemo.add(useCaseObject);
  }

  @Override
  public String getMode(){
    return "Class";
  }
}
