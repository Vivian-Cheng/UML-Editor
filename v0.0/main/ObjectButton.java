import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ObjectButton extends JButton {
  public Mode mode;
  public CanvasDemo canvas;
  // ObjectButton default constructor
  public ObjectButton(String buttonIconUrl, Mode inputMode){
    //super.setBackground(Color.red);
    setPreferredSize(new Dimension(80, 100));
    setIcon(createImageIcon(buttonIconUrl));
    setOpaque(true);
    //setBackground(Color.red);
    this.mode = inputMode;
    //init(buttonIconUrl, inputMode, canvasDemo);
  }


  private static ImageIcon createImageIcon(String path) {
      java.net.URL imgURL = GUI.class.getResource(path);
      if (imgURL != null) {
         return new ImageIcon(imgURL);
      } else {            
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   }
}
