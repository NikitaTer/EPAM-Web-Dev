package by.epam.app.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointTest {

    @Test
    public void testGetX() {
        Point point = new Point(1,1,1);

        double result = point.getX();

        Assert.assertEquals(result, 1.0);
    }

    @Test
    public void testSetX() {
        Point point = new Point();

        point.setX(2);
        double temp = point.getX();

        Assert.assertEquals(temp, 2.0);
    }

    @Test
    public void testGetY() {
        Point point = new Point(1,1,1);

        double result = point.getY();

        Assert.assertEquals(result, 1.0);
    }

    @Test
    public void testSetY() {
        Point point = new Point();

        point.setY(2);
        double temp = point.getY();

        Assert.assertEquals(temp, 2.0);
    }

    @Test
    public void testGetZ() {
        Point point = new Point(1,1,1);

        double result = point.getZ();

        Assert.assertEquals(result, 1.0);
    }

    @Test
    public void testSetZ() {
        Point point = new Point();

        point.setZ(2);
        double temp = point.getZ();

        Assert.assertEquals(temp, 2.0);
    }

    @Test
    public void testToString() {
        Point point = new Point(2,2,2);

        String string = point.toString();

        assertEquals(string, "x: 2.0 y: 2.0 z: 2.0");
    }

    @Test
    public void testEquals() {
        Point firstPoint = new Point(1,1,1);
        Point secondPoint = new Point(1,2,1);

        assertFalse(firstPoint.equals(secondPoint));
    }
}