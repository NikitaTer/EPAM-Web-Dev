package by.epam.app.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeWarehouseTest {

    @BeforeClass
    public void preSet() {
        Cone cone = new Cone();

        ConeWarehouse.getInstance().setArea(cone,15.0);
        ConeWarehouse.getInstance().setVolumes(cone,15.0);
        ConeWarehouse.getInstance().setVolumeCompares(cone,15.0);
        ConeWarehouse.getInstance().setIsCones(cone,true);
    }

    @Test
    public void testGetInstance() {
        Assert.assertEquals(ConeWarehouse.getInstance(), ConeWarehouse.getInstance());
    }

    @Test
    public void testSetGetArea() {
        Assert.assertEquals(ConeWarehouse.getInstance().getArea(0), 15.0);
    }

    @Test
    public void testSetGetVolumes() {
        Assert.assertEquals(ConeWarehouse.getInstance().getVolume(0), 15.0);
    }

    @Test
    public void testSetGetVolumeCompares() {
        Assert.assertEquals(ConeWarehouse.getInstance().getVolumeCompare(0), 15.0);
    }

    @Test
    public void testSetGetIsCones() {
        assertTrue(ConeWarehouse.getInstance().isCone(0));
    }
}