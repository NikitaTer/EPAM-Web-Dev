package by.epam.app.entity;

import by.epam.app.specifications.RadiusSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeRepositoryTest {

    @Test
    public void testAdd() {
        ConeRepository repository = new ConeRepository();
        Cone cone = new Cone(new Point(1,2,3),4,5);

        repository.add(cone);

        Assert.assertEquals(repository.toList().get(0), cone);
    }

    @Test
    public void testUpdate() {
        ConeRepository repository = new ConeRepository();
        Cone cone = new Cone(new Point(1,2,3),4,5);
        repository.add(cone);
        cone.setHigh(16);

        repository.update(cone);

        Assert.assertEquals(repository.toList().get(0).getHigh(), 16.0);
    }

    @Test
    public void testDelete() {
        ConeRepository repository = new ConeRepository();
        Cone cone = new Cone(new Point(1,2,3),4,5);
        repository.add(cone);

        repository.delete(cone);

        Assert.assertEquals(repository.size(), 0);
    }

    @Test
    public void testToList() {
        List<Cone> cones = new ArrayList<>();
        cones.add(new Cone(new Point(1,2,3),4,5));
        ConeRepository repository = new ConeRepository(cones);

        Assert.assertEquals(repository.toList(), cones);
    }

    @Test
    public void testSize() {
        ConeRepository repository = new ConeRepository();

        repository.add(new Cone(new Point(1,2,3),4,5));

        Assert.assertEquals(repository.size(), 1);
    }

    @Test
    public void testQuery() {
        List<Cone> fullList = new ArrayList<>();
        List<Cone> finalList = new ArrayList<>();
        Cone firstCone = new Cone(new Point(10,10,10),2,2);
        Cone secondCone = new Cone(new Point(2,2,2),3,3);
        Cone thirCone = new Cone(new Point(3,3,3),4,4);
        Cone fourthCone = new Cone(new Point(40,40,40),5,5);

        fullList.add(firstCone);
        fullList.add(secondCone);
        fullList.add(thirCone);
        fullList.add(fourthCone);

        finalList.add(secondCone);
        finalList.add(thirCone);

        ConeRepository repository = new ConeRepository(fullList);

        List<Cone> actualList = repository.query(new RadiusSpecification(6));

        Assert.assertEquals(actualList, finalList);
    }
}