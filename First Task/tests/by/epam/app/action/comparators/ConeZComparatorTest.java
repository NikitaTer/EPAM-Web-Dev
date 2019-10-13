package by.epam.app.action.comparators;

import by.epam.app.entity.Cone;
import by.epam.app.entity.ConeRepository;
import by.epam.app.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ConeZComparatorTest {

    @Test
    public void testCompare() {
        List<Cone> list = new ArrayList<>();
        list.add(new Cone(new Point(2,1,2), 10,7));
        list.add(new Cone(new Point(3,1,3), 16,7));
        list.add(new Cone(new Point(1,1,1), 6,7));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,1), 6,7));
        finalList.add(new Cone(new Point(2,1,2), 10,7));
        finalList.add(new Cone(new Point(3,1,3), 16,7));

        ConeRepository repository = new ConeRepository(list);
        repository.sort(new ConeZComparator());

        Assert.assertEquals(repository.toList(), finalList);
    }
}