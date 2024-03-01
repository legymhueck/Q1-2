package _09Morsebaum_GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MorseGUI extends Application {

  @Override
  public void start(Stage pStage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("morseGUI.fxml"));
    Parent root = fxmlLoader.load();
    pStage.setTitle("Lehnen - MorseGUI");
    pStage.setScene(new Scene(root));
    pStage.show();
  }
}

