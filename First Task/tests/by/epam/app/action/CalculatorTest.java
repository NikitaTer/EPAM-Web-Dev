package by.epam.app.action;

import by.epam.app.entity.Cone;
import by.epam.app.entity.Point;
import org.testng.Assert;
import org.testng.annotations.*;


public class CalculatorTest {

    @Test
    public void testArea() {
        Cone cone = new Cone(new Point(3,3,3),3,2);

        double result = Calculator.area(cone);

        Assert.assertEquals(result, 35.22071741263713);
    }

    @Test
    public void testVolume() {
        Cone cone = new Cone(new Point(3,3,3),3,2);

        double result = Calculator.volume(cone);

        Assert.assertEquals(result, 12.566370614359172);
    }

    @Test
    public void testIsOnPlane() {
        Cone cone = new Cone(new Point(3,0,3),3,2);

        boolean isOnPlane = Calculator.isOnPlane(cone);

        Assert.assertTrue(isOnPlane);
    }
}