package by.epam.action.builder;

import by.epam.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SaxHandler implements ContentHandler {

    private static final Logger logger = LogManager.getLogger(SaxHandler.class);
    private Locator locator;
    private List<Candy> candies;
    private Candy currentCandy;
    private CandyValue candyValue;
    private CandyIngredients candyIngredients;
    private CandyMark mark;

    public List<Candy> getCandies() {
        return candies;
    }

    public void setDocumentLocator(Locator locator){
        logger.info("Document ID :" + locator.getSystemId());
        this.locator = locator;
    }

    public void startDocument(){
        logger.info("Document parse started.");
        candies = new ArrayList<>();
    }

    public void endDocument(){
        logger.info("Document parse ended.");
    }

    public void startPrefixMapping(String prefix, String uri) {
        logger.info("Document namespace scope started.");
    }

    public void endPrefixMapping(String prefix) {
        logger.info("Document namespace scope ended.");
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {
    }

    public void processingInstruction(String target, String data) {
    }

    public void skippedEntity(String name) {
        logger.info("Not showing characters.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        logger.info("Finding starting elements in XML file.");
        CandyMark mark = CandyMark.getMatk(localName);
        switch (mark){
            case CANDY:
                logger.info("Current start element is candy object.");
                currentCandy = new Candy();
                currentCandy.setId(attributes.getValue(2));
                currentCandy.setExpiry(Integer.parseInt(attributes.getValue(1)));
                try {
                    currentCandy.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(attributes.getValue(0)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

            case VALUE:
                logger.info("Current start element is value object.");
                candyValue = new CandyValue();
                break;
            case INGREDIENTS:
                logger.info("Current start element is ingredients object.");
                candyIngredients = new CandyIngredients();
                candyIngredients.setChocolateType(attributes.getValue(0));
                break;
            default:
                logger.info("Current start element is simple type.");
                this.mark = mark;
                break;
        }
    }

    @Override
    public void characters(char[] ch,int start, final int end) {
        logger.info("Getting value of earlier found simple element and setting in field.");
        String currentElement = new String(ch,start,end).trim();
        if(mark != null) {
            switch (mark) {
                case NAME:
                    currentCandy.setName(currentElement);
                    break;
                case ENERGY:
                    currentCandy.setEnergy(Integer.parseInt(currentElement));
                    break;
                case CANDY_TYPE:
                    currentCandy.setType(CandyType.getByName(currentElement));
                    break;
                case PRODUCTION:
                    currentCandy.setProduction(currentElement);
                    break;
                case WATER:
                    candyIngredients.setWater(Integer.parseInt(currentElement));
                    break;
                case SUGAR:
                    candyIngredients.setSugar(Integer.parseInt(currentElement));
                    break;
                case FRUCTOSE:
                    candyIngredients.setFructose(Integer.parseInt(currentElement));
                    break;
                case VANILLIN:
                    candyIngredients.setVanillin(Integer.parseInt(currentElement));
                    break;
                case PROTEINS:
                    candyValue.setProteins(Integer.parseInt(currentElement));
                    break;
                case FATS:
                    candyValue.setFats(Integer.parseInt(currentElement));
                    break;
                case CARBO:
                    candyValue.setCarbo(Integer.parseInt(currentElement));
                    break;
                default:
                    logger.info("Current simple element value was not found.");
                    break;
            }
        }
        mark = null;
    }

    @Override
    public void endElement(String uri,String localName,String qName) {
        logger.info("Finding ending elements in XML file.");
        switch (CandyMark.getMatk(localName)) {
            case CANDY:
                candies.add(currentCandy);
                break;
            case VALUE:
                currentCandy.setValue(candyValue);
                break;
            case INGREDIENTS:
                currentCandy.setIngredients(candyIngredients);
                break;
        }
    }
}
