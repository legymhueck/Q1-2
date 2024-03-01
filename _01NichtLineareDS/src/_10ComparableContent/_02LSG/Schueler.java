package _10ComparableContent._02LSG;

import resources.ComparableContent;

public class Schueler implements ComparableContent<Schueler> {
    private final String name;

    public Schueler(String pName) {
        name = pName;
    }

    @Override
    public boolean isGreater(Schueler pContent) {
        return name.compareTo(pContent.name) > 0;
    }

    @Override
    public boolean isEqual(Schueler pContent) {
        return name.compareTo(pContent.name) == 0;
    }

    @Override
    public boolean isLess(Schueler pContent) {
        return name.compareTo(pContent.name) < 0;
    }
}
