package resources;

public class Morsebaum {
  private final BinaryTree<String> wurzel;

  public Morsebaum() {

    BinaryTree<String> h = new BinaryTree<>("H");
    BinaryTree<String> v = new BinaryTree<>("V");
    BinaryTree<String> f = new BinaryTree<>("F");
    BinaryTree<String> l = new BinaryTree<>("L");
    BinaryTree<String> p = new BinaryTree<>("P");
    BinaryTree<String> j = new BinaryTree<>("J");
    BinaryTree<String> b = new BinaryTree<>("B");
    BinaryTree<String> x = new BinaryTree<>("X");
    BinaryTree<String> c = new BinaryTree<>("C");
    BinaryTree<String> y = new BinaryTree<>("Y");
    BinaryTree<String> q = new BinaryTree<>("Q");
    BinaryTree<String> z = new BinaryTree<>("Z");

    // 3. Ebene
    BinaryTree<String> s = new BinaryTree<>("S", h, v);
    BinaryTree<String> u = new BinaryTree<>("U", f, new BinaryTree<>());
    BinaryTree<String> r = new BinaryTree<>("R", l, new BinaryTree<>());
    BinaryTree<String> w = new BinaryTree<>("W", p, j);
    BinaryTree<String> d = new BinaryTree<>("D", b, x);
    BinaryTree<String> k = new BinaryTree<>("K", c, y);
    BinaryTree<String> g = new BinaryTree<>("G", q, z);
    BinaryTree<String> o = new BinaryTree<>("O", new BinaryTree<>(), new BinaryTree<>());

    // 2. Ebene
    BinaryTree<String> i = new BinaryTree<>("I", s, u);
    BinaryTree<String> a = new BinaryTree<>("A", r, w);
    BinaryTree<String> n = new BinaryTree<>("N", d, k);
    BinaryTree<String> m = new BinaryTree<>("M", g, o);

    // 1. Ebene
    BinaryTree<String> e = new BinaryTree<>("E", i, a);
    BinaryTree<String> t = new BinaryTree<>("T", n, m);

    // Wurzel
    wurzel = new BinaryTree<>("/", e, t);
  }

  public BinaryTree<String> getWurzel() {
    return wurzel;
  }
}

