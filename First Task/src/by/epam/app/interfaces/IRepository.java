package by.epam.app.interfaces;

import by.epam.app.entity.Cone;

import java.util.Comparator;
import java.util.List;

public interface IRepository {
    void add(Cone cone);
    void update(Cone cone);
    void delete(Cone cone);
    void sort(Comparator<Cone> comparator);

    int size();

    List<Cone> toList();

    List<Cone> query(Specification specification);
}
