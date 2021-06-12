package mode;

import gui.Canvas;
import component.shape.basic.ClassObj;
import component.shape.basic.UseCaseObj;

import java.awt.event.MouseEvent;

public class CreateBasicObjMode extends Mode {
  private Canvas canvas;

  public CreateBasicObjMode(String modeType){
    this.modeType = modeType;
    canvas = Canvas.getInstance();
  }

  @Override
	public void mousePressed(MouseEvent e) {
		if (modeType == "class")
			canvas.shapeList.add(new ClassObj(e.getPoint()));
		else if (modeType == "useCase")
			Canvas.shapeList.add(new UseCaseObj(e.getPoint()));
		canvas.repaint();
	}
}
