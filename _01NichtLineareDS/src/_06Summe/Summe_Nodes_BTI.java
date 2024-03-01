/*
Summe des Baumes berechnen
Wurzel: 20
Teilbaum links: 1 + 5 + 10 + 15 = 31
Teilbaum rechts: 25 + 30 + 35 = 90
Summe des Baumes: 141
 */
package _06Summe;

import resources.BinaryTree;
import resources.BinaryTreeInteger;

public class Summe_Nodes_BTI {

    private static int summe(BinaryTree<Integer> pBaum) {
        if (pBaum == null || pBaum.isEmpty()) {
            return 0;
        }
        int summeRoot = pBaum.getContent();
        System.out.print(summeRoot + " + ");
        int summeLinks = summe(pBaum.getLeftTree());
        int summeRechts = summe(pBaum.getRightTree());
        return summeRoot + summeLinks + summeRechts;
    }

    public static void main(String[] args) {
        System.out.println(" = " + summe(new BinaryTreeInteger().getWurzel()));
    }
}
