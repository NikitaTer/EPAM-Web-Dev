package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.interfaces.Specification;

public class ConeHighSpecification implements Specification {

    private double min;
    private double max;

    public ConeHighSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getHigh() >= min && cone.getHigh() <= max;
    }
}
