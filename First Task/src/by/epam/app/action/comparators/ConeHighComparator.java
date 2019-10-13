package by.epam.app.action.comparators;

import by.epam.app.entity.Cone;

import java.util.Comparator;

public class ConeHighComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone cone1, Cone cone2) {
        return Double.compare(cone1.getHigh(), cone2.getHigh());
    }
}
