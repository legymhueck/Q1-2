package _03Traversierungen._01PreInPostorder;

import resources.BinaryTree;
import resources.BinaryTreeInteger;

public class InPrePostorder {

  public static void main(String[] args) {
    BinaryTree<Integer> integerBaum = new BinaryTreeInteger().getWurzel();

    System.out.println("\n\nInorder:");
    inorder_ausgeben(integerBaum);

    System.out.println("\n\nPreorder:");
    preorder_ausgeben(integerBaum);

    System.out.println("\n\nPostorder:");
    postorder_ausgeben(integerBaum);
  }

  private static void inorder_ausgeben(BinaryTree<Integer> pBaum) { // links, Wurzel, rechts
    if (pBaum != null && !pBaum.isEmpty()) {
      inorder_ausgeben(pBaum.getLeftTree());
      System.out.print(pBaum.getContent() + " | ");
      inorder_ausgeben(pBaum.getRightTree());
    }
  }

  private static void preorder_ausgeben(BinaryTree<Integer> pBaum) { // Wurzel, links, rechts
    if (pBaum != null && !pBaum.isEmpty()) {
      System.out.print(pBaum.getContent() + " | ");
      inorder_ausgeben(pBaum.getLeftTree());
      inorder_ausgeben(pBaum.getRightTree());
    }
  }

  private static void postorder_ausgeben(BinaryTree<Integer> pBaum) { // links, rechts, Wurzel
    if (pBaum != null && !pBaum.isEmpty()) {
      inorder_ausgeben(pBaum.getLeftTree());
      inorder_ausgeben(pBaum.getRightTree());
      System.out.print(pBaum.getContent() + " | ");
    }
  }
}
