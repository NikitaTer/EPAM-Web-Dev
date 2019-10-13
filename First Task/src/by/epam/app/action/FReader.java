package by.epam.app.action;

import by.epam.app.exceptions.FileIsEmptyException;
import by.epam.app.exceptions.FileNotExistException;
import by.epam.app.exceptions.WrongDataException;
import by.epam.app.validations.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FReader {

    private final static Logger logger = LogManager.getLogger();

    public static ArrayList<double[]> read() {
        Path path = Paths.get("src/by/epam/data.txt");
        ArrayList<String> lines = new ArrayList<>();

        try {

            if (Files.notExists(path)) {
                throw new FileNotExistException("File not found");
            }

            Stream<String> stringStream = Files.lines(path);
            lines = (ArrayList<String>) stringStream.collect(Collectors.toList());

            if (lines.isEmpty()) {
                logger.error("File is empty");
                throw new FileIsEmptyException("File is empty");
            }

        } catch (IOException ex) {
            logger.error("IOException");
            ex.printStackTrace();
        } catch (FileNotExistException ex) {
            logger.error("File not found", ex);
            ex.printStackTrace();
        } catch (FileIsEmptyException ex) {
            logger.error("File is empty", ex);
            ex.printStackTrace();
        }

        return stringsToDoubles(lines);
    }

    private static ArrayList<double[]> stringsToDoubles(ArrayList<String> strings) {
        ArrayList<double[]> parameters = new ArrayList<>();
        try {

            for (String line : strings) {
                if (!DataValidator.check(line)) {
                    throw new WrongDataException("Incorrect data");
                }

                double[] doubleTemp = new double[5];
                String[] stringTemp = line.split(" ");

                for (int i = 0; i < doubleTemp.length; i++) {
                    doubleTemp[i] = Double.parseDouble(stringTemp[i]);
                }

                parameters.add(doubleTemp);
            }
        } catch (WrongDataException ex) {
            logger.error("Incorrect data", ex);
            ex.printStackTrace();
        }

        logger.info("Data from file was read successfully");
        return parameters;
    }
}