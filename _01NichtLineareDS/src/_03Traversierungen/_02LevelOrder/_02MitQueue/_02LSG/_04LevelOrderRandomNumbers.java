package _03Traversierungen._02LevelOrder._02MitQueue._02LSG;

import resources.BinarySearchTree;
import resources.Zahl;

import java.util.Random;

public class _04LevelOrderRandomNumbers extends _01LevelOrder {

  public _04LevelOrderRandomNumbers() {
    super();
  }

  private BinarySearchTree<Zahl> fillBSTWithRandomNumbers() {
    BinarySearchTree<Zahl> wurzel = new BinarySearchTree<>();
    int[] values = new int[10];
    for (int i = 0; i < 10; i++) {
      values[i] = new Random().nextInt(0, 100);
    }
    for (int value : values) {
      wurzel.insert(new Zahl(value));
    }
    return wurzel;
  }

  public static void main(String[] args) {
    _04LevelOrderRandomNumbers app = new _04LevelOrderRandomNumbers();
    BinarySearchTree<Zahl> meinBST = app.fillBSTWithRandomNumbers();

    app.printList(app.levelOrder(meinBST));
  }
}
