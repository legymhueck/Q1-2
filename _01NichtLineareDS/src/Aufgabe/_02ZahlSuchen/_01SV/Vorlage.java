package Aufgabe._02ZahlSuchen._01SV;

import _11BinarySearchTree.Aufgabe._02ZahlSuchen._02LSG.Zahl;
import resources.BinarySearchTree;

public interface Vorlage {
  int zahlEingeben();
  void sucheZahlImBST(BinarySearchTree<Zahl> pBST, int pZahl);
  void printBST_preorder(BinarySearchTree<Zahl> pBST);
  BinarySearchTree<Zahl> fillBSTWithRandomNumbers();

  /*
  Eure main Methode sollte in etwa so aussehen:
  public static void main(String[] args) {
    MainApp app = new MainApp();
    BinarySearchTree<Zahl> zahlenBST = app.fillBSTWithRandomNumbers();
    int zahl = app.zahlEingeben();
    app.sucheZahlImBST(zahlenBST, zahl);
    System.out.println("\n\n\u001B[34mDiese Zahlen sind im Suchbaum:\u001B[0m");

    System.out.println("\n\u001B[35mInorder:\u001B[0m");
    app.printBST_inorder(zahlenBST);
  }
   */
}
