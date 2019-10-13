package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.interfaces.Specification;

public class ConeRadiusSpecification implements Specification {

    private double min;
    private double max;

    public ConeRadiusSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getRadius() >= min && cone.getRadius() <= max;
    }
}
