package by.epam.app.validations;

import by.epam.app.entity.Cone;
import by.epam.app.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataValidatorTest {

    @Test
    public void testFirstCheck() {
        Assert.assertTrue(DataValidator.check("-2.8 6 4.9 7 7"));
    }

    @Test
    public void testSecondCheck() {
        Assert.assertFalse(DataValidator.check("-2.8 6 4.9 7 7 4"));
    }

    @Test
    public void testThirdCheck() {
        Assert.assertFalse(DataValidator.check("-2.8 6 4.9 ,7 7"));
    }

    @Test
    public void testFourthCheck() {
        Assert.assertFalse(DataValidator.check("-2.8 6 z4.9 7 7"));
    }

    @Test
    public void testIsNotCone() {
        Cone cone = new Cone(new Point(1,1,1), -2,2);

        Assert.assertFalse(DataValidator.isCone(cone));
    }

    @Test
    public void testIsCone() {
        Cone cone = new Cone(new Point(1,1,1), 2,2);

        Assert.assertTrue(DataValidator.isCone(cone));
    }
}