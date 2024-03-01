package _13LevelOrder._01OhneQueue_Mit_Tiefe;

import resources.BinarySearchTree;
import resources.Zahl;


public class LevelOrder {

  private static BinarySearchTree<Zahl> fillTree(BinarySearchTree<Zahl> pWurzel) {
    // Ausgehend von der Wurzel werden die Zahlen 5, 2, 7, 3, 6, 8, 1, 9 eingefügt.
    // Da der BinarySearchTree das Interface ComparableContent implementiert,
    // werden kleinere Zahlen links von der Wurzel und größere Zahlen rechts von der Wurzel eingefügt.
    pWurzel.insert(new Zahl(5));
    pWurzel.insert(new Zahl(2));
    pWurzel.insert(new Zahl(7));
    pWurzel.insert(new Zahl(3));
    pWurzel.insert(new Zahl(6));
    pWurzel.insert(new Zahl(8));
    pWurzel.insert(new Zahl(1));
    pWurzel.insert(new Zahl(9));
    return pWurzel;
  }

  public static int tiefe(BinarySearchTree<Zahl> pBaum) {
    int tiefe = -1;

    if (pBaum == null || pBaum.isEmpty()) {
      return tiefe;
    }

    int tiefeLinks = tiefe(pBaum.getLeftTree());   // rekursiver Aufruf
    int tiefeRechts = tiefe(pBaum.getRightTree()); // rekursiver Aufruf
    tiefe = tiefeLinks;
    if (tiefe < tiefeRechts) {
      tiefe = tiefeRechts;
    }
    return tiefe + 1; // tiefste Tiefe (links oder rechts) plus Wurzel
  }

  private static void printLevelOrder(BinarySearchTree<Zahl> pTree) {
    int tiefe = tiefe(pTree);
    for (int level = 0; level <= tiefe; level++) {
      printLevel(pTree, level);
    }
  }

  private static void printLevel(BinarySearchTree<Zahl> pTree, int pLevel) {
    if (pTree == null || pTree.isEmpty()) {
      return;
    }
    if (pLevel == 0) {
      System.out.print(pTree.getContent().getValue() + " "); // Wurzel drucken
    } else {
      printLevel(pTree.getLeftTree(), pLevel - 1);
      printLevel(pTree.getRightTree(), pLevel - 1);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree<Zahl> tree = fillTree(new BinarySearchTree<>());
    printLevelOrder(tree);
  }
}
