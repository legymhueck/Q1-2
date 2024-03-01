package _03GridPane_ohne_FXML;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {


  // Überladene Methode 'setColor':
  // Diese Methode wird über die Methodenreferenz aufgerufen
  public void setColor(MouseEvent mouseEvent) {
    Rectangle rectangle = (Rectangle) mouseEvent.getSource(); // Quelle des MouseEvents, CASTING!!
    if (rectangle.getFill() == Color.WHITE) {
      rectangle.setFill(Color.BLACK);
    }
    else if (rectangle.getFill() == Color.BLACK)
      rectangle.setFill(Color.WHITE);
  }

  // Diese Methode wird über den Lambda-Ausdruck aufgerufen
  public void setColor(Rectangle pRectangle) {
    if (pRectangle.getFill() == Color.WHITE)
      pRectangle.setFill(Color.BLACK);
    else if (pRectangle.getFill() == Color.BLACK)
      pRectangle.setFill(Color.WHITE);
  }
}
