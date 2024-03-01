package _02GridPane_und_FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene.fxml")));
    root.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
    primaryStage.setTitle("GridPane");
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
