/*
private static final String ANSI_RESET = "\u001B[0m";
private static final String ANSI_BLACK = "\u001B[30m";
private static final String ANSI_RED = "\u001B[31m";
private static final String ANSI_GREEN = "\u001B[32m";
private static final String ANSI_YELLOW = "\u001B[33m";
private static final String ANSI_BLUE = "\u001B[34m";
private static final String ANSI_PURPLE = "\u001B[35m";
private static final String ANSI_CYAN = "\u001B[36m";
private static final String ANSI_WHITE = "\u001B[37m";
 */
package _11BinarySearchTree.Aufgabe._02ZahlSuchen._02LSG;

import resources.BinarySearchTree;

import java.util.Random;
import java.util.Scanner;

public class ZahlSuchen {
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_BLACK = "\u001B[30m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_PURPLE = "\u001B[35m";
  private static final String ANSI_CYAN = "\u001B[36m";
  private static final String ANSI_WHITE = "\u001B[37m";

  private int zahlEingeben() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(ANSI_PURPLE + "Im ZahlenBST sind 10 Zahlen zwischen 0 und 100." + ANSI_RESET);
    System.out.print("Welche Zahl soll dort gesucht werden? ");
    return scanner.nextInt();
  }

  private void sucheZahlImBST(BinarySearchTree<Zahl> pBST, int pZahl) {
    if (pBST.search(new Zahl(pZahl)) != null) {
      System.out.printf("\n" + "Zahl " + ANSI_CYAN + "%d" + ANSI_RESET + " im ZahlenBST " + ANSI_GREEN + " gefunden " + ANSI_RESET + ".", pZahl);
    } else {
      System.out.printf("\n" + "Zahl " + ANSI_CYAN + "%d" + ANSI_RESET + " im ZahlenBST " + ANSI_RED + "nicht" + ANSI_RESET + " gefunden. ", pZahl);
    }
  }

  private void printBST_preorder(BinarySearchTree<Zahl> pBST) {
    if (pBST != null && !pBST.isEmpty()) {
      System.out.print(pBST.getContent().getValue() + " | ");
      printBST_preorder(pBST.getLeftTree());
      printBST_preorder(pBST.getRightTree());
    }
  }

  private void printBST_inorder(BinarySearchTree<Zahl> pBST) {
    if (pBST != null && !pBST.isEmpty()) {
      printBST_inorder(pBST.getLeftTree());
      System.out.print(pBST.getContent().getValue() + " | ");
      printBST_inorder(pBST.getRightTree());
    }
  }

  private void printBST_postorder(BinarySearchTree<Zahl> pBST) {
    if (pBST != null && !pBST.isEmpty()) {
      printBST_postorder(pBST.getLeftTree());
      printBST_postorder(pBST.getRightTree());
      System.out.print(pBST.getContent().getValue() + " | ");
    }
  }

  private BinarySearchTree<Zahl> fillBSTWithRandomNumbers() {
    BinarySearchTree<Zahl> bst = new BinarySearchTree<>();
    for (int i = 0; i < 10; i++) {
      bst.insert(new Zahl(new Random().nextInt(0, 101)));
    }
    return bst;
  }

  public static void main(String[] args) {
    ZahlSuchen app = new ZahlSuchen();
    BinarySearchTree<Zahl> zahlenBST = app.fillBSTWithRandomNumbers();
    int zahl = app.zahlEingeben();
    app.sucheZahlImBST(zahlenBST, zahl);
    System.out.println("\n\n" + ANSI_BLUE + "Diese Zahlen sind im Suchbaum:" + ANSI_RESET);

    System.out.println(ANSI_YELLOW + "Preorder:" + ANSI_RESET);
    app.printBST_preorder(zahlenBST);

    System.out.println("\n" + ANSI_YELLOW + "Inorder:" + ANSI_RESET);
    app.printBST_inorder(zahlenBST);

    System.out.println("\n" + ANSI_YELLOW + "Postorder:" + ANSI_RESET);
    app.printBST_postorder(zahlenBST);
  }
}
