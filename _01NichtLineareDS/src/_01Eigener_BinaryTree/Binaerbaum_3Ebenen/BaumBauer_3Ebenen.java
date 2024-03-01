package _01Eigener_BinaryTree.Binaerbaum_3Ebenen;

import _01Eigener_BinaryTree._01Implementierung._02LSG.Baum;

public class BaumBauer_3Ebenen { // Die Wurzel repräsentiert den gesamten Baum
    private final Baum<Integer> wurzel;

    public BaumBauer_3Ebenen() {
        /* Beginn 3. Ebene*/
        Baum<Integer> wLLLL = new Baum<>(); // leerer linker Teilbaum
        Baum<Integer> wLLLR = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wLLR = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wLRL = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wLRR = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wRLL = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wRLR = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wRRL = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wRRR = new Baum<>(); // leerer rechter Teilbaum
        Baum<Integer> wLLL = new Baum<>(1, wLLLL, wLLLR); // linker Teilbaum zu Wurzel 5; 1 links; null rechts

        /* Beginn 2. Ebene */
        // Linke Blätter (die versteckten leeren Bäume links und rechts haben)
        Baum<Integer> wLL = new Baum<>(5, wLLL, wLLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        Baum<Integer> wLR = new Baum<>(15, wLRL, wLRR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        // Rechte Blätter (die versteckten leere Bäume links und rechts haben)
        Baum<Integer> wRL = new Baum<>(25, wRLL, wRLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        Baum<Integer> wRR = new Baum<>(35, wRRL, wRRR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        /* Ende 2. Ebene */


        // 1. Ebene: Linker und rechter Teilbaum
        Baum<Integer> wL = new Baum<>(10, wLL, wLR);
        Baum<Integer> wR = new Baum<>(30, wRL, wRR);

        // Wurzel
        wurzel = new Baum<>(20, wL, wR);
    }

    private void baumDruckenNichtRekursiv() {
        System.out.println("      " + wurzel.getInhalt());

        System.out.print("  " + wurzel.getLinkerTeilbaum().getInhalt());
        System.out.println("      " + wurzel.getRechterTeilbaum().getInhalt());

        System.out.print(" " + wurzel.getLinkerTeilbaum().getLinkerTeilbaum().getInhalt());
        System.out.print("  " + wurzel.getLinkerTeilbaum().getRechterTeilbaum().getInhalt());
        System.out.print("  " + wurzel.getRechterTeilbaum().getLinkerTeilbaum().getInhalt());
        System.out.println("  " + wurzel.getRechterTeilbaum().getRechterTeilbaum().getInhalt());

        System.out.println(wurzel.getLinkerTeilbaum().getLinkerTeilbaum().getLinkerTeilbaum().getInhalt());
    }

    public static void main(String[] args) {
        new BaumBauer_3Ebenen().baumDruckenNichtRekursiv();
    }
}
