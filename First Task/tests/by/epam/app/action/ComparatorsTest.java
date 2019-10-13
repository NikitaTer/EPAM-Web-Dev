package by.epam.app.action;

import by.epam.app.action.comparators.ConeXComparator;
import by.epam.app.action.comparators.ConeYComparator;
import by.epam.app.action.comparators.ConeZComparator;
import by.epam.app.entity.Cone;
import by.epam.app.entity.ConeRepository;
import by.epam.app.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ComparatorsTest {

    @Test
    public void mainTest() {
        ConeRepository repository = new ConeRepository();

        repository.add(new Cone(new Point(3, 2, 1), 1, 1));
        repository.add(new Cone(new Point(4, 1, 3), 1, 1));
        repository.add(new Cone(new Point(3, 1, 1), 1, 1));
        repository.add(new Cone(new Point(4, 1, 1), 1, 1));
        repository.add(new Cone(new Point(1, 1, 1), 1, 1));

        repository.sort(new ConeXComparator().thenComparing(new ConeYComparator().thenComparing(new ConeZComparator())));

        List<Cone> list = new ArrayList<>();
        list.add(new Cone(new Point(1, 1, 1), 1, 1));
        list.add(new Cone(new Point(3, 1, 1), 1, 1));
        list.add(new Cone(new Point(3, 2, 1), 1, 1));
        list.add(new Cone(new Point(4, 1, 1), 1, 1));
        list.add(new Cone(new Point(4, 1, 3), 1, 1));

        Assert.assertEquals(repository.toList(), list);
    }
}