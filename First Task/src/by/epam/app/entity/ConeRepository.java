package by.epam.app.entity;

import by.epam.app.interfaces.IRepository;
import by.epam.app.interfaces.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository implements IRepository {

    private List<Cone> cones;

    public ConeRepository() {
        cones = new ArrayList<>();
    }

    public ConeRepository(List<Cone> cones) {
        this.cones = cones;
    }

    @Override
    public void add(Cone cone) {
        cones.add(cone);
    }

    @Override
    public void update(Cone cone) {
        if (cones.contains(cone)) {
            for (Cone c : cones) {
                if (c.getId() == cone.getId()) {
                    c = cone;
                }
            }
        }
    }

    @Override
    public void delete(Cone cone) {
        cones.remove(cone);
    }

    @Override
    public void sort(Comparator<Cone> comparator) {
        cones.sort(comparator);
    }

    @Override
    public int size() {
        return cones.size();
    }

    @Override
    public List<Cone> toList() {
        return cones;
    }

    @Override
    public List<Cone> query(Specification specification) {
        return cones.stream().filter(specification::specify).collect(Collectors.toList());
    }
}