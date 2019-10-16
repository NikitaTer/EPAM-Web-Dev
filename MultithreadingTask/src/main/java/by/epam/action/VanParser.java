package by.epam.action;

import by.epam.entity.Goods;
import by.epam.entity.Van;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VanParser {
    private final static Logger logger = LogManager.getLogger();

    public static List<Van> parse(String path) {
        Stream<String> stream;
        try {
            stream = Files.lines(Paths.get(path));
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }

        List<String> strings = stream.collect(Collectors.toList());
        List<Van> vans = new ArrayList<>();

        for (String s : strings) {
            vans.add(stringToVan(s));
        }

        logger.info("Parsed file");
        return vans;
    }

    private static Van stringToVan(String string) {
        String[] strings = string.split("\\[M\\]");
        Van van;
        if (strings.length == 2) {
            van = new Van(Boolean.parseBoolean(strings[0]));
        } else {
            van = new Van(Boolean.parseBoolean(strings[0]), new Goods(strings[1], Integer.parseInt(strings[2]), Boolean.parseBoolean(strings[3])));
        }

        return van;
    }
}