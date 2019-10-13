package by.epam.app.entity;

import by.epam.app.interfaces.ConeObserver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeTest {

    @Test
    public void testGetPoint() {
        Cone cone = new Cone(new Point(1,1,1),2,2);

        Point point = cone.getPoint();

        assertEquals(point, new Point(1, 1, 1));
    }

    @Test
    public void testSetPoint() {
        Cone cone = new Cone();

        Point point = new Point(1,1,1);
        cone.setPoint(point);

        assertEquals(cone.getPoint(), point);
    }

    @Test
    public void testGetHigh() {
        Cone cone = new Cone(new Point(1,1,1),2,2);

        double high = cone.getHigh();

        assertEquals(high, 2.0);
    }

    @Test
    public void testSetHigh() {
        Cone cone = new Cone();

        cone.setHigh(2);

        assertEquals(cone.getHigh(), 2.0);
    }

    @Test
    public void testGetRadius() {
        Cone cone = new Cone(new Point(1,1,1),2,2);

        double radius = cone.getRadius();

        assertEquals(radius, 2.0);
    }

    @Test
    public void testSetRadius() {
        Cone cone = new Cone();

        cone.setRadius(2);

        assertEquals(cone.getRadius(), 2.0);
    }

    @Test
    public void testGetId() {
        Cone firstCone = new Cone();
        Cone secondCone = new Cone();

        Assert.assertEquals(secondCone.getId(), 1);
    }

    @Test
    public void testToString() {
        Cone cone = new Cone(new Point(1,1,1),2,2);

        String string = cone.toString();

        assertEquals(string, "Point: x: 1.0 y: 1.0 z: 1.0 high: 2.0 radius: 2.0");
    }

    @Test
    public void testEquals() {
        Cone firstCone = new Cone(new Point(1,1,1),2,2);
        Cone secondCone = new Cone(new Point(1,2,3),4,5);

        assertFalse(firstCone.equals(secondCone));
    }
}