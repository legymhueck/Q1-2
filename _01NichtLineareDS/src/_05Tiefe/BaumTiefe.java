package _05Tiefe;

import resources.BinaryTree;
import resources.BinaryTreeString;

public class BaumTiefe {
    public static int tiefe(BinaryTree<String> pBaum) {
        int tiefe = -1;

        /*
          1. Fall: Der Baum ist leer
           - leere Bäume haben die Tiefe -1
           - Bäume, die nur aus einem Blatt bestehen, haben die Tiefe 0

         */
        if (pBaum == null || pBaum.isEmpty()) {
            return tiefe;
        }

        // 2. Fall
        int tiefeLinks = tiefe(pBaum.getLeftTree());   // rekursiver Aufruf
        int tiefeRechts = tiefe(pBaum.getRightTree()); // rekursiver Aufruf
        tiefe = tiefeLinks;
        if (tiefe < tiefeRechts) {
            tiefe = tiefeRechts;
        }

        return tiefe + 1; // +1, weil die Wurzel auch zur Tiefe zählt
    }

    public static void main(String[] args) {
        System.out.println("Tiefe des Baumes: " + tiefe(new BinaryTreeString().getWurzel()));
    }
}
