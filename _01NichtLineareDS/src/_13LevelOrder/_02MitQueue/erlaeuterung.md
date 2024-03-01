# Level Order Ausgabe eines Baumes mit Queue und Liste

Die Level Order Ausgabe (auch Breadth First Search oder BFS genannt) durchläuft einen Baum in Ebenen, beginnend mit der Wurzel. Alle Knoten in derselben Ebene werden **vor** den Knoten in der nächsten Ebene ausgegeben.

Es spielt keine Rolle, ob ein Baum, Binärbaum oder binärer Suchbaum durchlaufen wird. Der Algorithmus ist derselbe.

## Verfahren

### Initialisierung

- **Queue**: Erstelle eine leere Queue, die einen Baum mit einem Inhaltsobjekt verwalten kann.
- **Liste**: Erstelle eine leere Liste, die das Inhaltsobjekt verwalten kann.
- Füge die **Wurzel** des Baumes in die Queue ein. An der Wurzel hängt natürlich der gesamte Baum.

**WICHTIG:**

- Nach einem Schleifendurchlauf wird jeweils die Wurzel – und damit der komplette Baum / Teilbaum – entfernt.
- Da wir vor dem Entfernen jeweils die Wurzel des linken und rechten Teilbaumes in die Queue eingefügt haben, enthält die Queue nach einem Durchlauf die Wurzeln der nächsten Ebene (mit ihren jeweiligen Teilbäumen).

### while-Schleife

Solange die Queue nicht leer ist:

- Füge das Inhaltsobjekt des aktuellen Knotens in die Liste ein.
- Füge den linken **Knoten** in die Queue ein. An diesem Knoten hängt (natürlich) der linke Teilbaum.
- Füge den rechten **Knoten** in die Queue ein. An diesem Knoten hängt (natürlich) der rechte Teilbaum.
- Entferne den vordersten Knoten aus der Queue und damit auch alles, was an diesem Knoten hängt.

### Ausgabe der Liste

Die Liste enthält die Werte der Knoten in der Reihenfolge, in der sie vom Baum durchlaufen wurden.

## Code

```java
// q ist die Queue, die die Knoten speichert.
// l ist die Liste, die die Inhaltsobjekte speichert.

// Einmalig: Die Wurzel des Baumes in die Queue einfügen.
q.enqueue(wurzel);

// Immer wieder, solange bis die Queue leer ist: Die linken und rechten Knoten des aktuellen Knotens in die Queue einfügen.
l.append(q.front().getContent());
q.enqueue(q.front().getLeftTree());
q.enqueue(q.front().getRightTree());
q.dequeue();
```

## Beispiel

Angenommen, wir haben den folgenden Baum:

```html
         5
       /   \
      2     7
     / \   / \
    1   3 6   8
               \
                9
```

### Durchlauf für den obigen Baum

**Einmalig**:

- Wurzel (5) in die Queue einfügen. **An der Wurzel hängt der gesamte Baum.**

**Immer wieder, solange bis die Queue leer ist**:

- 5 in die Liste einfügen.
- Den linken Knoten, also die 2, in die Queue einfügen (und damit den gesamten linken Teilbaum).
- Den rechten Knoten, also die 7, in die Queue einfügen (und damit den gesamten rechten Teilbaum).
- 5 aus der Queue entfernen (und damit den gesamten Baum).

**→ Der erste Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt den gesamten linken Teilbaum mit der Wurzel 2.
- Die Queue enthält ebenfalls den gesamten rechten Teilbaum mit der Wurzel 7.
- Die Liste enthält jetzt die 5.

---

- 2 in die Liste einfügen.
- Den linken Knoten, also die 1, in die Queue einfügen (und damit den gesamten linken Teilbaum).
- Den rechten Knoten, also die 3, in die Queue einfügen (und damit den gesamten rechten Teilbaum).
- 2 aus der Queue entfernen.

