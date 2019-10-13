package by.epam.app.action.comparators;

import by.epam.app.entity.Cone;

import java.util.Comparator;

public class ConeXComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone cone1, Cone cone2) {
        return Double.compare(cone1.getPoint().getX(), cone2.getPoint().getX());
    }
}