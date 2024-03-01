package _09Morsebaum_GUI;

import resources.BinaryTree;

public class MorseZuBuchstabe {
  private final BinaryTree<String> wurzel;

  public MorseZuBuchstabe(BinaryTree<String> pWurzel) {
    wurzel = pWurzel;
  }

  // Nicht rekursiv
  public String morsezeichenZuBuchstabe(String pMorseCode) {
    BinaryTree<String> baum = wurzel;
    StringBuilder klartext = new StringBuilder();

    for (int i = 0; i < pMorseCode.length(); i++) {
      if (pMorseCode.charAt(i) == '/') {
        klartext.append(baum.getContent());
        baum = wurzel;
      } else if (pMorseCode.charAt(i) == '.') {
        baum = baum.getLeftTree();
      } else if (pMorseCode.charAt(i) == '-') {
        baum = baum.getRightTree();
      }
    }
    return klartext.toString();
  }
}
