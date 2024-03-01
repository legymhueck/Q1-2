package _13LevelOrder._02MitQueue._02LSG;

import resources.BinarySearchTree;
import resources.Zahl;

import java.util.Random;

public class _03LevelOrderRandomNumbers extends _01LevelOrder {

  public _03LevelOrderRandomNumbers() {
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
    _03LevelOrderRandomNumbers app = new _03LevelOrderRandomNumbers();
    BinarySearchTree<Zahl> meinBST = app.fillBSTWithRandomNumbers();

    app.printList(app.levelOrder(meinBST));
  }
}
