import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ObjectButton extends JButton {
  public ObjectButton(String buttonIconUrl){
    //super.setBackground(Color.red);
    init(buttonIconUrl);

  }

  private void init(String buttonIconUrl){
    setPreferredSize(new Dimension(80, 100));
    setIcon(createImageIcon(buttonIconUrl));
    setBackground(Color.red);
    
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
