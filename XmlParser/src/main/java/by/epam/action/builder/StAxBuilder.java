package by.epam.action.builder;

import by.epam.entity.*;
import by.epam.exception.XmlParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.print.attribute.standard.NumberUp;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StAxBuilder implements CandyBuilder {

    private List<Candy> candies = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(StAxBuilder.class);
    private final XMLInputFactory factory;

    public StAxBuilder(){
        factory = XMLInputFactory.newInstance();
    }

    @Override
    public List<Candy> getCandies() {
        return candies;
    }

    @Override
    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    public void buildCandies(String fileName){
        logger.info("Building candies with StAX parsers builder.");
        XMLStreamReader reader;
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))){
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                    String tagName = reader.getLocalName();
                    if (CandyMark.getMatk(tagName).equals(CandyMark.CANDY)) {
                        Candy candy = buildCandy(reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException | IOException | ParseException | XmlParserException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    private Candy buildCandy(XMLStreamReader reader) throws XMLStreamException, ParseException, XmlParserException {
        logger.info("Building new candy with StAX parser builder.");
        Candy candy = new Candy();
        candy.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(reader.getAttributeValue(null,CandyMark.DATE.getValue())));
        candy.setExpiry(Integer.parseInt(reader.getAttributeValue(null,CandyMark.EXPIRY.getValue())));
        candy.setId(reader.getAttributeValue(null,CandyMark.ID.getValue()));
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (CandyMark.getMatk(reader.getLocalName())) {
                        case NAME:
                            candy.setName(getTextData(reader));
                            break;
                        case PRODUCTION:
                            candy.setProduction(getTextData(reader));
                            break;
                        case ENERGY:
                            candy.setEnergy(Integer.parseInt(getTextData(reader)));
                            break;
                        case CANDY_TYPE:
                            candy.setType(CandyType.getByName(getTextData(reader)));
                            break;
                        case INGREDIENTS:
                            candy.setIngredients(buildIngredients(reader));
                            break;
                        case VALUE:
                            candy.setValue(buildValue(reader));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if(CandyMark.getMatk(reader.getLocalName()) == CandyMark.CANDY){
                        logger.info("Finishing of candy building.");
                        return candy;
                    }
                    break;
            }
        }
        throw new XmlParserException("Unknown name.");
    }

    private CandyIngredients buildIngredients(XMLStreamReader reader) throws XMLStreamException, XmlParserException {
        logger.info("Building new ingredients with StAX parser builder.");
        CandyIngredients ingredients = new CandyIngredients();
        ingredients.setChocolateType(reader.getAttributeValue(null,CandyMark.CHOCOLATE_TYPE.getValue()));
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (CandyMark.getMatk(reader.getLocalName())) {
                        case WATER:
                            ingredients.setWater(Integer.parseInt(getTextData(reader)));
                            break;
                        case SUGAR:
                            ingredients.setSugar(Integer.parseInt(getTextData(reader)));
                            break;
                        case FRUCTOSE:
                            ingredients.setFructose(Integer.parseInt(getTextData(reader)));
                            break;
                        case VANILLIN:
                            ingredients.setVanillin(Integer.parseInt(getTextData(reader)));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (CandyMark.getMatk(reader.getLocalName()) == CandyMark.INGREDIENTS) {
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XmlParserException("Unknown name.");
    }


    private CandyValue buildValue(XMLStreamReader reader) throws XMLStreamException, XmlParserException {
        logger.info("Building new value with StAX parser builder.");
        CandyValue value = new CandyValue();

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (CandyMark.getMatk(reader.getLocalName())) {
                        case PROTEINS:
                            value.setProteins(Integer.parseInt(getTextData(reader)));
                            break;
                        case CARBO:
                            value.setCarbo(Integer.parseInt(getTextData(reader)));
                            break;
                        case FATS:
                            value.setFats(Integer.parseInt(getTextData(reader)));
                            break;
                        default:
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    if (CandyMark.getMatk(reader.getLocalName()) == CandyMark.VALUE) {
                        return value;
                    }
                    break;
            }
        }
        throw new XmlParserException("Unknown name");
    }

    private String getTextData(final XMLStreamReader reader) throws XMLStreamException {
        if (reader.hasNext()) {
            reader.next();
            return reader.getText();
        }
        throw new RuntimeException("Illegal XSD file format.");
    }
}
