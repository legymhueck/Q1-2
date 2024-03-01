# Rekursion Erklärung

## Ein einfaches Beispiel in Java

```java
public static int summe(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n + summe(n - 1);
    }
  }
  
  public static void main(String[] args) {
    System.out.println("Die Summe von 1 bis 5 ist " + summe(3) + ".");
  }    
```

## Wie funktioniert die Methode?

- In diesem Code ruft die Methode `summe` sich selbst auf, um die Summe aller Zahlen von 1 bis n zu berechnen.
  - Wenn n größer als 0 ist, addiert die Methode n zum Ergebnis von sum(n - 1).
  - Dieser rekursive Aufruf setzt sich fort, bis n gleich 0 ist, dann gibt die Methode 0 zurück.
  - Das ist der `Basisfall` (`base case`) der Rekursion.

## Beziehung Basisfall zu Rekursion

- Bei jedem rekursiven Aufruf addiert die Methode n zum Ergebnis von `summe(n - 1)`. Dieser Prozess setzt sich fort, bis n gleich 0 ist.
- Wenn n 0 erreicht, gibt die Methode 0 zurück. Dies ist der Basisfall der Rekursion.
- Aber das bedeutet nicht, dass die Methode immer 0 zurückgibt. **Die Rückgabe von 0 ist nur der letzte Schritt in der rekursiven Kette**. Alle vorherigen rekursiven Aufrufe haben n zum Ergebnis hinzugefügt. Daher ist das Endergebnis die Summe aller Zahlen von 1 bis n.

Hier ist eine Schritt-für-Schritt-Darstellung der Ausführung der Methode summe(3):

- summe(3) wird aufgerufen.
  - Da n größer als 0 ist, wird 3 + summe(2) zurückgegeben.
- summe(2) wird aufgerufen.
  - Da n größer als 0 ist, wird 2 + summe(1) zurückgegeben.
- summe(1) wird aufgerufen.
  - Da n größer als 0 ist, wird 1 + summe(0) zurückgegeben.
- summe(0) wird aufgerufen.
  - Da n gleich 0 ist, wird 0 zurückgegeben.

Die Rückgabewerte werden zusammengesetzt: 3 + 2 + 1 + 0 = 6.

Daher gibt die Methode summe(3) den Wert 6 zurück, nicht 0. Der Wert 0 wird nur im letzten Schritt der Rekursion zurückgegeben, wenn n gleich 0 ist. Aber alle vorherigen rekursiven Aufrufe haben zur Gesamtsumme beigetragen. Das ist das Konzept der Rekursion. Nach dem Prinzip "Teile und Herrsche" werden komplexe Probleme in kleinere, handhabbare Teile zerlegt. Jeder rekursive Aufruf behandelt einen kleineren Teil des Problems, bis das gesamte Problem gelöst ist.
