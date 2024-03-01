/*
      14
    6    8
  3   3    5
2   1   2    3

Beachte, dass der Baum so nicht gebaut werden kann, da Knoten mehrfach verwendet werden müssen.
Der Baum sieht dann als Binärbaum so aus:

      14
   6       8
 3   3   3   5
2 1 1 2 1 2 2 3

        14
     /     \
    6       8
   / \     / \
  3   3   3   5
 / \ / \ / \ / \
 2 1 1 2 1 2 2 3

 */
package _09Zahlenpyramide;

import resources.BinaryTree;

public class MainApp {

  private static int pyramideBauen(BinaryTree<Integer> pTree) {
    if (pTree.getRightTree().isEmpty() && pTree.getLeftTree().isEmpty()) {
      return pTree.getContent();
    } else {
      int linkeSumme = pyramideBauen(pTree.getLeftTree());
      int rechteSumme = pyramideBauen(pTree.getRightTree());
      pTree.setContent(linkeSumme + rechteSumme);
      return linkeSumme + rechteSumme;
    }
  }

  private static int hoeheBerechnen(BinaryTree<Integer> pTree) {
    if (pTree.isEmpty()) {
      return 0;
    } else {
      /* Höhe des linken und rechten Teilbaumes bestimmen. */
      int linksHoehe = hoeheBerechnen(pTree.getLeftTree());
      int rechtsHoehe = hoeheBerechnen(pTree.getRightTree());

      /* Die tiefste Höhe ist die maximale Höhe des Baumes. */
      if (linksHoehe > rechtsHoehe) {
        return (linksHoehe + 1);
      } else {
        return (rechtsHoehe + 1);
      }
    }
  }

  private static void bestimmeHoeheDrucken(BinaryTree<Integer> pTree, int pHoehe) {
    if (pTree.isEmpty()) {
      return;
    }
    if (pHoehe == 1) {
      System.out.print(pTree.getContent() + " ");
    } else if (pHoehe > 1) {
      bestimmeHoeheDrucken(pTree.getLeftTree(), pHoehe - 1);
      bestimmeHoeheDrucken(pTree.getRightTree(), pHoehe - 1);
    }
  }

  private static void printLevelOrder(BinaryTree<Integer> pTree) {
    for (int i = 1; i <= hoeheBerechnen(pTree); i++) {
      bestimmeHoeheDrucken(pTree, i);
      System.out.println();
    }
  }


  public static void main(String[] args) {
    BinaryTree<Integer> zp = new Zahlenpyramide().getWurzel();
    pyramideBauen(zp);
    printLevelOrder(zp);
  }
}
