import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel {
  public ButtonPanel(CanvasDemo canvasDemo){
    init(Color.lightGray, canvasDemo);
  }

  public ButtonPanel(Color backgroundColor, CanvasDemo canvasDemo){
    init(backgroundColor, canvasDemo);
  }

  private void init(Color backgroundColor, CanvasDemo canvasDemo) {
    //setPreferredSize(new Dimension(90, 400));
    setLayout(new GridLayout(6,1));
    setBackground(backgroundColor);
    
    for ( int i = 1; i<=5 ; i++){
      //ObjectButton objectButton = new ObjectButton(("/resources/icon/" + i + ".png"), canvasDemo);
      //add(objectButton);

      ClassButton classButton = new ClassButton(("/resources/icon/" + i + ".png"), canvasDemo);
      add(classButton);
      
    }
    
    UseCaseButton useCaseButton = new UseCaseButton(("/resources/icon/" + 6 + ".png"), canvasDemo);
    add(useCaseButton);
  }

}

