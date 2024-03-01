package _01Grundgeruest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class MainApp extends Application {
  private GraphicsContext gc;
  private Scene scene;

  @Override
  public void start(Stage primaryStage) throws Exception {
    VBox vBox = new VBox();
    scene = new Scene(vBox, 600, 600);
    primaryStage.setScene(scene);
    primaryStage.show();

    Canvas canvas = new Canvas(400, 400);
    gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.LIGHTBLUE);
    gc.fillRect(0, 0, scene.getWidth() - 100, scene.getHeight() - 100);

    Button b_setFill = new Button("setFill");
    b_setFill.setOnAction(this::setFillColor);
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.paddingProperty().set(new Insets(4, 0, 6, 0));
    hBox.getChildren().add(b_setFill);

    vBox.getChildren().addAll(hBox, canvas);
  }

  private void setFillColor(ActionEvent event) {
    Color[] colors = {Color.RED, Color.GOLD, Color.ALICEBLUE, Color.AQUA, Color.BISQUE, Color.AQUAMARINE, Color.BEIGE, Color.BLANCHEDALMOND, Color.CORAL, Color.DARKGREEN, Color.DARKSALMON, Color.LIGHTCYAN, Color.FIREBRICK, Color.GOLD, Color.HONEYDEW};
    int number = new Random().nextInt(0, colors.length);
    gc.setFill(colors[number]);
    gc.fillRect(0, 0, scene.getWidth() - 100, scene.getHeight() - 100);
  }
}