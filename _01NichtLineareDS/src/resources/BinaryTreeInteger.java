package resources;

public class BinaryTreeInteger {
    private final BinaryTree<Integer> wurzel;

    public BinaryTreeInteger() {
        /* Beginn 3. Ebene*/
        BinaryTree<Integer> wLLLL = new BinaryTree<>(); // leerer linker Teilbaum
        BinaryTree<Integer> wLLLR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wLLR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wLRL = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wLRR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wRLL = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wRLR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wRRL = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wRRR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<Integer> wLLL = new BinaryTree<>(1, wLLLL, wLLLR); // linker Teilbaum zu Wurzel 5; 1 links; null rechts

        /* Beginn 2. Ebene */
        // Linke Blätter (die versteckten leeren Bäume links und rechts haben)
        BinaryTree<Integer> wLL = new BinaryTree<>(5, wLLL, wLLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        BinaryTree<Integer> wLR = new BinaryTree<>(15, wLRL, wLRR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        // Rechte Blätter (die versteckten leere Bäume links und rechts haben)
        BinaryTree<Integer> wRL = new BinaryTree<>(25, wRLL, wRLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        BinaryTree<Integer> wRR = new BinaryTree<>(35, wRRL, wRRR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        /* Ende 2. Ebene */


        // 1. Ebene: Linker und rechter Teilbaum
        BinaryTree<Integer> wL = new BinaryTree<>(10, wLL, wLR);
        BinaryTree<Integer> wR = new BinaryTree<>(30, wRL, wRR);

        // Wurzel
        wurzel = new BinaryTree<>(20, wL, wR);
    }
    
    public BinaryTree<Integer> getWurzel() {
        return wurzel;
    }
}
