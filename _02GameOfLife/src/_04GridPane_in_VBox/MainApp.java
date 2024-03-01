package _04GridPane_in_VBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {
  private Label label;
  private GridPane gridPane;
  private Controller controller;
  private final int HOR_RECTANGLES = 10;
  private final int VERT_RECTANGLES = 10;
  private final int RECTANGLE_SIZE = 30;

  @Override
  public void start(Stage primaryStage) {
    Scene scene = createScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Scene createScene() {
    VBox root = new VBox();
    gridPane = new GridPane();
    controller = new Controller();
    gridPane.setGridLinesVisible(true);
    createRectangles();
    createLabel();

    Scene scene = new Scene(root);
    root.getChildren().addAll(gridPane, label);
    return scene;
  }

  private void createRectangles() {
    Rectangle rectangle = null;
    for (int i = 0; i < HOR_RECTANGLES; i++) {
      for (int j = 0; j < VERT_RECTANGLES; j++) {
        rectangle = new Rectangle(RECTANGLE_SIZE, RECTANGLE_SIZE);
        rectangle.getStyleClass().add("rectangle");

        rectangle.setOnMouseClicked(mouseEvent -> {
          Rectangle r = (Rectangle) mouseEvent.getSource();
          controller.setColor((Rectangle) mouseEvent.getSource());
          label.setText("X: " + GridPane.getColumnIndex(r) + " Y: " + GridPane.getRowIndex(r));
        });
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.DARKBLUE);
        rectangle.setStrokeType(StrokeType.INSIDE);
        gridPane.add(rectangle, i, j);
      }
    }
  }

  private void createLabel() {
    label = new Label("X: 0 Y: 0");
    label.setScaleX(2);
    label.setScaleY(2);
    label.setPadding(new Insets(10, 10, 10, 20));
    label.setFont(Font.font("Arial", 10));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
