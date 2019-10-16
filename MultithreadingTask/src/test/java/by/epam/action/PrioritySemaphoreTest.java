package by.epam.action;

import by.epam.entity.Goods;
import by.epam.entity.Van;
import org.testng.annotations.Test;

import java.util.concurrent.*;

import static org.testng.Assert.*;

public class PrioritySemaphoreTest {

    @Test
    public void semaphoreTest() {
        Van van1 = new Van(new Goods("1",12,false), false);
        Van van2 = new Van(new Goods("2",12,false), false);
        Van van3 = new Van(new Goods("3",12,false), false);
        Van van4 = new Van(new Goods("4",12,true), false);
        Van van5 = new Van(new Goods("5",12,false), false);

        van1.start();
        van2.start();
        van3.start();
        van4.start();
        van5.start();

        van1.stop();
        van2.stop();
        van3.stop();
        van4.stop();
        van5.stop();
    }
}