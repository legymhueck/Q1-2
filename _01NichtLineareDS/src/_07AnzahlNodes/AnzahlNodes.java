/*
  Jeder rekursive Aufruf der Methode anzahlNodes() zählt einen Knoten.
  Zum Schluss wird die Anzahl der Knoten zurückgegeben und die Wurzel wird mitgezählt.
 */
package _07AnzahlNodes;

import resources.BinaryTree;
import resources.BinaryTreeInteger;

public class AnzahlNodes {

  private static int nodesZaehlen(BinaryTree<Integer> pBaum) {
    int anzahlNodes;
    if (pBaum == null || pBaum.isEmpty()) {
      return 0;
    }
    // Zähle die Nodes in den linken und rechten Teilbäumen
    anzahlNodes = nodesZaehlen(pBaum.getLeftTree()) + nodesZaehlen(pBaum.getRightTree());

    // Oder so:
    // anzahlNodes += nodesZaehlen(pBaum.getLeftTree());
    // anzahlNodes += nodesZaehlen(pBaum.getRightTree());

    return anzahlNodes + 1; // +1, um die Wurzel zu zählen.
  }

  public static void main(String[] args) {
    int anzahlNodes = nodesZaehlen(new BinaryTreeInteger().getWurzel());
    System.out.println("Im Baum gibt es " + anzahlNodes + " Nodes.");
  }
}
