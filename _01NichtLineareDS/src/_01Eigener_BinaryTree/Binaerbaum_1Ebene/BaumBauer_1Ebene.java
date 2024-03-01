package _01Eigener_BinaryTree.Binaerbaum_1Ebene;

import _01Eigener_BinaryTree._01Implementierung._02LSG.Baum;

public class BaumBauer_1Ebene {
  private final Baum<Integer> wurzel; // Die Wurzel repräsentiert den gesamten Baum

  public BaumBauer_1Ebene() {

    Baum<Integer> wLL = new Baum<>(); // Konstruktor für einen leeren Baum
    Baum<Integer> wLR = new Baum<>(); // Konstruktor für einen leeren Baum
    Baum<Integer> wRL = new Baum<>(); // Konstruktor für einen leeren Baum
    Baum<Integer> wRR = new Baum<>(); // Konstruktor für einen leeren Baum

    Baum<Integer> linkerTeilBaum = new Baum<>(1, wLL, wLR); // linkes Blatt mit 2 leeren Teilbäumen
    Baum<Integer> rechterTeilbaum = new Baum<>(3, wRL, wRR); // rechtes Blatt mit 2 leeren Teilbäumen

    wurzel = new Baum<>(2, linkerTeilBaum, rechterTeilbaum); // Wurzel mit 2 Blättern, linker und rechter Teilbaum
  }

  private void baumDruckenNichtRekursiv() {
    System.out.println("  " + wurzel.getInhalt());
    System.out.print("" + wurzel.getLinkerTeilbaum().getInhalt());
    System.out.println("   " + wurzel.getRechterTeilbaum().getInhalt());
  }

  public static void main(String[] args) {
    // Die Klasse BaumBauer_1Ebene wird anonym instanziiert
    // und der Konstruktor wird aufgerufen, damit der Baum gebaut wird.
    new BaumBauer_1Ebene().baumDruckenNichtRekursiv();
  }
}
