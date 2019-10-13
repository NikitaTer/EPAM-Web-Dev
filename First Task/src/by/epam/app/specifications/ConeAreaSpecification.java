package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.entity.ConeWarehouse;
import by.epam.app.interfaces.Specification;

public class ConeAreaSpecification implements Specification {

    private double min;
    private double max;

    public ConeAreaSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Cone cone) {
        return  ConeWarehouse.getInstance().getArea(cone.getId()) >= min &&
                ConeWarehouse.getInstance().getArea(cone.getId()) <= max;
    }
}