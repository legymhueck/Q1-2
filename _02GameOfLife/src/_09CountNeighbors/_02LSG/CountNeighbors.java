package _09CountNeighbors._02LSG;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
  private TextField txtPercent;

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
    if (event.getTarget() instanceof Rectangle r) {
      int col = GridPane.getColumnIndex(r);
      int row = GridPane.getRowIndex(r);
      int count = 0;
      for (int i = row - 1; i <= row + 1; i++) { // Loop through the rows
        for (int j = col - 1; j <= col + 1; j++) { // Loop through the columns
          if (i >= 0 && i < rows && j >= 0 && j < cols) { // Check if the index is within the bounds of the grid
            if (i != row || j != col) { // Check if the index is not the same as the clicked rectangle
              Rectangle rect = (Rectangle) getNodeFromGridPane(gridPane, j, i); // Get the rectangle at the index
              assert rect != null; // Make sure the rectangle is not null
              if (rect.getFill().equals(Color.BLACK)) { // Check if the rectangle is black
                count++; // Increment the count
              }
            }
          }
        }
      }
      ((Label) bottomBar.getChildren().get(0)).setText("Neighbors: " + count); // Update the label text
    }
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
    txtPercent = new TextField();
    txtPercent.setPromptText("Percent");
    txtPercent.setText("20");
    txtPercent.setMinWidth(50);
    txtPercent.setMaxWidth(50);
    txtPercent.setPrefWidth(50);
    topBar.getChildren().addAll(btnGenerate, txtPercent);
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
        if (percent < Integer.parseInt(txtPercent.getText())) {
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
