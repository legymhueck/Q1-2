package _09CountNeighbors._01SV;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CountNeighbors extends Application {
  private HBox bottomBar;
  private HBox topBar;
  private final int rectSize = 40;
  private final int rows = 10;
  private final int cols = 10;
  private GridPane gridPane;
  private int percentRect = 20;


  @Override
  public void start(Stage primaryStage) {
    VBox root = createScene();
    generateRandomRectangles();
    primaryStage.setTitle("Count Neighbors");
    double height = rectSize * rows
        + topBar.getPrefHeight() + topBar.getPadding().getTop() + topBar.getPadding().getBottom()
        + bottomBar.getPrefHeight() + bottomBar.getPadding().getTop();

    primaryStage.setScene(new Scene(root, cols * rectSize, height));
    primaryStage.show();
  }

  private VBox createScene() {
    VBox root = new VBox();
    gridPane = new GridPane();
    bottomBar = createBottomBar();
    fillGridPane(gridPane, Color.WHITE, rows, cols);

    gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED, this::countNeighbors);

    root.setVisible(true);
    gridPane.setGridLinesVisible(true);

    root.getChildren().addAll(createTopBar(), gridPane, bottomBar);
    return root;
  }

  private void countNeighbors(MouseEvent event) {
    int count = 0;
      ((Label) bottomBar.getChildren().get(0)).setText("Neighbors: " + count); // Update the label text
  }

  private HBox createTopBar() {
    topBar = new HBox();
    topBar.setMinHeight(45);
    topBar.setMaxHeight(45);
    topBar.setPrefHeight(45);
    topBar.setSpacing(10);
    topBar.setPadding(new Insets(10, 10, 10, 0));
    Button btnGenerate = new Button("Generate");
    btnGenerate.setOnAction(e -> generateRandomRectangles());
    topBar.getChildren().addAll(btnGenerate);
    return topBar;
  }

  private HBox createBottomBar() {
    bottomBar = new HBox();
    bottomBar.setMinHeight(20);
    bottomBar.setMaxHeight(20);
    bottomBar.setPrefHeight(20);
    bottomBar.setSpacing(10);
    bottomBar.setPadding(new Insets(10, 10, 10, 0));
    Label lblCount = new Label("Neighbors: ");
    lblCount.setPadding(new Insets(0, 10, 0, 0));
    lblCount.setFont(new Font("Arial", 16));
    bottomBar.getChildren().addAll(lblCount);
    return bottomBar;
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

  private void generateRandomRectangles() {
    for (Node node : gridPane.getChildren()) {
      if (node instanceof Rectangle) {
        int percent = (int) (Math.random() * 100);
        if (percent < percentRect) {
          ((Rectangle) node).setFill(Color.BLACK);
        } else {
          ((Rectangle) node).setFill(Color.WHITE);
        }
      }
    }
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
