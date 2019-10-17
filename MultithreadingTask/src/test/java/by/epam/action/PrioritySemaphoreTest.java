package by.epam.action;

import by.epam.entity.Van;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PrioritySemaphoreTest {

    @Test
    public void semaphoreTest() {
        List<Van> vans = VanParser.parse("src/test/resources/data/data.txt");

        for (Van v : vans) {
            v.start();
        }

        for (Van v : vans) {
            v.stop();
        }

        boolean result = false;
        for (Van v : vans) {
            result |= v.isAlive();
        }

        assertFalse(result);
    }
}