import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ObjectButton extends JButton {
  // ObjectButton default constructor
  public ObjectButton(String buttonIconUrl, CanvasDemo canvasDemo){
    //super.setBackground(Color.red);
    init(buttonIconUrl, canvasDemo);
  }

  static String currentMode = "";

  // init method for constructor
  private void init(String buttonIconUrl, CanvasDemo canvasDemo){
    // UI setting
    setPreferredSize(new Dimension(80, 100));
    setIcon(createImageIcon(buttonIconUrl));
    //setBackground(Color.red);

    // Mouse adapter -> execute drawing
    MouseAdapter mouseListener = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (currentMode == getMode()) {
          //super.mouseClicked(e);
          Point pStart = e.getPoint();
          draw(pStart, canvasDemo);
          System.out.println(pStart);
          System.out.println(currentMode);
        }else{
          canvasDemo.removeMouseListener(this);
        }
        
      }
    };

    // Button actionlistener
    addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        currentMode = getMode();
        canvasDemo.addMouseListener(mouseListener);
      }      
    });    
  }

  // create object
  public void draw(Point pStart, CanvasDemo canvasDemo){
    //System.out.println("draw~~");
  }

  public String getMode(){
    return "";
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
