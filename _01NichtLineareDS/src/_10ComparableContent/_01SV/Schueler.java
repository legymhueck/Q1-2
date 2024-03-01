package _10ComparableContent._01SV;

import resources.ComparableContent;

public class Schueler implements ComparableContent<Schueler> {
    private final String name;

    public Schueler(String pName) {
        name = pName;
    }

    @Override
    public boolean isGreater(Schueler pContent) {
        return false;
    }

    @Override
    public boolean isEqual(Schueler pContent) {
        return false;
    }

    @Override
    public boolean isLess(Schueler pContent) {
        return false;
    }
}
