package _03Traversierungen._02LevelOrder._02MitQueue._02LSG;

import resources.BinaryTree;
import resources.Queue;
import resources.BinaryTreeString;

public class _02LevelOrderNurMitQueue {
  private void LevelOrder(BinaryTree<String> pTree) {
    Queue<BinaryTree<String>> queue = new Queue<>();
    queue.enqueue(pTree);

    while (!queue.isEmpty()) {
      BinaryTree<String> current = queue.front();
      System.out.print(current.getContent() + " | ");
      if (!current.getLeftTree().isEmpty()) {
        queue.enqueue(current.getLeftTree());
      }
      if (!current.getRightTree().isEmpty()) {
        queue.enqueue(current.getRightTree());
      }
      queue.dequeue();
    }
  }

  public static void main(String[] args) {
    _02LevelOrderNurMitQueue app = new _02LevelOrderNurMitQueue();
    BinaryTree<String> tree = new BinaryTreeString().getWurzel();
    app.LevelOrder(tree);
  }
}
