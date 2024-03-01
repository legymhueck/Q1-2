/*
         5
       /   \
      2     7
     / \   / \
    1   3 6   8
               \
                9
 */
package _13LevelOrder._02MitQueue._02LSG;

import resources.BinarySearchTree;
import resources.List;
import resources.Queue;
import resources.Zahl;

public class _04LevelOrderCountMethodCalls extends _01LevelOrder {
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private int whileSchleifeAufrufeNichtOptimiert = 0;
  private int whileSchleifeAufrufeOptimiert = 0;

  public _04LevelOrderCountMethodCalls() {
    super();
  }

  protected void levelOrderNichtOptimiert(BinarySearchTree<Zahl> pBaum) {
    List<Zahl> l = new List<>();
    Queue<BinarySearchTree<Zahl>> q = new Queue<>();
    q.enqueue(pBaum);
    while (!q.isEmpty()) {
      l.append(q.front().getContent());
      q.enqueue(q.front().getLeftTree());
      q.enqueue(q.front().getRightTree());
      q.dequeue();
      whileSchleifeAufrufeNichtOptimiert++;
    }
  }

  protected void levelOrderOptimiert(BinarySearchTree<Zahl> pBaum) {
    List<Zahl> l = new List<>();
    Queue<BinarySearchTree<Zahl>> q = new Queue<>();
    q.enqueue(pBaum);
    while (!q.isEmpty()) {
      l.append(q.front().getContent());
      if (!q.front().getLeftTree().isEmpty()) {
        q.enqueue(q.front().getLeftTree());
      }
      if (!q.front().getRightTree().isEmpty()) {
        q.enqueue(q.front().getRightTree());
      }
      q.dequeue();
      whileSchleifeAufrufeOptimiert++;
    }
  }

  public static void main(String[] args) {
    _04LevelOrderCountMethodCalls app = new _04LevelOrderCountMethodCalls();
    BinarySearchTree<Zahl> meinBST = app.fillBST();
    app.levelOrderOptimiert(meinBST);
    app.levelOrderNichtOptimiert(meinBST);

    System.out.println(ANSI_BLUE + "Nicht optimierte Methode:" + ANSI_RESET);
    System.out.println("Anzahl Durchläufe while-Schleife: " + ANSI_YELLOW + app.whileSchleifeAufrufeNichtOptimiert + ANSI_RESET);

    System.out.println(ANSI_BLUE + "\nOptimierte Methode:" + ANSI_RESET);
    System.out.println("Anzahl Durchläufe while-Schleife: " + ANSI_YELLOW + app.whileSchleifeAufrufeOptimiert + ANSI_RESET);
  }
}
