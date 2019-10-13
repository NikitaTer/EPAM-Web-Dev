package by.epam.app.specifications;

import by.epam.app.entity.Cone;
import by.epam.app.entity.ConeRepository;
import by.epam.app.entity.ConesObserver;
import by.epam.app.entity.Point;
import by.epam.app.interfaces.ConeObserver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeSpecificationsTest {

    ConeRepository repository;

    @BeforeClass
    public void preSet() {
        repository = new ConeRepository();
        ConeObserver observer = new ConesObserver();

        repository.add(new Cone(new Point(1,1,1),1,1));
        repository.add(new Cone(new Point(-2,2,2),2,2));
        repository.add(new Cone(new Point(-3,-3,3),3,3));
        repository.add(new Cone(new Point(4,-4,4),4,4));
        repository.add(new Cone(new Point(1,1,-1),5,5));
        repository.add(new Cone(new Point(-2,2,-2),6,6));
        repository.add(new Cone(new Point(-3,-3,-3),7,7));
        repository.add(new Cone(new Point(4,-4,-4),8,8));

        repository.toList().forEach(o -> o.addObserver(observer));
    }

    @Test
    public void testAreaSpecification() {
        List<Cone> actual = repository.query(new ConeAreaSpecification(60, 200));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(-3,-3,3),3,3));
        finalList.add(new Cone(new Point(4,-4,4),4,4));
        finalList.add(new Cone(new Point(1,1,-1),5,5));

        Assert.assertEquals(actual, finalList);
    }

    @Test
    public void testHighSpecification() {
        List<Cone> actual = repository.query(new ConeHighSpecification(5, 7));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,-1),5,5));
        finalList.add(new Cone(new Point(-2,2,-2),6,6));
        finalList.add(new Cone(new Point(-3,-3,-3),7,7));

        Assert.assertEquals(actual, finalList);
    }

    @Test
    public void testRadiusSpecification() {
        List<Cone> actual = repository.query(new ConeRadiusSpecification(1, 6));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,1),1,1));
        finalList.add(new Cone(new Point(-2,2,2),2,2));
        finalList.add(new Cone(new Point(-3,-3,3),3,3));
        finalList.add(new Cone(new Point(4,-4,4),4,4));
        finalList.add(new Cone(new Point(1,1,-1),5,5));
        finalList.add(new Cone(new Point(-2,2,-2),6,6));

        Assert.assertEquals(actual, finalList);
    }

    @Test
    public void testVolumeSpecification() {
        List<Cone> actual = repository.query(new ConeVolumeSpecification(130, 360));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,-1),5,5));
        finalList.add(new Cone(new Point(-2,2,-2),6,6));
        finalList.add(new Cone(new Point(-3,-3,-3),7,7));

        Assert.assertEquals(actual, finalList);
    }

    @Test
    public void testIdSpecification() {
        List<Cone> actual = repository.query(new IdSpecification(2));

        Assert.assertEquals(actual.get(0), repository.toList().get(2));
    }

    @Test
    public void testOctantSpecification() {
        List<Cone> actual = repository.query(new OctantSpecification(1));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,1),1,1));

        Assert.assertEquals(actual, finalList);
    }

    @Test
    public void testCenterRadiusSpecification() {
        List<Cone> actual = repository.query(new RadiusSpecification(2));

        List<Cone> finalList = new ArrayList<>();
        finalList.add(new Cone(new Point(1,1,1),1,1));
        finalList.add(new Cone(new Point(1,1,-1),5,5));

        Assert.assertEquals(actual, finalList);
    }
}
