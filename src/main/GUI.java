import javax.swing.*;
import java.awt.*;

public class GUI {
  public GUI(){
    JFrame frame = new JFrame("UML Editor");
    String[][] buttonMenuList = {{"File"},
                                 {"Edit","Group","UnGroup","Change object name"}};
    ButtonMenuBar buttonMenuBar = new ButtonMenuBar(buttonMenuList, Color.darkGray);                            
    ButtonPanel buttonPanel = new ButtonPanel(Color.white);
    CanvasDemo canvasDemo = new CanvasDemo();
    //JButton btn = new JButton(createImageIcon("class.png"));
    //btn.setPreferredSize(new Dimension(200, 30));
    //btn.setIcon(new ImageIcon("/resources/icon/05class.png"));
   //btn.setIcon(new ImageIcon(SwingControlDemo.class.getResource("05class.png")));
    //btn.setHorizontalAlignment(SwingConstants.LEFT);
    //frame.getContentPane().add(btn);
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
