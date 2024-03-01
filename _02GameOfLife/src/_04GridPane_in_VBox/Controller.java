package _04GridPane_in_VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

  // Diese Methode wird über den Lambda-Ausdruck aufgerufen
  public void setColor(Rectangle pRectangle) {
    if (pRectangle.getFill() == Color.WHITE)
      pRectangle.setFill(Color.BLACK);
    else if (pRectangle.getFill() == Color.BLACK)
      pRectangle.setFill(Color.WHITE);
  }
}