**→ Der zweite Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt den gesamten rechten Teilbaum mit der Wurzel 7.
- Sie enthält zudem den linken Teilbaum mit der Wurzel 1, an der zwei leere Blätter hängen.
- Sie enthält zudem den rechten Teilbaum mit der Wurzel 3, an der links ein leeres Blatt und rechts der Teilbaum 4 hängt.
- Die Liste enthält jetzt die 5 und die 2.

---

- 7 in die Liste einfügen.
- Den linken Knoten, also die 6, in die Queue einfügen (und damit den gesamten linken Teilbaum).
- Den rechten Knoten, also die 8, in die Queue einfügen (und damit den gesamten rechten Teilbaum).
- 7 aus der Queue entfernen.

**→ Der dritte Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt die 1, die 3, die 6 und die 8 (mit ihren jeweiligen Teilbäumen).
- Die Liste enthält jetzt die 5, die 2 und die 7.

---

- 1 in die Liste einfügen.
- Den linken Knoten, also den leeren Teilbaum `null`, in die Queue einfügen.
- Den rechten Knoten, also den leeren Teilbaum `null`, in die Queue einfügen.
- 1 aus der Queue entfernen.

**→ Der vierte Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt die 3, die 6 und die 8 (mit ihren jeweiligen Teilbäumen).
- Die Liste enthält jetzt die 5, die 2, die 7 und die 1.

---

- 3 in die Liste einfügen.
- Den linken Knoten, also `null`, in die Queue einfügen.
- Den rechten Knoten, also `null`, in die Queue einfügen.
- 3 aus der Queue entfernen.

**→ Der fünfte Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt die 6 und die 8 (mit ihren jeweiligen Teilbäumen).
- Die Liste enthält jetzt die 5, die 2, die 7, die 1 und die 3.

---

- 6 in die Liste einfügen.
- Den linken Knoten, also `null`, in die Queue einfügen.
- Den rechten Knoten, also `null`, in die Queue einfügen.
- 6 aus der Queue entfernen.

**→ Der sechste Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt die 8 (mit ihren jeweiligen Teilbäumen).
- Die Liste enthält jetzt die 5, die 2, die 7, die 1, die 3 und die 6.

---

- 8 in die Liste einfügen.
- Den linken Knoten, also `null`, in die Queue einfügen.
- Den rechten Knoten, also die 9, in die Queue einfügen.
- 8 aus der Queue entfernen.

**→ Der siebte Durchlauf der while-Schleife ist beendet.**

- Die Queue enthält jetzt die 9 (mit ihren jeweiligen Teilbäumen).
- Die Liste enthält jetzt die 5, die 2, die 7, die 1, die 3, die 6 und die 8.

---

- 9 in die Liste einfügen.
- Den linken Knoten, also `null`, in die Queue einfügen.
- Den rechten Knoten, also `null`, in die Queue einfügen.
- 9 aus der Queue entfernen.

**→ Der achte und letzte Durchlauf der while-Schleife ist beendet.**

- Die Queue ist jetzt leer.
- Die Liste enthält jetzt die 5, die 2, die 7, die 1, die 3, die 6, die 8 und die 9.

---

### Zusammenfassung

Man sieht hier, dass jeweils der linke und rechte Knoten, an dem ein Teilbaum hängt, in die Queue eingefügt wird, bevor der aktuelle Knoten aus der Queue entfernt wird.

#### Ausgabe der Liste, die die Level Order Ausgabe des Baumes enthält

5, 2, 7, 1, 3, 6, 8, 9

## Optimierung

Falls der linke oder rechte Teilbaum leer ist, wird dieser **NICHT** in die Queue eingefügt.

```java
if (!q.front().getLeftTree().isEmpty()) {
  l.enqueue(q.front().getLeftTree());
}
if (!q.front().getRightTree().isEmpty()) {
  l.enqueue(q.front().getRightTree());
}
```
