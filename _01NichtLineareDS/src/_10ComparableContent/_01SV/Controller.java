package _10ComparableContent._01SV;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private Schueler s1;
    private Schueler s2;

    @FXML
    public TextField tfInput1;

    @FXML
    public TextField tfInput2;

    @FXML
    public Label lOutput;

    @FXML
    void oaIsGreater() {
        if (areInputFieldsEmpty()) {
            inputFelderEinlesen();
            lOutput.setText(String.valueOf(s1.isGreater(s2)));
        } else {
            alert();
        }
    }

    private void alert() {
        new Alert(Alert.AlertType.ERROR, "Bitte beide Eingabefelder ausfüllen!").showAndWait();
    }

    @FXML
    void oaIsLess() {
        if (areInputFieldsEmpty()) {
            inputFelderEinlesen();
            lOutput.setText(String.valueOf(s1.isLess(s2)));
        } else {
            alert();
        }
    }

    @FXML
    void oaIsEqual() {
        if (areInputFieldsEmpty()) {
            inputFelderEinlesen();
            lOutput.setText(String.valueOf(s1.isEqual(s2)));
        } else {
            alert();
        }
    }

    @FXML
    void oaClear() {
        tfInput1.clear();
        tfInput2.clear();
        lOutput.setText("");
    }

    private boolean areInputFieldsEmpty() {
        return !tfInput1.getText().isEmpty() && !tfInput2.getText().isEmpty();
    }

    private void inputFelderEinlesen() {
        s1 = new Schueler(tfInput1.getText());
        s2 = new Schueler(tfInput2.getText());
    }
}
