package _03GridPane_ohne_FXML;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class MainApp extends Application {


  private GridPane root;
  private Controller controller;
  private final int HOR_RECTANGLES = 10;
  private final int VERT_RECTANGLES = 10;
  private final int RECTANGLE_SIZE = 30;

  @Override
  public void start(Stage primaryStage) {
    Scene scene = getScene(primaryStage);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Scene getScene(Stage primaryStage) {
    root = new GridPane();
    controller = new Controller();
    root.setGridLinesVisible(true);
    createRectangles();

    primaryStage.setTitle("GridPane");
    return new Scene(root);
  }


  private void createRectangles() {
    Rectangle rectangle = null;
    for (int i = 0; i < HOR_RECTANGLES; i++) {
      for (int j = 0; j < VERT_RECTANGLES; j++) {
        rectangle = new Rectangle(RECTANGLE_SIZE, RECTANGLE_SIZE);

        // Über Lambda-Ausdruck
        rectangle.setOnMouseClicked(mouseEvent -> {
          Rectangle r = (Rectangle) mouseEvent.getSource();
          controller.setColor((Rectangle) mouseEvent.getSource());
          System.out.println("X: " + GridPane.getColumnIndex(r) + " Y: " + GridPane.getRowIndex(r));
        });

        // Oder über Methodenreferenz
        // rectangle.setOnMouseClicked(controller::setColor);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.DARKBLUE);
        rectangle.setStrokeType(StrokeType.INSIDE);
        root.add(rectangle, i, j);
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
