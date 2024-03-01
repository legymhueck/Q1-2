package _09Zahlenpyramide;

import resources.BinaryTree;

public class Zahlenpyramide {
  private final BinaryTree<Integer> wurzel;

  public Zahlenpyramide() {
    // Blätter
    // linker Teilbaum
    BinaryTree<Integer> wLLLL = new BinaryTree<>(); // leerer linker Teilbaum
    BinaryTree<Integer> wLLLR = new BinaryTree<>(); // leerer rechter Teilbaum
    BinaryTree<Integer> wLLRL = new BinaryTree<>(); // leerer linker Teilbaum
    BinaryTree<Integer> wLRRR = new BinaryTree<>(); // leerer rechter Teilbaum
    // rechter Teilbaum
    BinaryTree<Integer> wRRRL = new BinaryTree<>(); // leerer linker Teilbaum
    BinaryTree<Integer> wRRRR = new BinaryTree<>(); // leerer rechter Teilbaum
    BinaryTree<Integer> wRLRL = new BinaryTree<>(); // leerer linker Teilbaum
    BinaryTree<Integer> wRLRR = new BinaryTree<>(); // leerer rechter Teilbaum

    /* Beginn 4. Ebene */
    BinaryTree<Integer> wLLL = new BinaryTree<>(2, wLLLL, wLLLR); // 2
    BinaryTree<Integer> wLLR = new BinaryTree<>(1, wLLRL, wLRRR); // 1
    BinaryTree<Integer> wRLR = new BinaryTree<>(2, wRLRL, wRLRR); // 2
    BinaryTree<Integer> wRRR = new BinaryTree<>(3, wRRRL, wRRRR); // 3

    /* Ende 3. Ebene */
    BinaryTree<Integer> wLL = new BinaryTree<>(0, wLLL, wLLR); // 3
    BinaryTree<Integer> wLR = new BinaryTree<>(0, wLLR, wRLR); // 3
    BinaryTree<Integer> wRR = new BinaryTree<>(0, wRLR, wRRR); // 5

    // 2. Ebene: Linker und rechter Teilbaum
    BinaryTree<Integer> wL = new BinaryTree<>(0, wLL, wLR); // 6
    BinaryTree<Integer> wR = new BinaryTree<>(0, wLR, wRR); // 8

    // Wurzel
    wurzel = new BinaryTree<>(0, wL, wR);
  }

  public BinaryTree<Integer> getWurzel() {
    return wurzel;
  }
}
