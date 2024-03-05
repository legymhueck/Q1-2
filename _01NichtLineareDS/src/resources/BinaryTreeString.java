package resources;
/**
 * Klasse zum Erzeugen eines binären Baumes mit String-Elementen
 *
 *       20
 *    10   30
 *   5 15 25 35
 * 1
 */
public class BinaryTreeString {
    private final BinaryTree<String> wurzel;
    
    public BinaryTreeString() {
        /* Beginn 3. Ebene*/
        BinaryTree<String> wLLLL = new BinaryTree<>(); // leerer linker Teilbaum
        BinaryTree<String> wLLLR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wLLR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wLRL = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wLRR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wRLL = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wRLR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wRRL = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wRRR = new BinaryTree<>(); // leerer rechter Teilbaum
        BinaryTree<String> wLLL = new BinaryTree<>("1", wLLLL, wLLLR); // linker Teilbaum zu Wurzel 5; 1 links; null rechts

        /* Beginn 2. Ebene */
        // Linke Blätter (die versteckten leeren Bäume links und rechts haben)
        BinaryTree<String> wLL = new BinaryTree<>("5", wLLL, wLLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        BinaryTree<String> wLR = new BinaryTree<>("15", wLRL, wLRR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        // Rechte Blätter (die versteckten leere Bäume links und rechts haben)
        BinaryTree<String> wRL = new BinaryTree<>("25", wRLL, wRLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        BinaryTree<String> wRR = new BinaryTree<>("35", wRRL, wRRR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        /* Ende 2. Ebene */


        // 1. Ebene: Linker und rechter Teilbaum
        BinaryTree<String> wL = new BinaryTree<>("10", wLL, wLR);
        BinaryTree<String> wR = new BinaryTree<>("30", wRL, wRR);

        // Wurzel
        wurzel = new BinaryTree<>("20", wL, wR);
    }
    
    public BinaryTree<String> getWurzel() {
        return wurzel;
    }
}
