/*
         5
       /   \
      2     7
     / \   / \
    1   3 6   8
               \
                9
 */
package _03Traversierungen._02LevelOrder._02MitQueue._02LSG;

import resources.BinarySearchTree;
import resources.List;
import resources.Queue;
import resources.Zahl;

public class _01LevelOrder {

  protected BinarySearchTree<Zahl> fillBST() {
    BinarySearchTree<Zahl> wurzel = new BinarySearchTree<>();
    int[] values = {5, 2, 7, 3, 6, 8, 1, 9};
    for (int value : values) {
      wurzel.insert(new Zahl(value));
    }
    return wurzel;
  }

  protected List<Zahl> levelOrder(BinarySearchTree<Zahl> pBaum) {
    List<Zahl> l = new List<>();
    Queue<BinarySearchTree<Zahl>> q = new Queue<>();
    q.enqueue(pBaum);
    while (!q.isEmpty()) {
      l.append(q.front().getContent());
      q.enqueue(q.front().getLeftTree());
      q.enqueue(q.front().getRightTree());
      q.dequeue();
    }
    return l;
  }

  protected void printList(List<Zahl> pListe) {
    System.out.print("|");
    pListe.toFirst();
    while (pListe.hasAccess()) {
      System.out.print(pListe.getContent().getValue() + "\t|");
      pListe.next();
    }
  }

  public static void main(String[] args) {
    _01LevelOrder app = new _01LevelOrder();
    BinarySearchTree<Zahl> meinBST = app.fillBST();

    app.printList(app.levelOrder(meinBST));
  }
}
