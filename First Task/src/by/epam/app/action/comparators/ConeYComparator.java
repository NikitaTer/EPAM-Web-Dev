package by.epam.app.action.comparators;

import by.epam.app.entity.Cone;

import java.util.Comparator;

public class ConeYComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone cone1, Cone cone2) {
        return Double.compare(cone1.getPoint().getY(), cone2.getPoint().getY());
    }
}
