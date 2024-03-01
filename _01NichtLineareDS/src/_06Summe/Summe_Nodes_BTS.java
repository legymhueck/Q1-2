/*
Summe des Baumes berechnen
Wurzel: 20
Teilbaum links: 1 + 5 + 10 + 15 = 31
Teilbaum rechts: 25 + 30 + 35 = 90
Summe des Baumes: 141
 */
package _06Summe;

import resources.BinaryTree;
import resources.BinaryTreeString;

public class Summe_Nodes_BTS {

    private static int summe(BinaryTree<String> pBaum) {
        if (pBaum == null || pBaum.isEmpty()) {
            return 0;
        }
        int summeRoot = Integer.parseInt(pBaum.getContent());
        int summeLinks = summe(pBaum.getLeftTree());
        int summeRechts = summe(pBaum.getRightTree());
        return summeRoot + summeLinks + summeRechts;
    }

    public static void main(String[] args) {
        System.out.println("Summe der Nodes: " + summe(new BinaryTreeString().getWurzel()));
    }
}
