package by.epam.action.builder;

import by.epam.entity.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxBuilder implements CandyBuilder {

    private List<Candy> candies = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(SaxBuilder.class);
    private final SaxHandler handler;
    private XMLReader reader;

    public SaxBuilder(){
        logger.info("SAXBuilder creation.");
        handler = new SaxHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            logger.error("Error during SAXBuilder creation: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Candy> getCandies() {
        return candies;
    }

    @Override
    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    @Override
    public void buildCandies(String fileName){
        logger.info("Building candies by SAX parser builder.");
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            logger.error("Parser error : " + e);
        }
        logger.info("Successfully parsed XML file.");
        candies = handler.getCandies();
    }

}
