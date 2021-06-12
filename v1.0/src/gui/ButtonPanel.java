package gui;

import mode.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;

public class ButtonPanel {
  private Canvas canvas;
  private ArrayList<JButton> buttonList = new ArrayList<>();
  private int preBtnIndex;
  private Color defaultColor = new Color(230, 195, 195); // Color: Sand Beige
  private Color newColor = new Color(188, 143, 143); // Color: Rosy Brown
  protected JPanel buttonPanel = new JPanel(new GridLayout(6,1));

  public ButtonPanel() {
    canvas = Canvas.getInstance();
    new ControlBtn("icon/1.png", new SelectMode("select"));
    new ControlBtn("icon/2.png", new CreateLineObjMode("assocLine"));
    new ControlBtn("icon/3.png", new CreateLineObjMode("generalLine"));
    new ControlBtn("icon/4.png", new CreateLineObjMode("compLine"));
    new ControlBtn("icon/5.png", new CreateBasicObjMode("class"));
    new ControlBtn("icon/6.png", new CreateBasicObjMode("useCase"));
  }

  private class ControlBtn extends JButton {
    private Mode mode;

    public ControlBtn(String iconPath, Mode mode) {
      this.mode = mode;
      JButton button = new JButton(createImageIcon(iconPath));
      button.setContentAreaFilled(false);
			button.setOpaque(true);
			button.setBackground(defaultColor); 
			button.addActionListener(new ButtonListener());
			buttonPanel.add(button);
			buttonList.add(button);
    }

    class ButtonListener implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				JButton source  = (JButton)e.getSource();
				buttonList.get(preBtnIndex).setBackground(defaultColor);
				source.setBackground(newColor);
				canvas.setCurrentMode(mode);
				preBtnIndex = buttonList.indexOf(source);
			}
		}
  }

  /* Check image exist */
  private static ImageIcon createImageIcon(String path) {
      java.net.URL imgURL = Window.class.getResource(path);
      if (imgURL != null) {
         return new ImageIcon(imgURL);
      } else {            
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   }
}
