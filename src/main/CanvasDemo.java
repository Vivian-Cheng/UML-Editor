import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class CanvasDemo extends Canvas implements MouseListener{
  public CanvasDemo(){
    init();
  }

  private void init() {
    //setBorder(new LineBorder(Color.BLACK));
    setBackground(Color.white);
  }
}
