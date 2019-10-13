package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.interfaces.Specification;

public class IdSpecification implements Specification {

    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getId() == id;
    }
}
