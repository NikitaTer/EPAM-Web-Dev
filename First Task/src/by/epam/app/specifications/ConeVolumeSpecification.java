package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.entity.ConeWarehouse;
import by.epam.app.interfaces.Specification;

public class ConeVolumeSpecification implements Specification {

    private double min;
    private double max;

    public ConeVolumeSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Cone cone) {
        return  ConeWarehouse.getInstance().getVolume(cone.getId()) >= min &&
                ConeWarehouse.getInstance().getVolume(cone.getId()) <= max;
    }
}
