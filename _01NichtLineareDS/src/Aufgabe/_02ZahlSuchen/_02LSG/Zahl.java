package Aufgabe._02ZahlSuchen._02LSG;

import resources.ComparableContent;

public class Zahl implements ComparableContent<Zahl> {
  public int getValue() {
    return value;
  }

  private final int value;

  public Zahl(int pValue) {
    value = pValue;
  }

  @Override
  public boolean isGreater(Zahl pContent) {
    return this.value > pContent.value;
  }

  @Override
  public boolean isEqual(Zahl pContent) {
    return this.value == pContent.value;
  }

  @Override
  public boolean isLess(Zahl pContent) {
    return this.value < pContent.value;
  }
}
