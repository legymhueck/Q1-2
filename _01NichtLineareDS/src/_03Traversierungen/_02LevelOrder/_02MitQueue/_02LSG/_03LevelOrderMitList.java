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

public class _03LevelOrderMitList extends _01LevelOrder {

  public _03LevelOrderMitList() {
    super();
  }

  @Override
  public List<Zahl> levelOrder(BinarySearchTree<Zahl> pBaum) {
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
    }
    return l;
  }

  public static void main(String[] args) {
    _03LevelOrderMitList app = new _03LevelOrderMitList();

    BinarySearchTree<Zahl> meinBST = app.fillBST();
    app.printList(app.levelOrder(meinBST));

  }
}
