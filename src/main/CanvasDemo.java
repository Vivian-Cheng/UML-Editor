import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class CanvasDemo extends JPanel{
  public CanvasDemo(){
    init();
  }

  public List<Shape> shapeList = new ArrayList<Shape>();

  private void init() {
    //setBorder(new LineBorder(Color.BLACK));
    setBackground(Color.white);
  }

  @Override
  public void paintComponent(Graphics g){ //p.366
    super.paintComponent(g);
    //System.out.println("shapeList.size()"+shapeList.size());
    for ( int i = shapeList.size()-1 ; i>=0 ;i--){
    //System.out.println("in the Canvas paintcomponent and paint shape");
    Shape shape = shapeList.get(i);
    shape.draw(g);
  }

  //tempShape.draw(g);
  repaint();//若這邊沒有寫repaint 會要切換到別的模式的時候 才會顯現出來（ 若是這樣的話 就要用shapeList)
  //shapeList慛在主要目的是 記住那些object 好讓執行group時 有個依據
 }
}
