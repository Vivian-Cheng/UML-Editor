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

    ObjectButton selectButton = new ObjectButton(("/resources/icon/1.png"), new ModeSelect() ,canvasDemo);
    add(selectButton);
    ObjectButton associationButton = new ObjectButton(("/resources/icon/2.png"), new ModeAssociation() ,canvasDemo);
    add(associationButton);
    ObjectButton generalizationButton = new ObjectButton(("/resources/icon/3.png"), new ModeGeneralization() ,canvasDemo);
    add(generalizationButton);
    ObjectButton compositionButton = new ObjectButton(("/resources/icon/4.png"), new ModeComposition() ,canvasDemo);
    add(compositionButton);
    ObjectButton classButton = new ObjectButton(("/resources/icon/5.png"), new ModeClass() ,canvasDemo);
    add(classButton);
    ObjectButton useCaseButton = new ObjectButton(("/resources/icon/6.png"), new ModeUseCase(canvasDemo.shapeList) ,canvasDemo);
    add(useCaseButton);
  }

}

