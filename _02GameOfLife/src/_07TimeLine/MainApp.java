package _07TimeLine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class MainApp extends Application {
  private HBox topBar;
  private final int rectSize = 40;
  private final int rows = 10;
  private final int cols = 10;
  private Button bClear;
  private Button bFill;
  private Button bPlayRandom;
  private Button bStop;
  private TextField tfPercent;
  private TextField tfTime;
  private GridPane gridPane;
  private Timeline timeline;


  @Override
  public void start(Stage primaryStage) {
    VBox root = createScene();
    handleEvents();

    primaryStage.setTitle("GridPane");
    double topBarHeight = topBar.getHeight() + topBar.getPadding().getTop() + topBar.getPadding().getBottom() + topBar.getInsets().getTop() + topBar.getInsets().getBottom() + 4;
    primaryStage.setScene(new Scene(root, cols * rectSize, rows * topBarHeight));
    primaryStage.show();
  }

  private VBox createScene() {
    VBox root = new VBox();
    gridPane = new GridPane();
    HBox topBar = createTopBar();

    fillGridPane(gridPane, Color.WHITE, rows, cols);

    root.setVisible(true);
    gridPane.setGridLinesVisible(true);

    root.getChildren().addAll(topBar, gridPane);
    return root;
  }

  private void handleEvents() {
    gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
      if (event.getTarget() instanceof Rectangle r) {
        setRectColor(r);
      }
    });

    bClear.setOnAction(e -> clearGridPane());

    bStop.setOnAction(e -> stopRandomRectangles());

    bPlayRandom.setOnAction(e -> playRandomRectangles());
  }

  private HBox createTopBar() {
    topBar = new HBox();
    topBar.setSpacing(10);
    topBar.setPadding(new Insets(10, 10, 10, 0));
    bClear = new Button("Clear");
    bPlayRandom = new Button("Play");
    bStop = new Button("Stop");
    tfTime = new TextField();
    tfTime.setMaxWidth(40);
    tfTime.setMinWidth(40);
    tfTime.setPrefWidth(40);
    tfTime.setText("100");
    topBar.getChildren().addAll(bPlayRandom, tfTime, bStop, bClear);
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
    Paint col1 = Color.color(red, green, blue);
    pRect.setFill(col1);
  }

  private void playRandomRectangles() {
    timeline = new Timeline();
    timeline.getKeyFrames().add(new KeyFrame(Duration.millis(Integer.parseInt(tfTime.getText())), e -> {
      for (Node node : gridPane.getChildren()) {
        if (node instanceof Rectangle) {
          setRectColor((Rectangle) node);
        }
      }
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
    bPlayRandom.disableProperty().set(true);
    bPlayRandom.setText("Playing");
  }

  private void stopRandomRectangles() {
    timeline.stop();
    bPlayRandom.disableProperty().set(false);
    bPlayRandom.setText("Play");
  }

  private void clearGridPane() {
    for (Node node : gridPane.getChildren()) {
      if (node instanceof Rectangle) {
        ((Rectangle) node).setFill(Color.WHITE);
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
