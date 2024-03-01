package _09Morsebaum_GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import resources.BinaryTree;
import resources.Morsebaum;

public class MorseController {
  private final BuchstabeZuMorse letterToMorse;
  private final MorseZuBuchstabe morseToLetter;

  public MorseController() {
    Morsebaum morsebaum = new Morsebaum();
    BinaryTree<String> wurzel = morsebaum.getWurzel();
    letterToMorse = new BuchstabeZuMorse(wurzel);
    morseToLetter = new MorseZuBuchstabe(wurzel);
  }

  @FXML
  Button bEncode;

  @FXML
  Button bDecode;

  @FXML
  TextField tfInput;

  @FXML
  TextField tfOutput;

  @FXML
  void oaEncode() {
    String input = tfInput.getText();
    tfOutput.setText(letterToMorse.printAllLetters(input));
  }

  @FXML
  void oaDecode() {
    String input = tfInput.getText();
    tfOutput.setText(morseToLetter.morsezeichenZuBuchstabe(input));
  }

  @FXML
  void oaClear() {
    tfInput.clear();
    tfOutput.clear();
  }
}
