import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel {
  public ButtonPanel(){
    init(Color.lightGray);
  }

  public ButtonPanel(Color backgroundColor){
    init(backgroundColor);
  }

  private void init(Color backgroundColor) {
    //setPreferredSize(new Dimension(90, 400));
    setLayout(new GridLayout(6,1));
    setBackground(backgroundColor);
    for ( int i = 1; i<=6 ; i++){
      ObjectButton objectButton = new ObjectButton("/resources/icon/" + i + ".png");
      add(objectButton);
    }
  }

}

