package by.epam.app.action;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FReaderTest {

    @Test
    public void testRead() {
        ArrayList<double[]> list = new ArrayList<>();
        double[] d1 = {1.0, 1.0, 1.0, 4.0, 4.0};
        double[] d2 = {2.0, 2.0, 2.0, 5.0, 5.0};
        double[] d3 = {1.0, -5.0, 2.0, 7.0, 7.0};
        list.add(d1);
        list.add(d2);
        list.add(d3);

        Assert.assertEquals(FReader.read(), list);
    }
}