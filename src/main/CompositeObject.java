import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;

public class CompositeObject extends Shape{
  public Point P_START = new Point();
  public int HEIGHT;
  public int WIDTH;
  //public int NUM_OF_LINE;
  //public Port PORT_TOP = new Port();
  //public Port PORT_BOTTOM = new Port();
  //public Port PORT_LEFT = new Port();
  //public Port PORT_RIGHT = new Port();
  //public List<Shape> objList = new ArrayList<Shape>();

  public CompositeObject(List<Shape> objList){
    this.objList = objList;
    set();
    isComposite = true;
  }
  public void set(){
    System.out.println(objList.get(0));
    int maxX = 0;
    int maxY = 0;
    int minX = 0;
    int minY = 0;
    for(int i = 0; i < objList.size(); i++){
      if(i==0){
        maxX = objList.get(i).PORT_RIGHT.x;
        maxY = objList.get(i).PORT_BOTTOM.y;
        minX = objList.get(i).PORT_LEFT.x;
        minY = objList.get(i).PORT_TOP.y;
      }else{
        if(objList.get(i).PORT_RIGHT.x > maxX){
          maxX = objList.get(i).PORT_RIGHT.x;
        }
        if(objList.get(i).PORT_BOTTOM.y > maxY){
          maxY = objList.get(i).PORT_BOTTOM.y;
        }
        if(objList.get(i).PORT_LEFT.x < minX){
          minX = objList.get(i).PORT_LEFT.x;
        }
        if(objList.get(i).PORT_TOP.y < minY){
          minY = objList.get(i).PORT_TOP.y;
        }
      }
    }
    if((maxX-minX) > (maxY-minY)){
      HEIGHT = (maxX-minX);
      WIDTH = (maxX-minX);
    }else{
      HEIGHT = (maxY-minY);
      WIDTH = (maxY-minY);
    }
    this.REGION = new Rectangle2D.Double(minX, minY, WIDTH, HEIGHT);
    P_START.x = minX;
    P_START.y = minY;
    PORT_TOP.x = minX + WIDTH/2;
    PORT_TOP.y = minY;
    PORT_BOTTOM.x = minX + WIDTH/2;
    PORT_BOTTOM.y = maxY;
    PORT_LEFT.x = minX;
    PORT_LEFT.y = minY + HEIGHT/2;
    PORT_RIGHT.x = maxX;
    PORT_RIGHT.y = minY + HEIGHT/2;
    
  }

  
  @Override
  public void setSelectMode(boolean inSelectMode){
    for(int i = objList.size()-1; i>=0; i--){
      objList.get(i).setSelectMode(inSelectMode);
    }
  }
  public boolean getSelectMode(){
    return inSelectMode;
  }
  public void draw(Graphics g){
    for(int i = objList.size()-1; i>=0; i--){
      objList.get(i).draw(g);
    }
  }
  /*
  public boolean isContained(Rectangle2D.Double selectRegion){
    return selectRegion.contains(REGION)
    boolean isContained = false;
    for(int i = objList.size()-1; i>=0; i--){
      if(selectRegion.contains(objList.get(i).REGION)){
        isContained = true;
      }else{
        return false;
      }
    }
    return isContained;
  }
  */
  public boolean containPoint(Point p){
    System.out.println(REGION);
    return REGION.contains(p);

  }
}
