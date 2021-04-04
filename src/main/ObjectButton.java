import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ObjectButton extends JButton {
  // ObjectButton default constructor
  public ObjectButton(String buttonIconUrl, Mode inputMode, CanvasDemo canvasDemo){
    //super.setBackground(Color.red);
    init(buttonIconUrl, inputMode, canvasDemo);
  }

  public static String currentModeName = "";
  public static Mode currentMode;

  // init method for constructor
  private void init(String buttonIconUrl, Mode inputMode, CanvasDemo canvasDemo){
    // UI setting
    setPreferredSize(new Dimension(80, 100));
    setIcon(createImageIcon(buttonIconUrl));
    setOpaque(true);
    //setBackground(Color.red);

    // Button actionlistener
    addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if (inputMode.getModeName() == currentModeName){
          System.out.println(currentModeName);
          currentMode = inputMode;
          canvasDemo.addMouseListener(currentMode);
        }else{
          canvasDemo.removeMouseListener(currentMode);
          currentMode = inputMode;
          currentModeName = inputMode.getModeName();
          canvasDemo.addMouseListener(currentMode);
        }
      }      
    });    
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
