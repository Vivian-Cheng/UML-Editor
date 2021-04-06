import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel {
  public ButtonPanel(CanvasDemo canvasDemo){
    init(Color.lightGray, canvasDemo);
  }

  public ButtonPanel(Color backgroundColor, CanvasDemo canvasDemo){
    init(backgroundColor, canvasDemo);
  }

  public static String currentModeName = "";
  public static Mode currentMode;
  public CanvasDemo canvasDemo;
  public ArrayList<ObjectButton> buttonList = new ArrayList<ObjectButton>();
  private int indexSource;

  private void init(Color backgroundColor, CanvasDemo canvasDemo) {
    //setPreferredSize(new Dimension(90, 400));
    setLayout(new GridLayout(6,1));
    setBackground(backgroundColor);
    this.canvasDemo = canvasDemo;

    ObjectButton selectButton = new ObjectButton(("/resources/icon/1.png"), new ModeSelect(canvasDemo));
    add(selectButton);
    buttonList.add(selectButton);
    selectButton.addActionListener(new PanelButtonListener());

    ObjectButton associationButton = new ObjectButton(("/resources/icon/2.png"), new ModeAssociation(canvasDemo));
    add(associationButton);
    buttonList.add(associationButton);
    associationButton.addActionListener(new PanelButtonListener());

    ObjectButton generalizationButton = new ObjectButton(("/resources/icon/3.png"), new ModeGeneralization(canvasDemo));
    add(generalizationButton);
    buttonList.add(generalizationButton);
    generalizationButton.addActionListener(new PanelButtonListener());

    ObjectButton compositionButton = new ObjectButton(("/resources/icon/4.png"), new ModeComposition(canvasDemo));
    add(compositionButton);
    buttonList.add(compositionButton);
    compositionButton.addActionListener(new PanelButtonListener());

    ObjectButton classButton = new ObjectButton(("/resources/icon/5.png"), new ModeClass(canvasDemo.shapeList));
    add(classButton);
    buttonList.add(classButton);
    classButton.addActionListener(new PanelButtonListener());

    ObjectButton useCaseButton = new ObjectButton(("/resources/icon/6.png"), new ModeUseCase(canvasDemo.shapeList));
    add(useCaseButton);
    buttonList.add(useCaseButton);
    useCaseButton.addActionListener(new PanelButtonListener());
  }

  class PanelButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      ObjectButton source = (ObjectButton)e.getSource();
      if (source.mode.getModeName() == currentModeName){
          System.out.println(currentModeName);
          currentMode = source.mode;
          canvasDemo.addMouseListener(currentMode);
        }else{
          canvasDemo.removeMouseListener(currentMode);
          if(currentMode != null){
            currentMode.setIsOn(false);
            buttonList.get(indexSource).setBackground(Color.white);
            
            //currentButton.setBackground(Color.white);
          }
          //currentButton = this;
          source.mode.setIsOn(true);
          source.setBackground(Color.darkGray);
          indexSource = buttonList.indexOf(source);
          //currentButton.setBackground(Color.darkGray);
          currentMode = source.mode;
          currentModeName = source.mode.getModeName();
          /*
          if(currentMode.getIsOn()){
            setBackground(Color.darkGray);
          }else{
            setBackground(Color.white);
          }
          */
          canvasDemo.addMouseListener(currentMode);
        }
     }      
  }

}
