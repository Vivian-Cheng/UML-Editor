import javax.swing.*;
import java.awt.*;

public class GUI {
  public GUI(){

    JFrame frame = new JFrame("UML Editor");
    String[][] buttonMenuList = {{"File"},
                                 {"Edit","Group","UnGroup","Change object name"}};
    ButtonMenuBar buttonMenuBar = new ButtonMenuBar(buttonMenuList, Color.darkGray);
    CanvasDemo canvasDemo = new CanvasDemo();                            
    ButtonPanel buttonPanel = new ButtonPanel(Color.white, canvasDemo);
    
    frame.setJMenuBar(buttonMenuBar);
    //frame.getContentPane().add(buttonPanel);
    frame.getContentPane().add(BorderLayout.WEST, buttonPanel);
    //frame.getContentPane().add(BorderLayout.CENTER,canvasDemo);
    frame.add(canvasDemo);
    


    
    frame.setSize(900,600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
  }
  
}
