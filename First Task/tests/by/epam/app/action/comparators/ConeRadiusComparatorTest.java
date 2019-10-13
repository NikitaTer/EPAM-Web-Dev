package by.epam.app.action.comparators;

import by.epam.app.entity.Cone;
import by.epam.app.entity.ConeRepository;
import by.epam.app.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ConeRadiusComparatorTest {

    @Test
    public void testCompare() {
        List<Cone> list = new ArrayList<>();
        list.add(new Cone(new Point(1,1,1), 10,10));
        list.add(new Cone(new Point(1,1,1), 16,16));
        list.add(new Cone(new Point(1,1,1), 6,6));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,1), 6,6));
        finalList.add(new Cone(new Point(1,1,1), 10,10));
        finalList.add(new Cone(new Point(1,1,1), 16,16));

        ConeRepository repository = new ConeRepository(list);
        repository.sort(new ConeRadiusComparator());

        Assert.assertEquals(repository.toList(), finalList);
    }
}