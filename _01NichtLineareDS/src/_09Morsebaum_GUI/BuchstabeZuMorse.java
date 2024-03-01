package _09Morsebaum_GUI;

import resources.BinaryTree;

public class BuchstabeZuMorse {
  private final BinaryTree<String> wurzel;


  public BuchstabeZuMorse(BinaryTree<String> pWurzel) {
    wurzel = pWurzel;
  }

  // Rekursion
  private String buchstabeZuMorsezeichen(String pZeichen, BinaryTree<String> pBaum, String pMorsezeichenAufPfad) {
    String ergebnis;
    if (pBaum.isEmpty()) {
      return "";
    }
    if (pBaum.getContent().equals(pZeichen)) {
      ergebnis = pMorsezeichenAufPfad;
    } else {
      ergebnis = buchstabeZuMorsezeichen(pZeichen, pBaum.getLeftTree(), pMorsezeichenAufPfad + ".") +
          buchstabeZuMorsezeichen(pZeichen, pBaum.getRightTree(), pMorsezeichenAufPfad + "-");
    }
    return ergebnis;
  }

  public String printAllLetters(String pText) {
    pText = pText.toUpperCase();
    StringBuilder code = new StringBuilder();
    for (int i = 0; i < pText.length(); i++) {
      String zeichen = String.valueOf(pText.charAt(i));
      code.append(buchstabeZuMorsezeichen(zeichen, wurzel, ""));
      code.append("/");
    }
    return code.toString();
  }
}
