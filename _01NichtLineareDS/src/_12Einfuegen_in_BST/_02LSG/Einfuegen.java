/*
Aufgabe:
Füge die Zahlen 5, 2, 7, 3, 4, 6, 8, 1 und 9 in einen leeren Binärbaum ein.
Ergänze anschließend die jeweilige Print-Anweisung, um den zuvor eingefügten Node auszugeben.
 */
package _12Einfuegen_in_BST._02LSG;

import resources.BinarySearchTree;
import resources.Zahl;

public class Einfuegen {

  public static void main(String[] args) {
    BinarySearchTree<Zahl> bstZahl = new BinarySearchTree<>();
    bstZahl.insert(new Zahl(5));
    System.out.println("Wurzel: " + bstZahl.getContent().getValue());

    bstZahl.insert(new Zahl(2));
    System.out.println("Teilbaum links: " + bstZahl.getLeftTree().getContent().getValue());

    bstZahl.insert(new Zahl(7));
    System.out.println("Teilbaum rechts: " + bstZahl.getRightTree().getContent().getValue());

    bstZahl.insert(new Zahl(3));
    System.out.println("Teilbaum links, rechts: " + bstZahl.getLeftTree().getRightTree().getContent().getValue());

    bstZahl.insert(new Zahl(6));
    System.out.println("Teilbaum rechts, links: " + bstZahl.getRightTree().getLeftTree().getContent().getValue());

    bstZahl.insert(new Zahl(8));
    System.out.println("Teilbaum rechts, rechts: " + bstZahl.getRightTree().getRightTree().getContent().getValue());

    bstZahl.insert(new Zahl(1));
    System.out.println("Teilbaum links, links: " + bstZahl.getLeftTree().getLeftTree().getContent().getValue());

    bstZahl.insert(new Zahl(9));
    System.out.println("Teilbaum rechts, rechts, rechts: " + bstZahl.getRightTree().getRightTree().getRightTree().getContent().getValue());

    System.out.println("LevelOrder: 5, 2, 7, 1, 3, 6, 8, 9");
    System.out.println("Ebene 1: 5");
    System.out.println("Ebene 2: 2, 7");
    System.out.println("Ebene 3: 1, 3, 6, 8");
    System.out.println("Ebene 4: 9");
  }
}
