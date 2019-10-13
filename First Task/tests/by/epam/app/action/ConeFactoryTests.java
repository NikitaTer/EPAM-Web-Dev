package by.epam.app.action;

import by.epam.app.entity.Cone;
import by.epam.app.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ConeFactoryTests {

    @Test
    public void testGetCone() {
        Cone actual = ConeFactory.getCone(1);
        Cone finalCone = new Cone(new Point(2,2,2),5,5);

        Assert.assertEquals(actual, finalCone);
    }

    @Test
    public void testGetCones() {
        List<Cone> cones = new ArrayList<>();
        cones.add(new Cone(new Point(1,1,1),4,4));
        cones.add(new Cone(new Point(2,2,2),5,5));
        cones.add(new Cone(new Point(1,-5,2),7,7));

        List<Cone> actual = ConeFactory.getCones();

        Assert.assertEquals(actual, cones);
    }
}