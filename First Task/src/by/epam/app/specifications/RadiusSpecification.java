package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.interfaces.Specification;

public class RadiusSpecification implements Specification {

    private double radius;

    public RadiusSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(Cone cone) {
        double d =  Math.sqrt(    Math.pow(cone.getPoint().getX(), 2)
                                + Math.pow(cone.getPoint().getY(), 2)
                                + Math.pow(cone.getPoint().getZ(), 2));

        return d < radius;
    }
}