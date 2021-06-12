import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class ButtonMenuBar extends JMenuBar{
  public CanvasDemo canvasDemo;
  public ButtonMenuBar(CanvasDemo canvas){
    canvasDemo = canvas;
    init(Color.lightGray);
  }
  public ButtonMenuBar(CanvasDemo canvas, Color backgroundColor){
    canvasDemo = canvas;
    init(backgroundColor);
  }

  private void init(Color backgroundColor) {
    setBackground(backgroundColor);
    JMenu menu;
    JMenu fileMenu = new JMenu("File");
    add(fileMenu);
    JMenu editMenu = new JMenu("Edit");
    JMenuItem groupItem = new JMenuItem("Group");
    editMenu.add(groupItem);
    groupItem.addActionListener(new GroupItemListener());
    JMenuItem unGroupItem = new JMenuItem("UnGroup");
    editMenu.add(unGroupItem);
    unGroupItem.addActionListener(new UnGroupItemListener());
    JMenuItem changeNameItem = new JMenuItem("Change object name");
    editMenu.add(changeNameItem);
    changeNameItem.addActionListener(new ChangeNameListener());
    add(editMenu);
    /*
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
    */
  }
  class GroupItemListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(canvasDemo.currentMode.getModeName() == "Select"){
        List<Shape> tempList = new ArrayList<Shape>();
        for(int i = canvasDemo.shapeList.size()-1; i>=0; i--){
          Shape shape = canvasDemo.shapeList.get(i);
          if(shape.getSelectMode()){
            tempList.add(shape);
          }
        }
        if(!tempList.isEmpty()){
          CompositeObject compositeObj = new CompositeObject(tempList);
          canvasDemo.shapeList.removeAll(tempList);
          canvasDemo.shapeList.add(compositeObj);
        }
      }
    }
  }
  class UnGroupItemListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(canvasDemo.currentMode.getModeName() == "Select"){
        List<Shape> tempList = new ArrayList<Shape>();
        for(int i = canvasDemo.shapeList.size()-1; i>=0; i--){
          if(canvasDemo.shapeList.get(i).isComposite){
            System.out.println(canvasDemo.shapeList.get(i).getSelectMode());
            if(canvasDemo.shapeList.get(i).getSelectMode()){
              tempList.add(canvasDemo.shapeList.get(i));
            }
          } 
        }
        System.out.println(tempList.size());
        if(tempList.size() == 1){
          Shape shape = tempList.get(0);
          for(int i =0; i < shape.objList.size(); i++){
            canvasDemo.shapeList.add(shape.objList.get(i));
          }
          canvasDemo.shapeList.removeAll(tempList);
        }
      }
    }
  }
  class ChangeNameListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(canvasDemo.currentMode.getModeName() == "Select"){
        List<Shape> tempList = new ArrayList<Shape>();
        for(int i = canvasDemo.shapeList.size()-1; i>=0; i--){
          if(!canvasDemo.shapeList.get(i).isComposite){
            if(canvasDemo.shapeList.get(i).getSelectMode()){
                tempList.add(canvasDemo.shapeList.get(i));
              }
          }
        }
        System.out.println(tempList.size());
        if(tempList.size() == 1){
          String objectName = JOptionPane.showInputDialog(canvasDemo, "Please enter an object name:", "Change Object Name", JOptionPane.QUESTION_MESSAGE);
          tempList.get(0).setObjName(objectName);
        }else{
          JOptionPane.showMessageDialog(canvasDemo, "Please select one object", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }
}
