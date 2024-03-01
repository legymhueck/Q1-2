package _02Rekursion;

public class Summe_rekursiv {
  public static int summe(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n + summe(n - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println("Die Summe von 1 bis 3 ist " + summe(3) + ".");
    System.out.println("Rechnung: 1 + 2 + 3 = 6");
  }
}
