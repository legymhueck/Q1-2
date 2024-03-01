package _02GridPane_und_FXML;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

  @FXML
  private void setColor(MouseEvent mouseEvent) {
    Rectangle rectangle = (Rectangle) mouseEvent.getSource(); // Quelle des MouseEvents, CASTING!!
    if (rectangle.getFill() == Color.WHITE)
      rectangle.setFill(Color.BLACK);
    else if (rectangle.getFill() == Color.BLACK)
      rectangle.setFill(Color.WHITE);
  }
}
