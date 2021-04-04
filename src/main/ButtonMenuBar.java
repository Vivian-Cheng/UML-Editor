import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class ButtonMenuBar extends JMenuBar{
  public ButtonMenuBar(String[][] itemList){
    init(itemList, Color.lightGray);
  }
  public ButtonMenuBar(String[][] itemList, Color backgroundColor){
    init(itemList, backgroundColor);
  }

  private void init(String[][] itemList, Color backgroundColor) {
    setBackground(backgroundColor);
    JMenu menu;
    for (int row = 0; row < itemList.length; row++){
      if (itemList[row].length <= 1){
        menu = new JMenu(itemList[row][0]);
      } else{
        menu = new JMenu(itemList[row][0]);
        for (int col = 1; col < itemList[row].length; col++){
          JMenuItem menuItem = new JMenuItem(itemList[row][col]);
          menu.add(menuItem);
        }
      }
      add(menu);
    }
  }
}
