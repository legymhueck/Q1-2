package resources;

public class Zahl implements ComparableContent<Zahl> {
  private final int value;

  public int getValue() {
    return value;
  }

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
