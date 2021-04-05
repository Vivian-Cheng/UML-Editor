import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Mode implements MouseListener {

  public String modeName = "Mode";
  public boolean isOn = false;
  public List<Shape> shapeList;

  public void setModeName(String modeName){
    this.modeName = modeName;
  }

  public String getModeName(){
    return modeName;
  }

  public void setIsOn(boolean isOn){
    this.isOn = isOn;
  }

  public boolean getIsOn(){
    return isOn;
  }

  public void mouseClicked(MouseEvent e){
  }
  public void mousePressed(MouseEvent e){
  }
  public void mouseEntered(MouseEvent e){
  }
  public void mouseExited(MouseEvent e){
  }
  public void mouseReleased(MouseEvent e){
  }
}
