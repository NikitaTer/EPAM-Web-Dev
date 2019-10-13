package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.interfaces.Specification;

public class OctantSpecification implements Specification {

    private int number;

    public OctantSpecification(int number) {
        this.number = number;
    }

    @Override
    public boolean specify(Cone cone) {

        double x = cone.getPoint().getX();
        double y = cone.getPoint().getY();
        double z = cone.getPoint().getZ();

        return number == findOctant(x, y, z);
    }

    private int findOctant(double x, double y, double z) {

        if (x > 0 && y > 0 && z > 0) {
            return 1;
        } else if (x < 0 && y > 0 && z > 0) {
            return 2;
        } else if (x < 0 && y < 0 && z > 0) {
            return 3;
        } else if (x > 0 && y < 0 && z > 0) {
            return 4;
        } else if (x > 0 && y > 0 && z < 0) {
            return 5;
        } else if (x < 0 && y > 0 && z < 0) {
            return 6;
        } else if (x < 0 && y < 0 && z < 0) {
            return 7;
        } else if (x > 0 && y < 0 && z < 0) {
            return 8;
        } else {
            return 0;
        }
    }
}
