package _05GridPane_ColumnIndex;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {
  private final int rectSize = 40;

  @Override
  public void start(Stage primaryStage) {
    VBox root = new VBox();
    GridPane gridPane = new GridPane();
    int rows = 10;
    int cols = 10;
    fillGridPane(gridPane, rows, cols);
    for (Node node : gridPane.getChildren()) {
      Rectangle rect = (Rectangle) node;
      setDifferentColors(rect);
    }

    gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
      if (event.getTarget() instanceof Rectangle r) {
        setDifferentColors(r);
      }
    });

    root.setVisible(true);
    gridPane.setGridLinesVisible(true);

    root.getChildren().addAll(gridPane);
    primaryStage.setTitle("GridPane");
    primaryStage.setScene(new Scene(root, cols * rectSize, rows * rectSize));
    primaryStage.show();
//    System.out.println(getNodeFromGridPane(gridPane, 0, 0));
//    System.out.println(getNodeFromGridPane(gridPane, 0, 1));
//    System.out.println(getNodeFromGridPane(gridPane, 2, 1));
  }

  private void fillGridPane(GridPane gridPane, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        Rectangle rect = new Rectangle(rectSize, rectSize);
        GridPane.setColumnIndex(rect, j);
        GridPane.setRowIndex(rect, i);
        rect.setFill(Color.WHITE);
        gridPane.getChildren().add(rect);
      }
    }
  }

  private void setDifferentColors(Rectangle pRect) {
    double red = (Math.random());
    double green = (Math.random());
    double blue = (Math.random());
    Paint col1 = Color.color(red, green, blue);
    pRect.setFill(col1);
  }


  private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
      if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
        return node;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
