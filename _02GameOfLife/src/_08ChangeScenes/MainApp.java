package _08ChangeScenes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("First Scene");
    VBox root = new VBox();
    root.setAlignment(Pos.CENTER);
    Scene scene = new Scene(root, 300, 300);
    root.setStyle("-fx-background-color: lightblue");

    scene.setFill(Color.LIGHTBLUE);

    Button bChangeScene = new Button("Change Scene");
    Button bGoBack = new Button("Go back");

    bChangeScene.setOnAction(e -> {
      VBox newRoot = new VBox();
      newRoot.setAlignment(Pos.CENTER);
      Scene newScene = new Scene(newRoot, 400, 400);
      newRoot.setStyle("-fx-background-color: lightgreen");
      newRoot.getChildren().add(bGoBack);
      primaryStage.setScene(newScene);
      primaryStage.setTitle("New Scene");
    });

    bGoBack.setOnAction(e -> {
      primaryStage.setScene(scene);
    });
    root.getChildren().add(bChangeScene);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
