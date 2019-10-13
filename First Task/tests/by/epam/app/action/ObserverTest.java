package by.epam.app.action;

import by.epam.app.entity.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObserverTest {

    @Test
    public void observerTest() {

        ConeRepository repository = new ConeRepository();

        repository.add(new Cone(new Point(1,2,3),5,6));
        ConesObserver observer = new ConesObserver();

        repository.toList().get(0).addObserver(observer);
        repository.toList().get(0).setHigh(10);

        Assert.assertEquals(ConeWarehouse.getInstance().getArea(0), 332.91904316461034);
    }
}