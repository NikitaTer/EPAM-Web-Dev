package by.epam.app.action;

import by.epam.app.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private final static Logger logger = LogManager.getLogger();

    private static int id = 0;

    public static double area(Cone cone) {
        double l = Math.hypot(cone.getHigh(), cone.getRadius());
        double result = Math.PI * cone.getRadius() * l + Math.PI * Math.pow(cone.getRadius(), 2);

        logger.info("Area calculated");

        return result;
    }

    public static double volume(Cone cone) {
        double result = Math.PI * Math.pow(cone.getRadius(), 2) * cone.getHigh() * (1.0 / 3.0);

        logger.info("Volume calculated");

        return result;
    }

    public static boolean isOnPlane(Cone cone) {
        return cone.getPoint().getY() == 0;
    }

    public static double volumeCompare(Cone cone) {
        double h1 = cone.getHigh();
        double h2 = cone.getPoint().getZ() + cone.getHigh();
        double r1 = cone.getRadius();
        double r2 = h2 * r1 / h1;
        double v1 = volume(cone);
        double v2;

        double result;

        if (h2 >= h1) {
            result = 0;
            logger.info("Cone does't intersect");
        } else {
            v2 = Math.PI * 1.0 / 3.0 * h1 * (Math.pow(r1, 2) + r1 * r2 + Math.pow(r2, 2));
            result = v1 / v2;
            logger.info("Volume Compare calculated");
        }

        return result;
    }

    public static int calculateId() {
        return id++;
    }
}
