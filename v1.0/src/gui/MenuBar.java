package gui;

import component.shape.ShapeObj;
import component.shape.GroupObj;
import component.shape.basic.BasicObj;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class MenuBar {
  private Canvas canvas;
  protected JMenuBar menuBar = new JMenuBar();
  private JMenu fileMenu = new JMenu("File");
  private JMenu editMenu = new JMenu("Edit");
  private List<ShapeObj> selectList = new ArrayList<ShapeObj>();

  public MenuBar() {
    menuBar.setBackground(new Color(210, 180, 140));
    canvas = Canvas.getInstance();
    JMenuItem groupItem = new JMenuItem("Group");
    groupItem.addActionListener(new GroupItemListener());
    JMenuItem unGroupItem = new JMenuItem("UnGroup");
    unGroupItem.addActionListener(new UnGroupItemListener());
    JMenuItem changeName = new JMenuItem("Change object name");
    changeName.addActionListener(new ChangeNameListener());
    editMenu.add(groupItem);
    editMenu.add(unGroupItem);
    editMenu.add(changeName);
    menuBar.add(fileMenu);
    menuBar.add(editMenu);
  }

  public void setSelectList() {
    for (ShapeObj shapeObj : canvas.shapeList) {
      if (shapeObj.getSelect())
        selectList.add(shapeObj);
    }
  }

  class GroupItemListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (canvas.getCurrentMode().modeType.equals("select")) {
        setSelectList();
        /* Create composite object */
        if (selectList.size() > 1) {
          GroupObj groupObj = new GroupObj(selectList);
          canvas.shapeList.removeAll(selectList);
          canvas.shapeList.add(groupObj);
          groupObj.setSelect(true);
        }
        selectList.clear();
        canvas.repaint();
      }
    }
  }

  class UnGroupItemListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (canvas.getCurrentMode().modeType.equals("select")) {
        setSelectList();
        /* Ungroup composite object */
        if (selectList.size() == 1) {
          if (selectList.get(0) instanceof GroupObj) {
            GroupObj groupObj = (GroupObj) selectList.get(0);
            for (ShapeObj shapeObj : groupObj.container) {
              canvas.shapeList.add(shapeObj);
            }
            canvas.shapeList.removeAll(selectList);
            selectList.clear();
          }
        }
        canvas.repaint();
      }
    }
  }

  class ChangeNameListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (canvas.getCurrentMode().modeType.equals("select")) {
        setSelectList();
        if (selectList.size() != 1) {
          JOptionPane.showMessageDialog(canvas, "Please select only one object", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          String objName = JOptionPane.showInputDialog(canvas, "Please enter an object name:", "Change Object Name", JOptionPane.QUESTION_MESSAGE);
          if (objName != null && !(selectList.get(0) instanceof GroupObj)) {
            ((BasicObj)(selectList.get(0))).objName = objName;
          }
        }
        selectList.clear();
        canvas.repaint();
      }
    }
  }
}
