package _10ComparableContent._02LSG;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIStart extends Application {

    @Override
    public void start(Stage pStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("comparableContent.fxml"));
        Parent root = fxmlLoader.load();
        pStage.setTitle("Comparable Content");
        pStage.getIcons().add(new javafx.scene.image.Image("_10ComparableContent/_02LSG/arch_logo.png"));
        pStage.setScene(new Scene(root));
        pStage.show();
    }
}
