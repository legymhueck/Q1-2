package _06PercentRectangles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {
  private final int rectSize = 40;
  private final int rows = 10;
  private final int cols = 10;
  private Button bFill;
  private Button bPercentFill;
  private TextField textField;


  @Override
  public void start(Stage primaryStage) {
    VBox root = createScene();

    primaryStage.setTitle("GridPane");
    primaryStage.setScene(new Scene(root, cols * rectSize, rows * rectSize));
    primaryStage.show();
//    System.out.println(getNodeFromGridPane(gridPane, 0, 0));
//    System.out.println(getNodeFromGridPane(gridPane, 0, 1));
//    System.out.println(getNodeFromGridPane(gridPane, 2, 1));
  }

  private VBox createScene() {
    VBox root = new VBox();
    GridPane gridPane = new GridPane();
    HBox topBar = createTopBar();

    fillGridPane(gridPane, Color.WHITE, rows, cols);

    gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
      if (event.getTarget() instanceof Rectangle r) {
        setRectColor(r);
      }
    });

    bFill.setOnAction(e -> {
      for (Node node : gridPane.getChildren()) {
        if (node instanceof Rectangle) {
          setRectColor((Rectangle) node);
        }
      }
    });

    bPercentFill.setOnAction(e -> {
      for (Node node : gridPane.getChildren()) {
        if (node instanceof Rectangle) {
          int percent = (int) (Math.random() * 100);
          if (percent < Integer.parseInt(textField.getText())) {
            ((Rectangle) node).setFill(Color.BLACK);
          } else {
            ((Rectangle) node).setFill(Color.WHITE);
          }
        }
      }
    });
    root.setVisible(true);
    gridPane.setGridLinesVisible(true);

    root.getChildren().addAll(topBar, gridPane);
    return root;
  }

  private HBox createTopBar() {
    HBox topBar = new HBox();
    topBar.setSpacing(10);
    topBar.setPadding(new Insets(10, 10, 10, 0));
    bFill = new Button("Fill");
    bPercentFill = new Button("Percent");
    textField = new TextField();
    textField.setMaxWidth(40);
    textField.setMinWidth(40);
    textField.setPrefWidth(40);
    textField.setText("20");
    topBar.getChildren().addAll(bFill, bPercentFill, textField);
    return topBar;
  }

  private void fillGridPane(GridPane gridPane, Paint pColor, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        Rectangle rect = new Rectangle(rectSize, rectSize);
        GridPane.setColumnIndex(rect, j);
        GridPane.setRowIndex(rect, i);
        rect.setFill(pColor);
        gridPane.getChildren().add(rect);
      }
    }
  }

  private void setRectColor(Rectangle pRect) {
    double red = (Math.random());
    double green = (Math.random());
    double blue = (Math.random());
    Paint rgb = Color.color(red, green, blue);
    pRect.setFill(rgb);
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
