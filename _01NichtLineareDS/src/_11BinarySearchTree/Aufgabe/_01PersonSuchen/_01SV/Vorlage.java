package _11BinarySearchTree.Aufgabe._01PersonSuchen._01SV;

import _11BinarySearchTree.Aufgabe._01PersonSuchen._02LSG.Person;
import resources.BinarySearchTree;

public interface Vorlage {
  String personEingeben();
  void suchePersonImBST(BinarySearchTree<Person> pBST, String pName);
  void printBST_inorder(BinarySearchTree<Person> pBST);

  // Die Methode fillBSTWithNames() soll einen Suchbaum mit Namen füllen.
  // Die Namen könnt ihr euch selbst ausdenken.
  // Ihr sollt aber die NRW-Liste verwenden, die ihr aus dem Package resources importieren könnt.
  // Die Namen schreibt ihr dann mit einer Schleife in den Suchbaum.
  BinarySearchTree<Person> fillBSTWithNames();

  /*
  Eure main Methode sollte in etwa so aussehen:
  public static void main(String[] args) {
    MainApp app = new MainApp();
    BinarySearchTree<Person> personenBST = app.fillBSTWithNames();
    String name = app.personEingeben();
    app.suchePersonImBST(personenBST, name);
    System.out.println("\n\n\u001B[34mDiese Namen sind im Suchbaum:\u001B[0m");

    System.out.println("\n\u001B[35mInorder:\u001B[0m");
    app.printBST_inorder(personenBST);
  }
   */
}
