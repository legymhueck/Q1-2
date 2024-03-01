package Aufgabe._01PersonSuchen._02LSG;

import resources.ComparableContent;

public class Person implements ComparableContent<Person> {

  private final String name;

  public Person(String pName) {
    name = pName;
  }

  @Override
  public boolean isGreater(Person pContent) {
    return this.name.compareTo(pContent.name) > 0;
  }

  @Override
  public boolean isEqual(Person pContent) {
    return this.name.compareTo(pContent.name) == 0; // oder this.name.equals(pContent.name);
  }

  @Override
  public boolean isLess(Person pContent) {
    return this.name.compareTo(pContent.name) < 0;
  }

  public String getName() {
    return name;
  }
}
