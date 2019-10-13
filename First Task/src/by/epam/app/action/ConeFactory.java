package by.epam.app.action;

import by.epam.app.entity.Cone;
import by.epam.app.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeFactory {

    private final static Logger logger = LogManager.getLogger();

    public static Cone getCone(int number) {
        double[] param = FReader.read().get(number);
        Cone cone = new Cone(new Point(param[0], param[1], param[2]), param[3], param[4]);
        logger.info("Cone was initialized");
        return cone;
    }

    public static List<Cone> getCones() {
        List<double[]> param = FReader.read();
        List<Cone> cones = new ArrayList<>();

        for (double[] d : param) {
            cones.add(new Cone(new Point(d[0], d[1], d[2]), d[3], d[4]));
        }

        logger.info("List of Cones was initialized");

        return cones;
    }
}
