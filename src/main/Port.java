import javax.swing.*;
import java.awt.*;

public class Port {
  public int x;
  public int y;
  public String position = "";

  public void setPosition(String position){
    this.position = position;
  }

  public String getPosition(){
    return position;
  }
}
