package by.epam.app.action;

import by.epam.app.exception.FileIsEmptyException;
import by.epam.app.exception.FileNotExistException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextReader {

    private final static Logger logger = LogManager.getLogger();

    public static String read() {
        Path path = Paths.get("data.txt");
        StringBuilder text = new StringBuilder();

        try {

            if (Files.notExists(path)) {
                throw new FileNotExistException("File not found");
            }

            Stream<String> stringStream = Files.lines(path, Charset.forName("windows-1251"));
            stringStream.forEach(s -> text.append(s).append("\n"));

            if (text.toString().isEmpty()) {
                logger.error("File is empty");
                throw new FileIsEmptyException("File is empty");
            }

        } catch (IOException ex) {
            logger.error("IOException");
            throw new RuntimeException("IOException");
        } catch (FileNotExistException ex) {
            logger.error("File not found", ex);
            ex.printStackTrace();
        } catch (FileIsEmptyException ex) {
            logger.error("File is empty", ex);
            ex.printStackTrace();
        }

        return text.toString();
    }
}